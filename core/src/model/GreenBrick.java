package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 02/02/2018.
 */

public class GreenBrick extends Brick {

    protected String name;

    public GreenBrick(GameWorld  gw,Vector2 pos, int nb){
        super(gw,pos,nb);
        this.body.setUserData(this);
        this.name ="Green";
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
            sb.begin();
            sb.draw(TextureFactory.getTexGreenBrickA(), this.pos.x, this.pos.y);
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
