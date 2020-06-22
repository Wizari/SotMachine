package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.gmail.wizaripost.gameobjects.SpinLine;
import com.gmail.wizaripost.gameobjects.StartButton;

public class GameManager {

    private static Texture backTexture;
    private static Sprite backSprite;
    private static Texture botTopTexture;
    private static Sprite botTopSprite;
    static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат
    private static FrameRate frameRate;
    private static SpinLine spinLine;
    private static SpinLine spinLine2;
    private static SpinLine spinLine3;
    private static SpinLine spinLine4;
    private static SpinLine spinLine5;
    private static StartButton startButton;



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
        spinLine.initialize(width, height, 0, 0, -10.00f, 0.1f, 200);
        spinLine2 = new SpinLine();
        spinLine2.initialize(width, height, 0, 100, -20.00f, 0.1f, 200);
        spinLine3 = new SpinLine();
        spinLine3.initialize(width, height, 0, 200, -30.00f, 0.1f, 200);
        spinLine4 = new SpinLine();
        spinLine4.initialize(width, height, 0, 300, -40.00f, 0.1f, 200);
        spinLine5 = new SpinLine();
        spinLine5.initialize(width, height, 0, 400, -50.00f, 0.1f, 300);

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
        spinLine2.renderSpinLine(batch);
        spinLine3.renderSpinLine(batch);
        spinLine4.renderSpinLine(batch);
        spinLine5.renderSpinLine(batch);
        botTopSprite.draw(batch);
        startButton.displayStartButton(batch);
//        FrameRate.displayMessage(batch);
        frameRate.displayFPS(batch);
    }


    public void dispose() {
        backTexture.dispose();
        botTopTexture.dispose();
    }

}
