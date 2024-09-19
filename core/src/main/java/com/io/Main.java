package com.io;

import com.badlogic.gdx.Game;


/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    @Override
    public void create() {
        Coordinator coordinator = new Coordinator(this);
        coordinator.setStartScreen();
    }
}
