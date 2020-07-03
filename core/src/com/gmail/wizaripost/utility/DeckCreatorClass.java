package com.gmail.wizaripost.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.gameobjects.Card;

import java.util.ArrayList;

public class DeckCreatorClass {


    public Array deckCreator(Array<Card> array, int size, ArrayList<Integer> result, int id, TextureAtlas textureAtlas) {
        Card example;
        Array<Card> deck = new Array<Card>();
        int idStartElement = 0;
        float range = 0f;
        float xPosition = 0;
        float yPosition = 0;
        int a = 1;
        int b = 2;
        int c = 3;
        a = result.get(3 * (id - 1));
        b = result.get((3 * (id - 1)) + 1);
        c = result.get((3 * (id - 1)) + 2);

        for (int j = 0; j < array.size; j++) {
            if (array.get(j).position.y <= 0.9f && array.get(j).position.y >= -0.9f) {
                idStartElement = j;
                example = array.get(j);
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
            card = new Card();
            if (i >= size - 10) {
                if (skip > 4) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                }
                if (skip == 4) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion("" + c));
                    skip++;
                }
                if (skip == 3) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion("" + b));
                    skip++;
                }
                if (skip == 2) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion("" + a));
                    skip++;
                }
                if (skip == 1) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    skip++;
                }
                if (skip == 0) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    card.winCard = true;
                    skip++;
                }
            } else {
                card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
            }
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
