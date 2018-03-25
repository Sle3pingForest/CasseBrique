package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import fr.ul.cassebrique.dataFactories.TextureFactory;


/**
 * Created by Sle3pingForest on 24/03/2018.
 */

public class Ball2DAnime extends Ball {

    protected Array<Sprite> imsBoule;
    protected TextureAtlas atlasBoule;
    protected int numIm = 10;
    protected float angleRot = 0;

    public Ball2DAnime(GameWorld gw, Vector2 position, boolean enjeu){
        super(gw,position,enjeu);
        this.atlasBoule =  new TextureAtlas(Gdx.files.internal("images/Boule.pack"));
        this.imsBoule = new Array<Sprite>();
        this.imsBoule = this.atlasBoule.createSprites("boule");
    }

    public void calculAffichage(){
        double xCarre = this.pos.x * this.pos.x;
        double yCarre = this.pos.y * this.pos.y;
        float dist = (float)Math.sqrt(xCarre + yCarre) * Gdx.graphics.getDeltaTime() / 2;
        angleRot = dist / this.rayon;
        float imsParS = angleRot * imsBoule.size / (float)(2 * Math.PI);
        this.numIm = (int)(numIm + imsParS) % imsBoule.size;
    }

    @Override
    public void draw( SpriteBatch sb){
        calculAffichage();
        Sprite sp  = imsBoule.get(this.numIm);
        sp.setOriginCenter();
        sp.setRotation(this.angleRot);
        sp.setBounds(this.pos.x - rayon , this.pos.y - rayon, 2*rayon , 2*rayon);
        sb.begin();
        sb.draw(sp,this.body.getPosition().x * GameWorld.METERS_TO_PIXELS - rayon , this.body.getPosition().y * GameWorld.METERS_TO_PIXELS - rayon,
                TextureFactory.getTexBall().getWidth(),TextureFactory.getTexBall().getHeight());
        sb.end();
    }
}
