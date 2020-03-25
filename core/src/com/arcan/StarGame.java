package com.arcan;


import com.arcan.screen.MenuScreen;
import com.badlogic.gdx.Game;



public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
