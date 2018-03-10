package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 02/02/2018.
 */

public class BlueBrick extends Brick {
    protected String name;

    public BlueBrick(GameWorld gw,Vector2 pos, int nb){
        super(gw,pos,nb);
        this.body.setUserData(this);
        this.name = "Blue";
    }

    public BlueBrick(GameWorld gw,Vector2 pos){
        super(gw,pos, 1);
    }


    @Override
    public void draw(SpriteBatch sb) {
        sb.begin();
        if(nb_cp_sp == 1){
            sb.draw(TextureFactory.getTexBlueBrick(), this.pos.x, this.pos.y);
        }
        sb.end();
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void setNb_cp_sp(int i){
        this.nb_cp_sp -=i;
    }

    @Override
    public int getNb_cp_sp(){
        return this.nb_cp_sp;
    }
}
