package fr.ul.cassebrique;

import com.badlogic.gdx.*;

import views.GameScreen;

public class CasseBrique extends Game {
	protected GameScreen gs;
	
	@Override
	public void create () {
		gs = new GameScreen();
		this.setScreen(gs);
	}

	@Override
	public void dispose () {
		gs.dispose();
		//img.dispose();
	}
}
