package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 03/02/2018.
 */

public class Racket {
    protected GameWorld gw;
    protected Vector2 pos;
    protected int largeur, hauteur;
    public static final int deplacement = 10;


    public Racket(){
        this.largeur = TextureFactory.getTexRacket().getWidth();
        this.hauteur = TextureFactory.getTexRacket().getHeight();
        this.pos = new Vector2((Gdx.graphics.getWidth() - TextureFactory.getTexRacket().getWidth() - TextureFactory.getTexBorder().getWidth())/2,50);
    }


    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexRacket(), this.pos.x, this.pos.y);
        sb.end();

    }

    public void droite(){
        if(this.getPos().x + TextureFactory.getTexRacket().getWidth() < Gdx.graphics.getWidth() - 2 * TextureFactory.getTexBorder().getWidth()){
            this.getPos().x += deplacement;
        }
    }
    public void gauche(){
        if(this.getPos().x  > TextureFactory.getTexBorder().getWidth() ){
            this.getPos().x -= deplacement;
        }
    }

    public void setGw(GameWorld gw) {
        this.gw = gw;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public GameWorld getGw() {
        return gw;

    }

    public Vector2 getPos() {
        return pos;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}
