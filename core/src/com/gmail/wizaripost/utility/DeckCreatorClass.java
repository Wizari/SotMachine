package com.gmail.wizaripost.utility;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.gameobjects.Card;

import java.util.ArrayList;

public class DeckCreatorClass {


    public Array deckCreator(Array<Card> array, int size, ArrayList<Integer> result, int id, TextureAtlas textureAtlas,
                             float yZeroPosition) {
        Card example;
        Array<Card> deck = new Array<Card>();
        int idStartElement = 0;
        float range = 0f;
        float xPosition = 0;
        float yPosition = yZeroPosition;
        int a = 404;
        int b = 404;
        int c = 404;
        int e = 404;
        int f = 404;
        int g = 404;
        a = result.get(6 * (id - 1));
        b = result.get((6 * (id - 1)) + 1);
        c = result.get((6 * (id - 1)) + 2);
        e = result.get((6 * (id - 1)) + 3);
        f = result.get((6 * (id - 1)) + 4);
        g = result.get((6 * (id - 1)) + 5);

        for (int j = 0; j < array.size; j++) {
            if (array.get(j).position.y <= yPosition + 0.9f && array.get(j).position.y >= yPosition - 0.9f) {
                idStartElement = j;
                example = array.get(j);
            }
        }
        for (int i = 0; i < 6; i++) {
            deck.add(array.get(idStartElement));
//            System.out.println(array.get(idStartElement).position.y);
            idStartElement++;
        }

        idStartElement--;
        example = array.get(idStartElement);
        xPosition = array.get(idStartElement).position.x;
        yPosition = array.get(idStartElement).position.y;
        Card card;
        int skip = 0;

        for (int i = 5; i < size; i++) { //TODO (добавить size+5)
            card = new Card();
            if (i >= size - 10) { //TODO (уменьшить до 6)
                if (skip > 4) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                }
                if (skip == 4) {
                    skip++;
                    if (f != 404) {
                        card.cardSprite = new Sprite(textureAtlas.findRegion("" + f));
                    } else {
                        card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    }
                }
                if (skip == 3) {
                    skip++;
                    if (e != 404) {
                        card.cardSprite = new Sprite(textureAtlas.findRegion("" + e));
                    } else {
                        card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    }
                }
                if (skip == 2) {
                    skip++;
                    if (c != 404) {
                        card.cardSprite = new Sprite(textureAtlas.findRegion("" + c));
                    } else {
                        card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    }
                }
                if (skip == 1) {
                    skip++;
                    if (b != 404) {
                        card.cardSprite = new Sprite(textureAtlas.findRegion("" + b));
                    } else {
                        card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
                    }
                }
                if (skip == 0) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion("" + a));
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
