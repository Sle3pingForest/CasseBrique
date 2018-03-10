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
    private static float rayon = 12;
    protected GameWorld gw;
    protected Vector2 pos;
    protected Body body;

    public Ball(GameWorld gw, Vector2 position){
        this.gw = gw;
        this.pos = position;
        this.gw = gw;
        creationBody();
    }
    private void creationBody(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(pos.x, pos.y);
        bdef.bullet = true;
        bdef.fixedRotation = true;
        body = this.gw.getWorld().createBody(bdef);
        FixtureDef fdef = new FixtureDef();
        Shape shape = new CircleShape();
        fdef.shape = shape;
        fdef.density = 1f;
        fdef.restitution = 1f;
        fdef.friction = 0f;
        body.createFixture(fdef);
        shape.dispose();

        setSpeed();

    }

    public void setSpeed(){
        float horizontal =(float) Math.random()* 400 ;
        this.body.setLinearVelocity(horizontal,200 * gw.getMeterToPixels());
    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexBall(), this.pos.x , this.pos.y);
        sb.end();
    }

    public static float getRayon(){
        return rayon;
    }


}
