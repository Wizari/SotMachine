package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Card {

    public Sprite cardSprite; // спрайт для отображения карты
    public float heightCard,widthCard; // размеры карты

    public Vector2 position = new Vector2(); // вектор для обозначения позиции
    public Vector2 velocity = new Vector2(); // вектор для обозначения скорости
    public final Vector2 slowdown = new Vector2(0,+0.00f);// вектор для обозначения замедления
    public enum State {STAY, MOVE} // определение состояний
    public static State state = State.MOVE; // переменная, описывающая текущее состояние

    public static State getState() {
        return state;
    }

    public void render(SpriteBatch batch){
        cardSprite.draw(batch);
    }

    public void update() {
        position.add(velocity);
        velocity.add(slowdown); // обновление значения переменной velocity путем добавления к нему значения переменной gravity
        cardSprite.setPosition(position.x, position.y);
    }

}
