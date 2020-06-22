package com.gmail.wizaripost.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.utility.GetRandomCardTextureName;

public class SpinLine {
    static Array<Card> cards; // массив карт
    static Texture cardTexture; // текстурное изображение нашего зомби
    private static float CARD_RESIZE_FACTOR = 1500f;
    static Card card;
    static Card cardTemp;
    public static Vector2 p = new Vector2(); // вектор для обозначения позиции
    static float slow;
    static float spe;
    static Card.State level;
    public enum State {STAY, MOVE} // определение состояний
    public static float scaleFactor; // коэффициент масштабирования зомби


    public void initialize(float width, float height, float yPosition, float xPosition, float speed, float slowdown, int size) {
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

    public  void update(Card cardX) {
//        card.position.add(card.velocity);
//        card.velocity.add(card.slowdown); // обновление значения переменной velocity путем добавления к нему значения переменной gravity
//        card.cardSprite.setPosition(card.position.x, card.position.y);
//        System.out.println("update");
        switch (cardX.state) {
            case MOVE:
                if (cardX.velocity.y >= 0.0f) {
                    cardX.slowdown.y = 0.0f;
                    cardX.velocity.y = 0.0f;
                    cardX.state = Card.State.STAY;
                    System.out.println(card.state);
                }
//                currentHeight-=speed;
//                if(currentHeight<=0.0){
//                    currentHeight=0.0f;
//                    state=State.GOINGUP;
//                }
                break;
            case STAY:
                break;
        }
        // рисуем только часть изображения зомби. Зависит от высоты над ямой
//        card.cardSprite.setRegion(0, 0, (int)(card.widthCard/scaleFactor), (int)(currentHeight/scaleFactor));
//        card.cardSprite.setSize(card.cardSprite.getWidth(), currentHeight);
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

    }
}
