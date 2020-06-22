package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.gmail.wizaripost.gameobjects.SpinLine;
import com.gmail.wizaripost.gameobjects.StartButton;

public class GameManager {

    static Texture backTexture;
    static Sprite backSprite;
    static Texture botTopTexture;
    static Sprite botTopSprite;
    static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат
    static FrameRate frameRate;
    static SpinLine spinLine;
    static StartButton startButton;



    public void initialize(float width, float height) {
        backTexture = new Texture(Gdx.files.internal("background.jpg"));
        backSprite = new Sprite(backTexture);
        botTopTexture = new Texture(Gdx.files.internal("BotTop.png"));
        botTopSprite = new Sprite(botTopTexture);
        backSprite.setSize(width, height);
        backSprite.setPosition(0, 0f);
        botTopSprite.setSize(width, height);
        botTopSprite.setPosition(0, 0f);
        spinLine = new SpinLine();
        spinLine.initialize(width, height, 0, 0, -5.10f, 0.05f, 200);
        startButton = new StartButton();
        startButton.initialize(width, height);
        frameRate = new FrameRate();
        frameRate.initialize(width, height);
    }

    public void renderGame(SpriteBatch batch) {
        backSprite.draw(batch);
//        card.render(batch);
//        SpinLine.update();
        spinLine.renderSpinLine(batch);
//        backBotSprite.draw(batch);
        startButton.displayStartButton(batch);
//        FrameRate.displayMessage(batch);
        frameRate.displayMessage(batch);
    }


    public void dispose() {
        backTexture.dispose();
        botTopTexture.dispose();
    }

}
