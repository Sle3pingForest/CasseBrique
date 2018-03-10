package views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.swing.text.View;

import fr.ul.cassebrique.dataFactories.TextureFactory;
import model.GameState;
import model.GameWorld;
import model.State;

/**
 * Created by SleepingForest on 26/01/2018.
 */

public class GameScreen extends ScreenAdapter{
    protected SpriteBatch sb;
    protected GameWorld gw;
    protected GameState state;
    static final int timeIter = 1000 / 60;

    public GameScreen(){
        this.sb = new SpriteBatch();
        this.gw = new GameWorld(this);
        this.state = new GameState(State.Running);
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isTouched() && Gdx.input.getX() < this.gw.getRacket().getPos().x + TextureFactory.getTexRacket().getWidth()/2){
            this.gw.getRacket().gauche();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isTouched() && Gdx.input.getX() > this.gw.getRacket().getPos().x + TextureFactory.getTexRacket().getWidth()/2){
            this.gw.getRacket().droite();
        }
    }

    @Override
    public void render(float delta){
        /*
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(TextureFactory.gettexBlueBrick(), 100, 200);
        sb.end();*/
        this.gw.draw(this.sb);
        this.update();
    }

    public void setSb(SpriteBatch sb) {
        this.sb = sb;
    }

    public SpriteBatch getSb() {
        return sb;
    }

    @Override
    public void dispose() {
        sb.dispose();
    }
}
