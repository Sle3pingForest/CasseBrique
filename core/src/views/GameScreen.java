package views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import fr.ul.cassebrique.dataFactories.SoundFactory;
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
    private GameState state;
    private Timer.Task timer;
    private OrthographicCamera orthoCam;
    private Viewport vp;
    private boolean pasDebrick = false;
    private Box2DDebugRenderer debugRenderer;

    static final int timeIter = 1000 / 60;

    public GameScreen(){
        this.sb = new SpriteBatch();
        this.gw = new GameWorld(this);
        this.state = new GameState(State.Running);
        this.timer = new Timer.Task() {
            @Override
            public void run() {
                checkState();
                state.setStat(State.Running);
            }
        };
        this.orthoCam = new OrthographicCamera(5,4);
        this.vp = new FitViewport(1150,700 , this.orthoCam);
        debugRenderer = new Box2DDebugRenderer();
        this.orthoCam.position.set(orthoCam.viewportWidth/2, orthoCam.viewportHeight/2, 0);
        this.orthoCam.update();
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isTouched() && Gdx.input.getX() < this.gw.getRacket().getPos().x + TextureFactory.getTexRacket().getWidth()/2){
            this.gw.getRacket().gauche();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isTouched() && Gdx.input.getX() > this.gw.getRacket().getPos().x + TextureFactory.getTexRacket().getWidth()/2){
            this.gw.getRacket().droite();
        }

        //if(this.gw.getWall().estVide() && !pasDebrick){
        if(this.gw.getWall().getComptBody() == 0){
            this.state.setStat(State.Won);
            pasDebrick = true;
            //SoundFactory.getVictoireSound().play(1.0f);
        }

        if(this.gw.perteBall){
            this.state.setStat(State.BallLoss);
            //SoundFactory.getPerteBalleSound().play(1.0f);
        }

        if(this.gw.plusDeBall){
            this.state.setStat(State.GameOver);
            //SoundFactory.getPerteSound().play(1.0f);
        }


    }


    @Override
    public void render(float delta){
        if(state.getState() == State.Running){
            this.gw.draw(this.sb);
            update();
        }
        else{
            checkState();
        }
        this.vp.apply();
        this.orthoCam.position.set(orthoCam.viewportWidth/2, orthoCam.viewportHeight/2, 0);
        this.orthoCam.update();
        this.sb.setProjectionMatrix(this.orthoCam.combined);
        debugRenderer.render(gw.getWorld(), this.orthoCam.combined);
    }


    @Override
    public void resize( int width,int height){
        vp.update(width,height);
        orthoCam.position.set(orthoCam.viewportWidth/2,orthoCam.viewportHeight/2,0);
        orthoCam.update();
        sb.setProjectionMatrix(orthoCam.combined);
    }


    public void checkState(){
        this.sb.begin();
        if(state.getState() == State.BallLoss){
            this.sb.draw(TextureFactory.getTexPerteBalle(), 200, 200);
            if(!timer.isScheduled()){
                Timer.instance().scheduleTask(timer,3);
            }
            this.gw.perteBall = false;
        }
        if(state.getState() == State.GameOver){
            //this.sb.draw(TextureFactory.getTexPerte(), 200, 200);
            this.sb.draw(TextureFactory.getTroll(), 400, 300);
            if(!timer.isScheduled()){
                Timer.instance().scheduleTask(timer,3);
            }
            this.gw = new GameWorld(this);
            this.gw.reStart(state,2);
        }
        if(state.getState() == State.Won){
            //this.sb.draw(TextureFactory.getTexBravo(), 200, 200);
            this.sb.draw(TextureFactory.getBoss(), 300, 100);
            if(pasDebrick){
                int b = this.gw.getNbBille();
               // System.out.println(b);
                //System.out.println(this.gw.getNbBille());
                this.gw = new GameWorld(this);
                this.gw.reStart(state, b);
                pasDebrick = false;
            }
            if(!timer.isScheduled()){
                Timer.instance().scheduleTask(timer,1);
            }
        }
        this.sb.end();
    }

    public GameState getGameState(){
        return this.state;
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
