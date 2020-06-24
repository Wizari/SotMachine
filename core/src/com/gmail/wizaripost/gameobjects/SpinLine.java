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
    //    private float speed;
    static Card.State level;
    private boolean moveTrigger;
    public int size;
    public float xPosition;
    public float yPosition;
    public float range;
    public static float width;
    //    boolean stayFlag;
    public boolean lockButtonStart = true;
    int cardA;
    int cardB;
    int cardC;

    public enum LineSpeed {MAX, HIGH, AVERAGE, MIN, STAY} // определение состояний

    LineSpeed lineSpeed = LineSpeed.STAY;

    /**
     * @param width ширина экрана приложения
     * @param height высота экрана приложения
     * @param size количество карт в колоде
     * @param id порядковый номер колеса(от 1 до 5)
     * @param cardA задать карту для выпадения (нижняя)(от 1 до 7)
     * @param cardB задать карту для выпадения (средняя)(от 1 до 7)
     * @param cardC задать карту для выпадения (верхняя)(от 1 до 7)
     */
    public void initialize(float width, float height, int size, int id,
                           int cardA, int cardB, int cardC) {
        this.cardA = cardA;
        this.cardB = cardB;
        this.cardC = cardC;
        moveTrigger = true;
        cards = new Array<Card>();
        width = width;
        this.xPosition = 0;
        this.yPosition = 0;
        this.size = size;
        this.range = 0f;
//        this.slow = slowdown;
//        this.speed = speed;
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

    boolean on = false;
    boolean on0 = true;
    boolean on1 = true;
    boolean on2 = true;
    boolean on3 = true;
    boolean on4 = true;
    boolean on5 = true;

    public void update(Card cardX, int numberElement) {
        switch (cardX.state) {
            case MOVE:
                if (numberElement == 0 && on) {
//                    if (cardX.velocity.y >= -20) {
//                        lineSpeed = LineSpeed.MAX;
//                        on = false;
//                    }
                    if (cardX.velocity.y == -30) {
                        lineSpeed = LineSpeed.HIGH;
                        on = false;
                    }
                    if (cardX.velocity.y == -15) {
                        lineSpeed = LineSpeed.AVERAGE;
                        on = false;
                    }
                    if (cardX.velocity.y == -7) {
                        lineSpeed = LineSpeed.MIN;
                        on = false;
                    }
                    if (cardX.velocity.y == -0.8f) {
                        lineSpeed = LineSpeed.STAY;
                        on = false;
                    }
                }
//                if (on1) {
//                    if (cardX.winCard && cardX.position.y >= 1000f) {
////                    lineSpeed = LineSpeed.MAX;
//                        on = true;
//                        on1 = false;
//                    }
//                }
                if (on2) {
                    if (cardX.winCard && cardX.position.y <= 1000f && cardX.position.y >= 500f) {
//                    lineSpeed = LineSpeed.HIGH;
                        on = true;
                        on2 = false;
                    }
                }
                if (on3) {
                    if (cardX.winCard && cardX.position.y <= 500f && cardX.position.y >= 40f) {
//                    lineSpeed = LineSpeed.AVERAGE;
                        on = true;
                        on3 = false;
                    }
                }
                if (on4) {
                    if (cardX.winCard && cardX.position.y <= 40f && cardX.position.y >= 10f) {
//                    lineSpeed = LineSpeed.MIN;
                        on = true;
                        on4 = false;
                    }
                }
//                if (on5) {
                    if (cardX.winCard && cardX.position.y <= 0.9f && cardX.position.y >= -0.9f) {
//                    lineSpeed = LineSpeed.STAY;
//                        on = true;
                        on5 = false;
//                    }
                }
                switch (lineSpeed) {
                    case MAX:
                        cardX.velocity.y = -30;
                        break;
                    case HIGH:
                        cardX.velocity.y = -15;
                        break;
                    case AVERAGE:
                        cardX.velocity.y = -7;
                        break;
                    case MIN:
                        cardX.velocity.y = -0.8f;

                        if (cardX.position.y <= 0.9f && cardX.position.y >= -0.9f && cardX.winCard) {
                            lineSpeed = LineSpeed.STAY;
                            System.out.println(cardX.position.y);
                            moveTrigger = false;
                            lockButtonStart = false;
                            cardX.velocity.y = 0.0f;
                            cardX.state = Card.State.STAY;
//                            on = false;

                        }
                        break;
                    case STAY:
                        cardX.velocity.y = 0.0f;
                        cardX.state = Card.State.STAY;
                        on = false;
                        on1 = true;
                        on2 = true;
                        on3 = true;
                        on4 = true;
                        on5 = true;

//                            if (!moveTrigger) {
//                            }
                        break;
                }
                break;


            case STAY:
                if (!moveTrigger) {
                    System.out.println("case STAY: moveTrigger = true;");
                    moveTrigger = true;
                }

                break;
        }
    }


    public void renderSpinLine(SpriteBatch batch) {
//        card.render(batch);
        for (int i = 0; i < cards.size; i++) {
            update(cards.get(i), i);
            cards.get(i).render(batch);
            cards.get(i).update();
        }
//        for (Card card1 : cards) {
//            update(card1);
//            card1.render(batch);
//            card1.update();
//        }
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
//                lineSpeed = LineSpeed.MAX;
                card1.velocity.set(0, -30);//TODO
//                card1.slowdown.set(0, slow);
            } else {
                card1.state = state;
            }
        }
    }

    public void reRun() {
        DeckCreatorClass helper = new DeckCreatorClass();
        cards = helper.deckCreator(cards, size, cardA, cardB, cardC);
//        for (Card card : cards) {
//            System.out.println(card.velocity.y);
//        }
        lineSpeed = LineSpeed.MAX;
        setState(Card.State.MOVE);
    }

    public void setMoveTrigger(boolean moveTrigger) {
        this.moveTrigger = moveTrigger;
    }

    public void setLockButtonStart(boolean lockButtonStart) {
        this.lockButtonStart = lockButtonStart;
    }
}


//        switch (cardX.state) {
//            case MOVE:
//
//                if (moveTrigger) {
////                    if (cardX.position.y < 1000 && cardX.winCard) {
////                        System.out.println("111");
////                        cardX.slowdown.y = 0.0f;
////                        cardX
////
////                    }
//
//
//                    if (cardX.velocity.y >= -0.8f) {
////                    cardX.velocity.y = -0.3f;
//                        cardX.slowdown.y = 0.0f;
//                        if (cardX.position.y <= 0.9f && cardX.position.y >= -0.9f && cardX.winCard) {
//                            System.out.println(cardX.position.y);
//                            moveTrigger = false;
//                            lockButtonStart = false;
//                        }
//                    }
//                }
//
//                if (!moveTrigger) {
//                    cardX.state = Card.State.STAY;
//                    cardX.slowdown.y = 0.0f;
//                    cardX.velocity.y = 0.0f;
//                }
//                break;
//
//
//            case STAY:
//                if (!moveTrigger) {
//                    moveTrigger = true;
//                }
//
//                break;
//        }
