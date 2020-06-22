package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {

    private Texture backTexture;
    private Sprite backSprite;
    private Texture maskTexture;
    private Sprite maskSprite;

    public void initialize(float width, float height) {
        backTexture = new Texture(Gdx.files.internal("background.jpg"));
        backSprite = new Sprite(backTexture);
        maskTexture = new Texture(Gdx.files.internal("BotTop.png"));
        maskSprite = new Sprite(maskTexture);
        backSprite.setSize(width, height);
        backSprite.setPosition(0, 0f);
        maskSprite.setSize(width, height);
        maskSprite.setPosition(0, 0f);
    }

    public void renderBack(SpriteBatch batch) {
        backSprite.draw(batch);
    }

    public void renderMask(SpriteBatch batch) {
        maskSprite.draw(batch);
    }

    public void dispose() {
        backTexture.dispose();
        maskTexture.dispose();
    }
}
