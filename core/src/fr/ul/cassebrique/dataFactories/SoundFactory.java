package fr.ul.cassebrique.dataFactories;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Sle3pingForest on 08/03/2018.
 */

public class SoundFactory {

    private static final Sound collision = Gdx.audio.newSound(Gdx.files.internal("sounds/collision.wav"));
    private static final Sound impact = Gdx.audio.newSound(Gdx.files.internal("sounds/impact.mp3"));
    private static final Sound perteSound = Gdx.audio.newSound(Gdx.files.internal("sounds/perte.mp3"));
    private static final Sound perteBalleSound = Gdx.audio.newSound(Gdx.files.internal("sounds/perteBalle.wav"));;
    private static final Sound victoireSound = Gdx.audio.newSound(Gdx.files.internal("sounds/victoire.mp3"));

    public static Sound getImpact() {
        return impact;
    }

    public static Sound getPerteSound() {
        return perteSound;
    }

    public static Sound getPerteBalleSound() {
        return perteBalleSound;
    }

    public static Sound getVictoireSound() {
        return victoireSound;
    }

    public static Sound getCollision() {
        return collision;
    }
}
