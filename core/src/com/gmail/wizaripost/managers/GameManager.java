package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.wizaripost.gameobjects.Card;
import com.gmail.wizaripost.gameobjects.StartButton;

public class GameManager {

    static Texture backtexture;
    static Sprite backSprite;

    //        static Array<Zombie>zombies; // массив наших зомби
    static Texture cardTexture; // текстурное изображение нашего зомби
    private static float ZOMBIE_RESIZE_FACTOR = 500f;
    private static float ZOMBIE_VERT_POSITION_FACTOR = 3f;
    private static float ZOMBIE1_HORIZ_POSITION_FACTOR = 5.8f;
    private static float ZOMBIE2_HORIZ_POSITION_FACTOR = 2.4f;
    private static float ZOMBIE3_HORIZ_POSITION_FACTOR = 1.5f;
    static Card card;


    public static void initialize(float width, float height) {
        backtexture = new Texture(Gdx.files.internal("background.jpg"));
        backSprite = new Sprite(backtexture);
        backSprite.setSize(width, height);
        backSprite.setPosition(0, 0f);

        cardTexture = new Texture(Gdx.files.internal("1.jpg"));
        card = new Card();
        card.position.set(width / ZOMBIE1_HORIZ_POSITION_FACTOR, height / ZOMBIE_VERT_POSITION_FACTOR);
        card.cardSprite = new Sprite(cardTexture);
        card.widthCard = card.cardSprite.getWidth() * (width / ZOMBIE_RESIZE_FACTOR);
        card.heightCard = card.cardSprite.getHeight()* (width/ZOMBIE_RESIZE_FACTOR);
        card.cardSprite.setSize(card.widthCard, card.heightCard);
        card.cardSprite.setPosition(card.position.x, card.position.y);



        StartButton.initialize(width, height);
        FrameRate.initialize(width, height);
    }

    public static void renderGame(SpriteBatch batch) {
        backSprite.draw(batch);
        card.render(batch);


        StartButton.displayStartButton(batch);
        FrameRate.displayMessage(batch);
    }

    public static void dispose() {

    }

}
