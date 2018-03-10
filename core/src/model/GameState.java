package model;

/**
 * Created by SleepingForest on 04/02/2018.
 */

public class GameState {
    public State state;

    public GameState( State s){
        state = s;
    }

    public State getState() {
        return state;
    }

    public void setStat(State s){
        this.state = s;
    }
}
