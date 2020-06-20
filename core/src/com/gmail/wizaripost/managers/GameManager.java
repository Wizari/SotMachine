package com.gmail.wizaripost.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager {


    public static void initialize(float width, float height) {
        FrameRate.initialize(width, height);
    }

    public static void renderGame(SpriteBatch batch) {
        FrameRate.displayMessage(batch);
    }

    public static void dispose() {

    }

}
