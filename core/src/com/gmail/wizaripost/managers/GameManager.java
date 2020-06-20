package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager {

    static Texture backtexture;
    static Sprite backSprite;

    public static void initialize(float width, float height) {
        backtexture = new Texture(Gdx.files.internal("background.jpg"));
        backSprite = new Sprite(backtexture);
        backSprite.setSize(width, height);
        backSprite.setPosition(0,0f);


        FrameRate.initialize(width, height);
    }

    public static void renderGame(SpriteBatch batch) {
        backSprite.draw(batch);




        FrameRate.displayMessage(batch);
    }

    public static void dispose() {

    }

}
