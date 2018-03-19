package fr.ul.cassebrique.dataFactories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public class TextureFactory {
    private static final Texture texBlueBrick= new Texture(Gdx.files.internal("images/Brique1C.png"));
    private static final Texture texGreenBrickA = new Texture(Gdx.files.internal("images/Brique2Ca.png"));
    private static final Texture texGreenBrickB = new Texture(Gdx.files.internal("images/Brique2Cb.png"));
    private static final Texture texBorder = new Texture(Gdx.files.internal("images/Contour.png"));
    private static final Texture texBack = new Texture(Gdx.files.internal("images/Fond.png"));
    private static final Texture texBall = new Texture(Gdx.files.internal("images/Bille.png"));
    private static final Texture texRacket = new Texture(Gdx.files.internal("images/Barre.png"));
    private static final Texture texBravo = new Texture(Gdx.files.internal("images/Bravo.bmp"));
    private static final Texture texPerteBalle = new Texture(Gdx.files.internal("images/PerteBalle.bmp"));
    private static final Texture texPerte = new Texture(Gdx.files.internal("images/Perte.bmp"));
    private static final Texture troll = new Texture(Gdx.files.internal("images/troll.jpg"));
    private static final Texture boss = new Texture(Gdx.files.internal("images/boss.jpg"));
    private static final Texture end1 = new Texture(Gdx.files.internal("images/1.png"));
    private static final Texture end2 = new Texture(Gdx.files.internal("images/2.png"));
    private static final Texture end3 = new Texture(Gdx.files.internal("images/3.png"));
    private static final Texture animationGreenBrickA = new Texture(Gdx.files.internal("images/Anim2Ca.png"));


    public static Texture getAnimationGreenBrickA() {
        return animationGreenBrickA;
    }

    public static Texture getBoss() {
        return boss;
    }

    public static Texture getTroll() {

        return troll;
    }

    public static Texture getTexGreenBrickA() {
        return texGreenBrickA;
    }

    public static Texture getTexGreenBrickB() {
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

    public static Texture getTexBall() {
        return texBall;
    }

    public static Texture getTexRacket() {
        return texRacket;
    }

    public static Texture getTexBravo() {
        return texBravo;
    }

    public static Texture getTexPerteBalle() {
        return texPerteBalle;
    }

    public static Texture getTexPerte() {
        return texPerte;
    }

    public static Texture getEnd1() {
        return end1;
    }

    public static Texture getEnd2() {
        return end2;
    }

    public static Texture getEnd3() {
        return end3;
    }
}


