package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Card {

    public Sprite cardSprite; // спрайт для отображения карты
    public Vector2 position = new Vector2();// позиция карты
    public float heightCard,widthCard; // размеры карты

    public void render(SpriteBatch batch){

        cardSprite.draw(batch);
    }

}
