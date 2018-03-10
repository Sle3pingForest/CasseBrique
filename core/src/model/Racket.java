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
 * Created by SleepingForest on 03/02/2018.
 */

public class Racket {
    protected GameWorld gw;
    protected Vector2 pos;
    protected int largeur, hauteur;
    public static final int deplacement = 10;
    protected Body bodyCg,bodyCd,bodyRect;
    float convert = GameWorld.PIXELS_TO_METERS;


    public Racket(GameWorld gw, Vector2 position){
        this.largeur = TextureFactory.getTexRacket().getWidth();
        this.hauteur = TextureFactory.getTexRacket().getHeight();
        this.pos = position;
        this.gw = gw;
        creationBody();
    }

    private void creationBody(){
        BodyDef bdefCg = new BodyDef();
        BodyDef bdefCd = new BodyDef();
        BodyDef bdefRect = new BodyDef();

        bdefCg.type = BodyDef.BodyType.StaticBody;
        bdefCg.bullet = false;
        bdefCg.fixedRotation = false;

        bdefCd.type = BodyDef.BodyType.StaticBody;
        bdefCd.bullet = false;
        bdefCd.fixedRotation = false;

        bdefRect.type = BodyDef.BodyType.StaticBody;
        bdefRect.bullet = false;
        bdefRect.fixedRotation = false;


        bodyCd = this.gw.getWorld().createBody(bdefCd);
        bodyCg = this.gw.getWorld().createBody(bdefCg);
        bodyRect = this.gw.getWorld().createBody(bdefRect);




        FixtureDef fdefCg = new FixtureDef();
        fdefCg.density = 1f;
        fdefCg.restitution = 1f;
        fdefCg.friction = 0f;

        FixtureDef fdefCd = new FixtureDef();
        fdefCd.density = 1f;
        fdefCd.restitution = 1f;
        fdefCd.friction = 0f;


        Shape shapeCg = new CircleShape();
        Shape shapeCd = new CircleShape();
        shapeCg.setRadius(10*convert);
        shapeCd.setRadius(10*convert);

        PolygonShape shape = new PolygonShape();
        Vector2[] tab = new Vector2[4];

        tab[0] = new Vector2(convert*(pos.x + 20) ,convert*pos.y);
        tab[1] = new Vector2(convert*(pos.x + 20), convert*(pos.y + hauteur));
        tab[2] = new Vector2(convert*(pos.x + largeur - 20), convert*(pos.y + hauteur));
        tab[3] = new Vector2(convert*(pos.x+ largeur - 20),convert*pos.y);

        shape.set(tab);

        FixtureDef fdef = new FixtureDef();
        fdef.density = 1f;
        fdef.restitution = 1f;
        fdef.friction = 0f;

        fdef.shape = shape;
        fdefCd.shape = shapeCd;
        fdefCg.shape = shapeCd;


        bodyCg.createFixture(fdefCg);
        bodyRect.createFixture(fdef);
        bodyCd.createFixture(fdefCd);

        bodyCg.setTransform((pos.x+10)*convert, (pos.y+10)*convert,0);
        bodyCd.setTransform(convert*(pos.x + largeur - 10),convert*(pos.y+10),0);
        shapeCd.dispose();
        shapeCg.dispose();
        shape.dispose();

        bodyCg.setUserData(this);
        bodyRect.setUserData(this);
        bodyCd.setUserData(this);


    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexRacket(), pos.x  , pos.y  );
        sb.end();

    }

    public void droite(){
        if(this.getPos().x  + TextureFactory.getTexRacket().getWidth() < TextureFactory.getTexBack().getWidth() - 2 * TextureFactory.getTexBorder().getWidth()){
            this.getPos().x  += deplacement;
            bodyRect.setTransform(bodyRect.getPosition().x  + deplacement * convert, bodyRect.getPosition().y, 0);
            bodyCd.setTransform(bodyCd.getPosition().x  + deplacement * convert, bodyCd.getPosition().y,0);
            bodyCg.setTransform(bodyCg.getPosition().x  + deplacement * convert, bodyCg.getPosition().y,0);
        }
    }
    public void gauche(){
        if(this.getPos().x  > TextureFactory.getTexBorder().getWidth()  ){
            this.getPos().x -= deplacement;
            bodyRect.setTransform(bodyRect.getPosition().x  - deplacement * convert, bodyRect.getPosition().y, 0);
            bodyCd.setTransform(bodyCd.getPosition().x  - deplacement * convert, bodyCd.getPosition().y,0);
            bodyCg.setTransform(bodyCg.getPosition().x  - deplacement * convert, bodyCg.getPosition().y,0);
        }
    }

    public void setGw(GameWorld gw) {
        this.gw = gw;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }


    public GameWorld getGw() {
        return gw;

    }

    public Body getBodyCg(){
        return this.bodyCg;
    }

    public Body getBodyCd(){
        return this.bodyCd;
    }
    public Body getBodyRect(){
        return this.bodyRect;
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
