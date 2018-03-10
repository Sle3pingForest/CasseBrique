package fr.ul.cassebrique.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public class TextureFactory {
    static final Texture texBlueBrick= new Texture(Gdx.files.internal("images/Brique1C.png"));
    static final Texture texGreenBrickA = new Texture(Gdx.files.internal("images/Brique2Ca.png"));
    static final Texture texGreenBrickB = new Texture(Gdx.files.internal("images/Brique2Cb.png"));
    static final Texture texBorder = new Texture(Gdx.files.internal("images/Contour.png"));
    static final Texture texBack = new Texture(Gdx.files.internal("images/Fond.png"));
    static final Texture texBall = new Texture(Gdx.files.internal("images/Bille.png"));
    static final Texture texRacket = new Texture(Gdx.files.internal("images/Barre.png"));


    public static Texture gettexBlueBrick() {
        return texBlueBrick;
    }

    public static Texture gettexGreenBrickA() {
        return texGreenBrickA;
    }

    public static Texture gettexGreenBrickB() {
        return texGreenBrickB;
    }

    public static Texture getTexBorder() {
        return texBorder;
    }

    public static Texture getTexBack() {
        return texBack;
    }

    public static Texture getTexBlueBrick() {
        return texBlueBrick;
    }

    public static Texture getTexGreenBrickA() {
        return texGreenBrickA;
    }

    public static Texture getTexGreenBrickB() {
        return texGreenBrickB;
    }

    public static Texture getTexBall() {
        return texBall;
    }

    public static Texture getTexRacket() {
        return texRacket;
    }
}


