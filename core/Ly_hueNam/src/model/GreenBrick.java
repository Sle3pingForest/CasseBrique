package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 02/02/2018.
 */

public class GreenBrick extends Brick {

    protected String name;

    public GreenBrick(Vector2 pos, int nb){
        super(pos,nb);
    }

    public GreenBrick(Vector2 pos){
        super(pos,2);
    }

    @Override
    public void draw(SpriteBatch sb){
        if(this.nb_cp_sp == 1){
            sb.begin();
            sb.draw(TextureFactory.gettexGreenBrickB(), this.position.x, this.position.y);
            sb.end();
        }
        if(this.nb_cp_sp == 2){
            sb.begin();
            sb.draw(TextureFactory.gettexGreenBrickA(), this.position.x, this.position.y);
            sb.end();
        }
    }

    @Override
    public String getName(){
        return this.name;
    }
}
