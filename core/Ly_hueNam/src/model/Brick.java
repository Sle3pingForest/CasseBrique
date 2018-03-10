package model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by User on 02/02/2018.
 */

public abstract class Brick {
    protected Vector2 position;
    protected int nb_cp_sp;


    public Brick(Vector2 pos, int nb){
        this.nb_cp_sp = nb;
        this.position = pos;
    }

    public abstract  String getName();
    public abstract void draw(SpriteBatch spriteBatch);
};
