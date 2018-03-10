package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by User on 03/02/2018.
 */

public class Background {

    public Background(){

    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(TextureFactory.getTexBack(), 0, 0);
        sb.end();
    }
}
