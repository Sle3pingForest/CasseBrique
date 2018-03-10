package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public class Wall{
    protected int nbL;
    protected int nbC;
    protected Brick wall[][];

    static final int wallInt[][] = {
       {0,2,0,1,0,0,1,0,2,0},
        {0,0,2,0,1,1,0,2,0,0},
        {0,0,0,2,0,0,2,0,0,0},
        {0,0,0,0,2,2,0,0,0,0},
        {3,0,3,3,0,0,3,3,0,3}};

    public Wall(){
        this.nbL = wallInt.length;
        this.nbC = wallInt[0].length;
        this.wall = new Brick[this.nbL][this.nbC];
        setBricks(false);
    }


    public void setBricks(boolean alea) {
        if ( !alea ) {
            Vector2 bg = new Vector2();
            bg.x = TextureFactory.getTexBorder().getWidth();
            bg.y = Gdx.graphics.getHeight() - 3*TextureFactory.getTexBorder().getHeight() - this.nbL * TextureFactory.getTexBlueBrick().getHeight();
            for(int lig = 1 ; lig <= this.nbL; ++lig){
                for(int col = 0; col < this.nbC; ++col){
                    float posCol = bg.x + col* TextureFactory.gettexBlueBrick().getWidth();
                    float posLig = bg.y + lig* TextureFactory.gettexBlueBrick().getHeight();
                    switch (wallInt[getNbL() - lig][col]) {
                        case 0:
                            wall[getNbL() - lig][col] = new BlueBrick( new Vector2(posCol, posLig),1);
                            break;
                        case 1:
                            wall[getNbL() - lig][col] = new GreenBrick( new Vector2(posCol, posLig),1);
                            break;
                        case 2:
                            wall[getNbL() - lig][col] = new GreenBrick( new Vector2(posCol, posLig),2);
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

    public static int[][] getWallInt() {
        return wallInt;
    }

    public Brick[][] getWall() {
        return this.wall;
    }

    public int getNbL() {
        return nbL;
    }

    public int getNbC() {
        return nbC;
    }
}
