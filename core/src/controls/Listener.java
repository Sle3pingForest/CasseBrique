package controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import model.State;
import views.GameScreen;

/**
 * Created by Sle3pingForest on 18/03/2018.
 */

public class Listener implements InputProcessor {

    protected GameScreen gs;

    public Listener(GameScreen gs){
        this.gs = gs;

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.ESCAPE:
                this.gs.getGameState().setStat(State.Quit);

            case Input.Keys.SPACE:
                if(this.gs.getGameState().getState() == State.Running){
                    this.gs.getGameState().setStat(State.Pause);
                }
                else{
                    this.gs.getGameState().setStat(State.Running);
                }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
