package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 02/02/2018.
 */

public abstract class Brick {
    protected Vector2 pos;
    protected int nb_cp_sp;
    protected GameWorld gw;
    protected Body body;
    protected FixtureDef fdef;


    public Brick(GameWorld gw, Vector2 pos, int nb){
        this.gw = gw;
        this.nb_cp_sp = nb;
        this.pos = pos;
        creationBody();
    }

    private void creationBody(){
        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.bullet = false;
        bdef.fixedRotation = false;
        body = this.gw.getWorld().createBody(bdef);

        float convert = GameWorld.PIXELS_TO_METERS;
        Vector2[] tab = new Vector2[4];
        tab[0] = new Vector2(convert*pos.x,convert*pos.y);
        tab[1] = new Vector2(convert*pos.x, convert*(pos.y + TextureFactory.getTexBlueBrick().getHeight()));
        tab[2] = new Vector2(convert*(pos.x+ TextureFactory.getTexBlueBrick().getWidth()), convert*(pos.y + TextureFactory.getTexBlueBrick().getHeight()));
        tab[3] = new Vector2(convert*(pos.x+ TextureFactory.getTexBlueBrick().getWidth()),convert*pos.y);
        fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.set(tab);
        fdef.shape = shape;
        fdef.density = 1f;
        fdef.restitution = 1f;
        fdef.friction = 0f;
        body.createFixture(fdef);
        shape.dispose();
        //body.setUserData(this);

    }

    public FixtureDef getFdef() {
        return fdef;
    }

    public abstract String getName();
    public abstract void setNb_cp_sp(int i);
    public abstract int getNb_cp_sp();
    public abstract void draw(SpriteBatch spriteBatch);
};
