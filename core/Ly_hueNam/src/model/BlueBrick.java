package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 02/02/2018.
 */

public class BlueBrick extends Brick {
    protected String name;

    public BlueBrick(Vector2 pos, int nb){
        super(pos,nb);
        this.name = "Blue";
    }

    public BlueBrick(Vector2 pos){
        super(pos, 1);
    }


    @Override
    public void draw(SpriteBatch sb) {
        sb.begin();
        sb.draw(TextureFactory.gettexBlueBrick(), this.position.x, this.position.y);
        sb.end();
    }

    @Override
    public String getName(){
        return this.name;
    }
}
