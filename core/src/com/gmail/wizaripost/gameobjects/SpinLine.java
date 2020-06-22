package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.utility.GetRandomCardTextureName;

public class SpinLine {
     Array<Card> cards; // массив карт
    static Texture cardTexture; // текстурное изображение нашего зомби
    private static float CARD_RESIZE_FACTOR = 1500f;
    Card card;
    public Vector2 p = new Vector2(); // вектор для обозначения позиции
    float slow;
    float spe;
    static Card.State level;
    boolean flag;


    public void initialize(float width, float height, float xPosition, float yPosition,
                           float speed, float slowdown, int size, int id) {
        flag = true;
        cards = new Array<Card>();

        float range = 0f;
        slow = slowdown;
        spe = speed;
        for (int i = 0; i < size; i++) {
            card = new Card();
            cardTexture = new Texture(Gdx.files.internal(GetRandomCardTextureName.getTexture()));
            card.cardSprite = new Sprite(cardTexture);// загружаем текстуру корзины в спрайт
            card.cardSprite.setSize(card.cardSprite.getWidth() * (width / CARD_RESIZE_FACTOR), card.cardSprite.getHeight() * (width / CARD_RESIZE_FACTOR)); // устанавливаем размер спрайта
//            card.cardSprite.setRegion(0, 0, (int)(width/scaleFactor), (int)(currentHeight/scaleFactor));
            card.velocity.set(0, spe);
            card.slowdown.set(0, slow);
            card.state = Card.State.MOVE;

            if (i > 0) {
                card.cardSprite.setPosition(xPosition, yPosition + range);
                card.position.set(xPosition, yPosition + range);

            } else {
                card.cardSprite.setPosition(xPosition, yPosition);
                card.position.set(xPosition, yPosition);

            }
            cards.add(card);
            range += card.cardSprite.getHeight() + 6;
        }
    }

    public void update(Card cardX) {
        switch (cardX.state) {
            case MOVE:
                if (flag) {
                    if (cardX.velocity.y >= -0.8f) {
//                    cardX.velocity.y = -0.3f;
                        cardX.slowdown.y = 0.0f;
                        if (cardX.position.y <= 0.9f && cardX.position.y >= -0.9f) {
                            System.out.println(cardX.position.y);
                            flag = false;
//                            for (Card card1 : cards) {
//                                card1.state = Card.State.STAY;
//                                cardX.slowdown.y = 0.0f;
//                                cardX.velocity.y = 0.0f;
                            }

                        }
                    }
                if (!flag) {
                    cardX.state = Card.State.STAY;
                    cardX.slowdown.y = 0.0f;
                    cardX.velocity.y = 0.0f;
                }
                break;
//            case STAY:
//                break;
        }
    }


    public void renderSpinLine(SpriteBatch batch) {
//        card.render(batch);
        for (Card card1 : cards) {
            update(card1);
            card1.render(batch);
            card1.update();
        }
    }


    public void dispose() {
        cardTexture.dispose();
    }
}
