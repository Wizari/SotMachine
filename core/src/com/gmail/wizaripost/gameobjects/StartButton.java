package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartButton {
   public static Sprite startButtonSprite;
    static Texture startButtonTexture;
    static final float START_BUTTON_RESIZE_FACTOR = 1500f;


    public static void initialize(float width, float height) {
        startButtonTexture = new Texture(Gdx.files.internal("buttonGreen.png"));
        startButtonSprite = new Sprite(startButtonTexture);
        startButtonSprite.setSize(startButtonSprite.getWidth()* width/START_BUTTON_RESIZE_FACTOR,startButtonSprite.getHeight()* width/START_BUTTON_RESIZE_FACTOR);
//        startButtonSprite.setPosition(0 ,0);
        startButtonSprite.setPosition((width/2)-(startButtonSprite.getWidth()/2) ,10);

    }

    public static void displayStartButton(SpriteBatch batch){
        startButtonSprite.draw(batch);

    }
}
