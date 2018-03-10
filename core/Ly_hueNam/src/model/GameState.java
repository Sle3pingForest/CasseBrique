package model;

/**
 * Created by SleepingForest on 04/02/2018.
 */

public class GameState {
    public State state;


    public GameState( State s){
        state = s.Running;
    }

    public State getState() {
        return state;
    }
}
