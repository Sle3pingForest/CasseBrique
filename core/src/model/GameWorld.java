package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

import javax.xml.bind.SchemaOutputResolver;

import fr.ul.cassebrique.dataFactories.SoundFactory;
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
    protected Body refA, refB;
    static final float METERS_TO_PIXELS = 250;
    static final float PIXELS_TO_METERS = 1/METERS_TO_PIXELS;
    protected int nbBille = 2;
    public static boolean plusDeBall = false;
    public static boolean perteBall = false;

    public GameWorld(GameScreen gs){
        this.gs = gs;
        this.world = new World(new Vector2(0f,0f),true);
        this.wall = new Wall(this);
        this.bg = new Background(this);
        this.racket = new Racket(this, new Vector2((TextureFactory.getTexBack().getWidth() -  TextureFactory.getTexBorder().getWidth() - TextureFactory.getTexRacket().getWidth())/2   ,50));
        Vector2 v = new Vector2((TextureFactory.getTexBack().getWidth() - TextureFactory.getTexBorder().getWidth())/2, 70);
        this.bille = new Ball(this,v,true);
        creBille(this.nbBille);
        this.world.setVelocityThreshold(0);
        this.world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Vector2 norm = contact.getWorldManifold().getNormal();
                int x = 1;
                int y = 1;
                if(norm.x != 0){
                    x = - 1;
                }
                if(norm.y != 0){
                    y = -1;
                }

                refA = contact.getFixtureA().getBody();
                refB = contact.getFixtureB().getBody();
                Body ballRef = refA;
                if(refB.getUserData() instanceof Ball){
                    ballRef = refB;
                    refB = refA;
                }

                if(ballRef.getUserData() instanceof Ball){
                    if(refB.getUserData() instanceof BlueBrick){
                        ((BlueBrick) refB.getUserData()).setNb_cp_sp(1);
                        wall.addDestroy(refB);
                        SoundFactory.getCollision().play(1.0f);
                    }
                    if(refB.getUserData() instanceof GreenBrick ) {
                        ((GreenBrick) refB.getUserData()).setNb_cp_sp(1);
                        if(((GreenBrick) refB.getUserData()).getNb_cp_sp() == 0){
                            wall.addDestroy(refB);
                        }
                        SoundFactory.getCollision().play(1.0f);
                    }
                    if(refB.getUserData() instanceof Racket){
                        float facteurAcc = (refB.getPosition().x +TextureFactory.getTexRacket().getWidth()/2)*GameWorld.PIXELS_TO_METERS - (ballRef.getPosition().x+ Ball.rayon)*PIXELS_TO_METERS;

                        if(facteurAcc > 0){
                            ballRef.setLinearVelocity(ballRef.getLinearVelocity().x-(3*facteurAcc),  ballRef.getLinearVelocity().y);
                        }
                        else{
                            ballRef.setLinearVelocity(ballRef.getLinearVelocity().x+(3*facteurAcc), ballRef.getLinearVelocity().y);
                        }

                        SoundFactory.getImpact().play(1.0f);
                    }
                    if(refB.getUserData() instanceof Background){
                        SoundFactory.getCollision().play(1.0f);
                        ballRef.setLinearVelocity(x * ballRef.getLinearVelocity().x, y* ballRef.getLinearVelocity().y);
                    }
                }
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });

    }


    public void draw(SpriteBatch sb){
        this.world.step(Gdx.graphics.getDeltaTime(),this.nbIntV, this.nbItP);
        this.wall.desTroy();
        this.bg.draw(sb);
        this.wall.draw(sb);
        this.racket.draw(sb);
        checkBille();
        this.bille.draw(sb);
        for(int i = 0 ; i < this.nbBille; ++i){
            this.listeBalle.get(i).draw(sb);
        }

    }

    public void checkBille(){
        if(this.bille.sortieJeu() && this.nbBille > 0){
            /*this.getWorld().destroyBody(this.bille.body);
            this.getWorld().destroyBody(this.racket.bodyCd);
            this.getWorld().destroyBody(this.racket.bodyCg);
            this.getWorld().destroyBody(this.racket.bodyRect);
            this.getWorld().destroyBody(this.listeBalle.get(1).body);*/
            this.clear();
            this.bille = new Ball(this,new Vector2((TextureFactory.getTexBack().getWidth() - TextureFactory.getTexBorder().getWidth())/2, 80),true);
            this.racket = new Racket(this, new Vector2((TextureFactory.getTexBack().getWidth() -  TextureFactory.getTexBorder().getWidth() - TextureFactory.getTexRacket().getWidth())/2   ,50));
            this.nbBille--;
            creBille(this.nbBille);
            this.plusDeBall = false;
            this.perteBall = true;

        }
        else{
            if(this.bille.sortieJeu() && this.nbBille == 0){
                this.plusDeBall = true;
            }
        }
    }

    public void clear(){
        this.bille.desTroyBody();
        this.racket.destroyBodyRacket();
        for(int i = 0 ; i < this.nbBille; i++) {
            this.listeBalle.get(i).desTroyBody();
        }

    }

    public void creBille(int nbB){
        this.listeBalle = new ArrayList<Ball>();
        for(int i = 0 ; i < nbB; i++){
            Vector2 pos = new Vector2(TextureFactory.getTexBack().getWidth() - TextureFactory.getTexBorder().getWidth()/2 ,25+50*(i));
            this.listeBalle.add(new Ball(this,pos, false));
        }
        plusDeBall = false;
    }

    public void reStart(GameState s, int a){
        this.wall.desTroyAll();
        this.wall = new Wall(this);
        if(s.getState() == State.GameOver){
            creBille(a);
        }
        if(s.getState() == State.Won){
            a++;
            creBille(a);
            this.nbBille = a;
        }
    }


    public Racket getRacket() {
        return racket;
    }


    public int getNbBille(){
        return this.nbBille;
    }


    public Ball getBille(){
        return this.bille;
    }

    public void setnbBille(int a){
        this.nbBille = a;
    }

    public Wall getWall(){
        return this.wall;
    }

    public World getWorld(){
        return this.world;
    }
}

