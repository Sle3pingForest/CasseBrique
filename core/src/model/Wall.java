package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import com.badlogic.gdx.physics.box2d.Body;

import java.util.ArrayList;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public class Wall{
    protected int nbL;
    protected int nbC;
    protected int nbRestant;
    protected int nbBrickTotal;
    protected GameWorld gw;
    protected Brick wall[][];
    protected ArrayList<Body> listBodyDestroy;
    protected int comptBody;

    /*static final int wallInt[][] = {
            {0,2,0,1,0,0,1,0,2,0},
            {0,0,2,0,1,1,0,2,0,0},
            {0,0,0,2,0,0,2,0,0,0},
            {0,0,0,0,2,2,0,0,0,0},
            {3,0,3,3,0,0,3,3,0,3}};*/

    static final int wallInt[][] = {
            {3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,1,3,3,3,3}};

    public Wall(GameWorld gw){
        this.gw = gw;
        this.nbL = wallInt.length;
        this.nbC = wallInt[0].length;
        this.wall = new Brick[this.nbL][this.nbC];
        this.listBodyDestroy= new ArrayList<Body>();
        this.nbBrickTotal = 0;
        this.comptBody = 0;
        setBricks(false);
    }


    public void setBricks(boolean alea) {
        if ( !alea ) {
            Vector2 bg = new Vector2();
            bg.x = TextureFactory.getTexBorder().getHeight();
            bg.y = TextureFactory.getTexBack().getHeight() - 3*TextureFactory.getTexBorder().getHeight();
            for(int lig = 1 ; lig <= this.nbL; ++lig){
                for(int col = 0; col < this.nbC; ++col){
                    float posCol = bg.x + col* TextureFactory.getTexBlueBrick().getWidth();
                    float posLig = bg.y - (this.nbL - lig + 1)* TextureFactory.getTexBlueBrick().getHeight();
                    switch (wallInt[getNbL() - lig][col]) {
                        case 0:
                            wall[getNbL() - lig][col] = new BlueBrick(this.gw, new Vector2(posCol, posLig),1);
                            nbBrickTotal++;
                            comptBody++;
                            break;
                        case 1:
                            wall[getNbL() - lig][col] = new GreenBrick(this.gw, new Vector2(posCol, posLig),1);
                            nbBrickTotal++;

                            comptBody++;
                            break;
                        case 2:
                            wall[getNbL() - lig][col] = new GreenBrick(this.gw, new Vector2(posCol, posLig),2);
                            nbBrickTotal++;
                            comptBody++;
                            break;
                        case 3:
                            wall[getNbL() - lig][col] = null;
                            break;

                    }

                }
            }
        }
        else{

        }
    }

    public void draw(SpriteBatch sb){
        for(int lig = 0 ; lig < this.nbL; ++lig){
            for(int col = 0; col < this.nbC; ++col){
                if (this.wall[lig][col] != null) {
                    this.wall[lig][col].draw(sb);

                }
            }
        }
    }


    public void addDestroy(Body b){
        this.listBodyDestroy= new ArrayList<Body>();
        this.listBodyDestroy.add(b);
    }

    public void desTroy(){
        //nbRestant = this.nbBrickTotal - this.listBodyDestroy.size();
        for(int i = 0 ; i <this.listBodyDestroy.size(); ++i){
            //this.listBodyDestroy.get(i).setActive(false);
            this.gw.getWorld().destroyBody(this.listBodyDestroy.get(i));
            setComptBody();
        }
        this.listBodyDestroy.clear();
    }

    public int getComptBody(){
        return this.comptBody;
    }

    public void setComptBody(){
        this.comptBody--;
    }
/*
    public boolean estVide(){
        if(nbRestant <= 0){
            return true;
        }
        else{
            return false;
        }
    }
*/
    public int getNbRestant(){
        return this.nbRestant;
    }

    public int getNbL() {
        return nbL;
    }

}
