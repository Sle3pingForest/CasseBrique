package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 03/02/2018.
 */

public class Ball {
    public static float rayon = 12;
    protected GameWorld gw;
    protected Vector2 pos;
    protected Body body;
    protected boolean enjeu;

    public Ball(GameWorld gw, Vector2 position, boolean enjeu){
        this.gw = gw;
        this.pos = position;
        this.enjeu = enjeu;
        creationBody();


    }
    private void creationBody(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.bullet = true;
        bdef.fixedRotation = true;
        body = this.gw.getWorld().createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        Shape shape = new CircleShape();
        shape.setRadius(rayon*GameWorld.PIXELS_TO_METERS);
        fdef.shape = shape;
        fdef.density = 1f;
        fdef.restitution = 1f;
        fdef.friction = 0f;
        body.createFixture(fdef);
        shape.dispose();
        body.setTransform(pos.x*GameWorld.PIXELS_TO_METERS, pos.y*GameWorld.PIXELS_TO_METERS ,0);
        setSpeed();
        body.setUserData(this);

    }

    private void setSpeed(){
        float d = (float) ((Math.random() * 400) - 200);
        if(this.enjeu){
            this.body.setLinearVelocity(d   * GameWorld.PIXELS_TO_METERS,  200 * GameWorld.PIXELS_TO_METERS);
        }
        else{
            this.body.setLinearVelocity(0,0);
        }
    }

    public boolean sortieJeu(){
        if(this.body.getPosition().y < 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void desTroyBody(){
        this.gw.getWorld().destroyBody(this.body);
    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexBall(), this.body.getPosition().x * GameWorld.METERS_TO_PIXELS - rayon, this.body.getPosition().y * GameWorld.METERS_TO_PIXELS - rayon);
        sb.end();
    }


    public void setPos(Vector2 pos){
        this.pos = pos;

    }

    public Vector2 getPosBall(){
        return pos;
    }

}
