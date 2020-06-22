package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import lombok.Data;

@Data
public class StartButton {
    public static Sprite startButtonSprite;
    private Texture startButtonTexture;
    private Texture startButtonTexture2;
    private Texture startButtonTexture3;
    static final float START_BUTTON_RESIZE_FACTOR = 1500f;
    public float time = 0.0f; // сколько прошло
    public float maxTime = 0.3f; // максимальное разрешенное время между сменами
    public enum State {GREEN,ORANGE,LIMON}; // определение состояний зомби
    public State state = State.GREEN; // переменная, описывающая текущее состояние зомби


    public void initialize(float width, float height) {
        startButtonTexture = new Texture(Gdx.files.internal("buttonGreen.png"));
        startButtonTexture2 = new Texture(Gdx.files.internal("buttonLimon.png"));
        startButtonTexture3 = new Texture(Gdx.files.internal("buttonOrange.png"));
        startButtonSprite = new Sprite(startButtonTexture);
        startButtonSprite.setSize(startButtonSprite.getWidth() * width / START_BUTTON_RESIZE_FACTOR, startButtonSprite.getHeight() * width / START_BUTTON_RESIZE_FACTOR);
//        startButtonSprite.setPosition(0 ,0);
        startButtonSprite.setPosition((width / 2) - (startButtonSprite.getWidth() / 2), 10);
        int a = 1;
    }

    private void flashing() {

        if (time >= maxTime) {
            switch (state) {
                case GREEN:
                    startButtonSprite.setTexture(startButtonTexture);
                    state = State.LIMON;
                    break;
                case LIMON:
                    startButtonSprite.setTexture(startButtonTexture2);
                    state = State.ORANGE;
                    break;
                case ORANGE:
                    startButtonSprite.setTexture(startButtonTexture3);
                    state = State.GREEN;
                    break;

            }
                time = 0.0f;
            }
            if (time < maxTime) {
                time += Gdx.graphics.getDeltaTime();
            }

        }

        public void displayStartButton (SpriteBatch batch){
            startButtonSprite.draw(batch);
            flashing();
        }

        public void dispose () {
            startButtonTexture.dispose();
        }
    }



//            if (startButtonSprite.getTexture() == startButtonTexture) {
//                startButtonSprite.setTexture(startButtonTexture2);
//
//            } else {
//                startButtonSprite.setTexture(startButtonTexture);
//
//            }
