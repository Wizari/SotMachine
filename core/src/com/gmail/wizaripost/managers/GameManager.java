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
    static Texture backBotTexture;
    static Sprite backBotSprite;

    static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат



    public static void initialize(float width, float height) {
        backTexture = new Texture(Gdx.files.internal("background.jpg"));
        backSprite = new Sprite(backTexture);
        backBotTexture = new Texture(Gdx.files.internal("BotTop.png"));
        backBotSprite = new Sprite(backBotTexture);
        backSprite.setSize(width, height);
        backSprite.setPosition(0, 0f);
        backBotSprite.setSize(width, height);
        backBotSprite.setPosition(0, 0f);

        SpinLine.initialize(width, height, 0, 0, -15f, 0.02f, 200);
        StartButton.initialize(width, height);
        FrameRate.initialize(width, height);
    }

    public static void renderGame(SpriteBatch batch) {
        backSprite.draw(batch);
//        card.render(batch);
//        SpinLine.update();
        SpinLine.renderSpinLine(batch);
        backBotSprite.draw(batch);
        StartButton.displayStartButton(batch);
        FrameRate.displayMessage(batch);

    }


    public static void dispose() {

    }

}
