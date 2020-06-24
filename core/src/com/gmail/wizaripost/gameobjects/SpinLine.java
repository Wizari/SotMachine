package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.utility.DeckCreatorClass;
import com.gmail.wizaripost.utility.GetCardTextureName;
import com.gmail.wizaripost.utility.Helper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SpinLine {
    @Getter
    @Setter
    public Array<Card> cards; // массив карт
    static Texture cardTexture; // текстурное изображение нашего зомби
    public static float CARD_RESIZE_FACTOR = 1500f;
    //    Card card;
    public Vector2 p = new Vector2(); // вектор для обозначения позиции
    private float slow;
    private float speed;
    static Card.State level;
    private boolean flag;
    public int size;
    public float xPosition;
    public float yPosition;
    public float range;
    public static float width;
    //    boolean stayFlag;
    public boolean lockButtonStart = true;


    public void initialize(float width, float height, float speed, float slowdown, int size, int id) {
        flag = true;
        cards = new Array<Card>();
        width = width;
        this.xPosition = 0;
        this.yPosition = 0;
        this.size = size;
        this.range = 0f;
        this.slow = slowdown;
        this.speed = speed;
        Card card;
        for (int i = 0; i < 6; i++) {
            card = new Card();
            cardTexture = new Texture(Gdx.files.internal(GetCardTextureName.getRandomTextureName()));
            card.cardSprite = new Sprite(cardTexture);// загружаем текстуру корзины в спрайт
            float XWidth = card.cardSprite.getWidth() * (width / CARD_RESIZE_FACTOR);
            card.cardSprite.setSize(XWidth, card.cardSprite.getHeight() * (width / CARD_RESIZE_FACTOR)); // устанавливаем размер спрайта
//            card.cardSprite.setRegion(0, 0, (int)(width/scaleFactor), (int)(currentHeight/scaleFactor));

            card.state = Card.State.STAY;
            if (xPosition == 0) {
//                f = XWidth;
                xPosition = Helper.getXPosition(width, XWidth, 10, id);
            }

            if (i > 0) {
                card.cardSprite.setPosition(xPosition, yPosition + range);
                card.position.set(xPosition, yPosition + range);

            } else {
                card.cardSprite.setPosition(xPosition, yPosition);
                card.position.set(xPosition, yPosition);

            }
            cards.add(card);
            range += card.cardSprite.getHeight() + 6;
//            System.out.println(card.position.x +" - "+ card.position.y);

            lockButtonStart = false;
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
                            lockButtonStart = false;

                        }

                    }
                }
                if (!flag) {
                    cardX.state = Card.State.STAY;
//                    stayFlag = true;
                    cardX.slowdown.y = 0.0f;
                    cardX.velocity.y = 0.0f;
                }
                break;
            case STAY:
                if (!flag) {
                    flag = true;
                }

                break;
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

    public void setState(Card.State state) {
        lockButtonStart = true;
        for (Card card1 : cards) {
            if (state == Card.State.MOVE) {
                card1.state = state;
//                flag = true;
                card1.velocity.set(0, speed);
                card1.slowdown.set(0, slow);
            } else {
                card1.state = state;
            }
        }
    }

    public void reRun() {
        DeckCreatorClass helper = new DeckCreatorClass();
        cards = helper.deckCreator(cards, size, 1, 1, 1);
        setState(Card.State.MOVE);
    }
}
