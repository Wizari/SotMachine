package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.controller.ResultController;
import com.gmail.wizaripost.utility.DeckCreatorClass;
import com.gmail.wizaripost.utility.GetCardTextureName;
import com.gmail.wizaripost.utility.Helper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
public class SpinLine {
    @Getter
    @Setter
    public Array<Card> cards; // массив карт
    static Texture cardTexture; // текстурное изображение нашего зомби
    public static float CARD_RESIZE_FACTOR = 1500f;
    public Vector2 p = new Vector2(); // вектор для обозначения позиции
    private float slow;
    static Card.State level;
    private boolean moveTrigger;
    public int size;
    public float xPosition;
    public float yPosition;
    public float range;
    public static float width;
    public boolean lockButtonStart = true;
    int id;
    ArrayList<Integer> result;

    public enum LineSpeed {MAX, HIGH, AVERAGE, MIN, STAY} // определение состояний

    LineSpeed lineSpeed = LineSpeed.STAY;
    ResultController resultController;
    private TextureAtlas textureAtlas;
    boolean on = false;
    boolean on0 = true;
    boolean on1 = true;
    boolean on2 = true;
    boolean on3 = true;
    boolean on4 = true;
    boolean on5 = true;


    /**
     * @param width        ширина экрана приложения
     * @param height       высота экрана приложения
     * @param size         количество карт в колоде
     * @param id           порядковый номер колеса(от 1 до 5)
     * @param startMatrix  матрица для отрисовки стартового экрана
     * @param textureAtlas TextureAtlas карточек
     */
    public void initialize(float width, float height, int size, int id,
                           ArrayList<Integer> startMatrix, TextureAtlas textureAtlas) {
        resultController = new ResultController();
        this.id = id;
        this.result = startMatrix;
        moveTrigger = true;
        cards = new Array<Card>();
        width = width;
        this.xPosition = 0;
        this.yPosition = 0;
        this.size = size;
        this.range = 0f;
        this.textureAtlas = textureAtlas;

        Card card;
        for (int i = (id * 6) - 6; i < id * 6; i++) {
            if (i >= (((id * 6) - 6) + 2) && i <= (((id * 6) - 6) + 4)) {
                card = new Card();
                if (i == ((id * 6) - 6) + 2) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(startMatrix.get(i) + ""));
                }
                if (i == ((id * 6) - 6) + 3) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(startMatrix.get(i) + ""));
                }
                if (i == ((id * 6) - 6) + 4) {
                    card.cardSprite = new Sprite(textureAtlas.findRegion(startMatrix.get(i) + ""));
                }
            } else {
                card = new Card();
                card.cardSprite = new Sprite(textureAtlas.findRegion(GetCardTextureName.getRandomSpriteSheetUnitName()));
            }
            float XWidth = card.cardSprite.getWidth() * (width / CARD_RESIZE_FACTOR);
            card.cardSprite.setSize(XWidth, card.cardSprite.getHeight() * (width / CARD_RESIZE_FACTOR)); // устанавливаем размер спрайта
            card.state = Card.State.STAY;
            if (xPosition == 0) {
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
            lockButtonStart = false;
        }
    }

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
                        on = true;
                        on2 = false;
                    }
                }
                if (on3) {
                    if (cardX.winCard && cardX.position.y <= 500f && cardX.position.y >= 30f) {
                        on = true;
                        on3 = false;
                    }
                }
                if (on4) {
                    if (cardX.winCard && cardX.position.y <= 30f && cardX.position.y >= 10f) {
                        on = true;
                        on4 = false;
                    }
                }
                if (cardX.winCard && cardX.position.y <= 0.9f && cardX.position.y >= -0.9f) {
                    on5 = false;
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
                        break;
                }
                break;


            case STAY:
                if (!moveTrigger) {
//                    System.out.println("case STAY: moveTrigger = true;");
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

    public void reRun(ArrayList<Integer> result) {

        this.result = result;
        DeckCreatorClass helper = new DeckCreatorClass();
        cards = helper.deckCreator(cards, size, result, id, textureAtlas);
//        for (Card card : cards) {
//            System.out.println(card.velocity.y);
//        }
        lineSpeed = LineSpeed.MAX;
        setState(Card.State.MOVE);
    }

}
