package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import fr.ul.cassebrique.dataFactories.TextureFactory;
import views.GameScreen;

/**
 * Created by Sle3pingForest on 26/01/2018.
 */

public class GameWorld {
    protected GameScreen gs;
    protected Wall wall;
    protected Background bg;
    protected Racket racket;
    protected ArrayList<Ball> listeBalle;
    protected Ball bille;
    protected World world;
    protected int nbIntV = 6;
    protected int nbItP = 2;
    static final float METERS_TO_PIXELS = 250;
    static final float PIXELS_TO_METERS = 1/METERS_TO_PIXELS;

    public GameWorld(GameScreen gs){
        this.gs = gs;
        this.world = new World(new Vector2(0,0f),true);
        this.wall = new Wall();
        this.bg = new Background();
        this.racket = new Racket();
        this.bille = new Ball(this,new Vector2(this.getRacket().getPos().x + TextureFactory.getTexRacket().getWidth()/2 - Ball.getRayon() , TextureFactory.getTexRacket().getHeight()/2 + this.getRacket().getPos().y + Ball.getRayon() ));
        this.listeBalle = new ArrayList<Ball>();
        for(int i = 0 ; i < 2; ++i){
            Vector2 pos = new Vector2(Gdx.graphics.getWidth() - TextureFactory.getTexBorder().getWidth()/2 - Ball.getRayon(), Ball.getRayon() + i * TextureFactory.getTexBorder().getHeight());
            this.listeBalle.add(new Ball(this,pos));
        }
    }

    public void draw(SpriteBatch sb){
        this.world.step(Gdx.graphics.getDeltaTime()+100,this.nbIntV, this.nbItP);
        this.bg.draw(sb);
        this.wall.draw(sb);
        this.racket.draw(sb);
        this.bille.draw(sb);
        for(int i = 0 ; i < 2; ++i){
            this.listeBalle.get(i).draw(sb);
        }
        update();

    }
    public Racket getRacket() {
        return racket;
    }

    public void update(){
        this.world.step(Gdx.graphics.getDeltaTime()+ 100,this.nbIntV, this.nbItP);
    }

    public static float getMeterToPixels(){
        return METERS_TO_PIXELS;
    }

    public static  float getPixelsToMeters(){
        return PIXELS_TO_METERS;
    }
    public World getWorld(){
        return this.world;
    }
}

