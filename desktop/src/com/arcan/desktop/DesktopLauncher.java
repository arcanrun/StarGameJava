package com.arcan.desktop;

import com.arcan.StarGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 400;
		config.height = 600;
		config.resizable = false;
		new LwjglApplication(new StarGame(), config);
	}
}
