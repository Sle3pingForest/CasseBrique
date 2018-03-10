package model;

import com.badlogic.gdx.graphics.Texture;
import fr.ul.cassebrique.dataFactories.TextureFactory;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public enum BrickEnumeration {

    Vide(null),
    Bleue(TextureFactory.gettexBlueBrick()),
    Verte(TextureFactory.gettexGreenBrickA()),
    VerteAbimee(TextureFactory.gettexGreenBrickB());

    protected Texture text;

    //constructeur
    BrickEnumeration(Texture texture ){
        this.text = texture;
    }

    public Texture getText() {
        return text;
    }


}