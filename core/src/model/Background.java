package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 03/02/2018.
 */

public class Background {

    protected GameWorld gw;
    protected Body body;

    public Background(GameWorld gw){
        this.gw = gw;
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
        tab[0] = new Vector2(convert*(TextureFactory.getTexBack().getWidth()  - TextureFactory.getTexBack().getWidth() + TextureFactory.getTexBorder().getWidth()), 0);
        tab[1] = new Vector2(convert*(TextureFactory.getTexBack().getWidth() - TextureFactory.getTexBack().getWidth() + TextureFactory.getTexBorder().getWidth()),
                convert*(TextureFactory.getTexBack().getHeight() - TextureFactory.getTexBorder().getHeight()));
        tab[2] = new Vector2(convert*(TextureFactory.getTexBack().getWidth() - 2 * TextureFactory.getTexBorder().getWidth()),
                convert*(TextureFactory.getTexBack().getHeight() - TextureFactory.getTexBorder().getHeight()));
        tab[3] = new Vector2(convert*(TextureFactory.getTexBack().getWidth() - 2 * TextureFactory.getTexBorder().getWidth()), 0);

        ChainShape shape = new ChainShape();
        shape.createChain(tab);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.density = 1f;
        fdef.restitution = 1f;
        fdef.friction = 0f;
        body.createFixture(fdef);

        body.setUserData(this);
    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexBack(), 0, 0);
        sb.end();
    }
}
