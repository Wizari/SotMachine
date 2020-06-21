package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gmail.wizaripost.gameobjects.StartButton;
import com.gmail.wizaripost.utility.GetRandomCardTextureName;

public class InputManager {

    public static void handleInput(OrthographicCamera camera) {

        // Было ли касание экрана?
        if (Gdx.input.justTouched()) {
            // Получаем координаты касания
            // И устанавливаем значения координат в вектор temp
            GameManager.temp.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            // получаем координаты касания
            // относительно области просмотра нашей "камеры"
            camera.unproject(GameManager.temp);
            float touchX = GameManager.temp.x;
            float touchY = GameManager.temp.y;
            // Было ли выполнено касание по кнопке?
            handleStartButton(touchX, touchY);

        }
    }


    public static void handleStartButton(float touchX, float touchY) {
        // определяем, было ли касание кнопки start, используя границы спрайта
        if ((touchX >= StartButton.startButtonSprite.getX()) && touchX <= (StartButton.startButtonSprite.getX() + StartButton.startButtonSprite.getWidth()) && (touchY >= StartButton.startButtonSprite.getY()) && touchY <= (StartButton.startButtonSprite.getY() + StartButton.startButtonSprite.getHeight())) {
//            System.out.println("StartButton");
            System.out.println(GetRandomCardTextureName.getTexture());


            //            GameManager.restartGame();
        }
    }
}
