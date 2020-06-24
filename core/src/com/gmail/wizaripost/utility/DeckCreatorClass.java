package com.gmail.wizaripost.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.gameobjects.Card;

public class DeckCreatorClass {


    public Array deckCreator(Array<Card> array, int size, int a, int b, int c) {
        Card example;
        Array<Card> deck = new Array<Card>();
        int idStartElement = 0;
        float range = 0f;
        float xPosition = 0;
        float yPosition = 0;


        for (int j = 0; j < array.size; j++) {
            if (array.get(j).position.y <= 0.9f && array.get(j).position.y >= -0.9f) {
                idStartElement = j;
                example = array.get(j);
                System.out.println("Позиция 0 получена" + example.position.y);
                System.out.println("Номер 0 элемента " + j);
            }
        }
        for (int i = 0; i < 6; i++) {
            deck.add(array.get(idStartElement));
            idStartElement++;
        }

        idStartElement--;
        example = array.get(idStartElement);
        xPosition = array.get(idStartElement).position.x;
        yPosition = array.get(idStartElement).position.y;
        Card card;

        for (int i = 5; i < size; i++) {
            card = new Card();
            Texture cardTexture = new Texture(Gdx.files.internal(GetCardTextureName.getRandomTextureName()));
            card.cardSprite = new Sprite(cardTexture);
            card.cardSprite.setSize(example.cardSprite.getWidth(), example.cardSprite.getHeight()); // устанавливаем размер спрайта
            card.state = Card.State.STAY;
            card.cardSprite.setPosition(xPosition, yPosition + range);
            card.position.set(xPosition, yPosition + range);
            deck.add(card);
            range += card.cardSprite.getHeight() + 6;
        }
        return deck;
    }
}
