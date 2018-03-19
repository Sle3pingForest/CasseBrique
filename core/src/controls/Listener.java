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
        System.out.println(keycode);
        if(keycode == 1){
            System.out.println("je suis en running je vais mettre pausse");
            this.gs.getGameState().setStat(State.Pause);
        }
        if(keycode == 2){
            System.out.println("je suis en pausse je vais mettre en running");
            this.gs.getGameState().setStat(State.Running);

        }
        if(keycode == 0){
            this.gs.getGameState().setStat(State.Quit);
        }
        return false;
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
