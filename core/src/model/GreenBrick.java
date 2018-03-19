package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 02/02/2018.
 */

public class GreenBrick extends Brick {

    protected String name;
    protected Animation animation;
    protected TextureAtlas atlasBrick;
    protected Array<TextureAtlas.AtlasRegion> lisIms;
    protected float tempAnim;

    public GreenBrick(GameWorld  gw,Vector2 pos, int nb){
        super(gw,pos,nb);
        this.body.setUserData(this);
        this.name ="Green";
        this.atlasBrick = new TextureAtlas(Gdx.files.internal("images/Anim2Ca.pack"));
        this.lisIms = new Array<TextureAtlas.AtlasRegion>();
        this.lisIms =  this.atlasBrick.findRegions("Anim2Ca");
        animation = new Animation(2,lisIms,Animation.PlayMode.LOOP);
    }

    public GreenBrick(GameWorld gw, Vector2 pos){
        super(gw,pos,2);
    }

    @Override
    public void draw(SpriteBatch sb){
        if(this.nb_cp_sp == 1){
            sb.begin();
            sb.draw(TextureFactory.getTexGreenBrickB(), this.pos.x, this.pos.y);
            sb.end();
        }
        if(this.nb_cp_sp == 2){
            /*sb.begin();
            sb.draw(TextureFactory.getTexGreenBrickA(), this.pos.x, this.pos.y);
            sb.end();*/
            tempAnim += Gdx.graphics.getDeltaTime();
            sb.begin();
            TextureRegion im = (TextureRegion)animation.getKeyFrame(tempAnim);
            sb.draw(im, this.pos.x, this.pos.y);
            sb.end();
        }
    }

    @Override
    public void setNb_cp_sp(int i){
        this.nb_cp_sp -=i;
    }

    @Override
    public int getNb_cp_sp(){
        return this.nb_cp_sp;
    }

    @Override
    public String getName(){
        return this.name;
    }
}
