package com.gmail.wizaripost.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.gameobjects.Card;

import java.util.ArrayList;

public class DeckCreatorClass {


    public Array deckCreator(Array<Card> array, int size, ArrayList<Integer> result, int id) {
        Card example;
        Array<Card> deck = new Array<Card>();
        int idStartElement = 0;
        float range = 0f;
        float xPosition = 0;
        float yPosition = 0;
        int a = 1;
        int b = 2;
        int c = 3;
//        for (int i = 0; i < 3; i++) {
//
//
//        }
        a = result.get(3 * (id - 1));
        b = result.get((3 * (id - 1))+1);
        c = result.get((3 * (id - 1))+2);


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
        int skip = 0;

        for (int i = 5; i < size; i++) {
            Texture cardTexture = new Texture(Gdx.files.internal(a + ".jpg"));
            card = new Card();
            if (i >= size - 10) {
                if (skip == 4) {
                    cardTexture = new Texture(Gdx.files.internal(c + ".jpg"));
                    skip++;
                }
                if (skip == 3) {
                    cardTexture = new Texture(Gdx.files.internal(b + ".jpg"));
                    skip++;
                }
                if (skip == 2) {
                    cardTexture = new Texture(Gdx.files.internal(a + ".jpg"));
                    skip++;
                }
                if (skip == 1) {
                    cardTexture = new Texture(Gdx.files.internal(GetCardTextureName.getRandomTextureName()));
                    skip++;
                }
                if (skip == 0) {
                    cardTexture = new Texture(Gdx.files.internal(GetCardTextureName.getRandomTextureName()));
                    card.winCard = true;
                    skip++;
                }
            } else {
                cardTexture = new Texture(Gdx.files.internal(GetCardTextureName.getRandomTextureName()));
            }
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
