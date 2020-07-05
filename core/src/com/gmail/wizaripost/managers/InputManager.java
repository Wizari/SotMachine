package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gmail.wizaripost.controller.ResultController;
import com.gmail.wizaripost.gameobjects.StartButton;

import java.util.ArrayList;

public class InputManager {

    private ArrayList<Integer> result;
    private int amountSpinVisibleElements;
    private int amountSpins;
    private ResultController resultController = new ResultController();


    public void handleInput(OrthographicCamera camera,
                            GameManager gameManager,
                            int amountSpinVisibleElements,
                            int amountSpins) {

        this.amountSpinVisibleElements = amountSpinVisibleElements;
        this.amountSpins = amountSpins;
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
            handleStartButton(touchX, touchY, gameManager);

        }
    }

//    SpinLine spinLine =


    public void handleStartButton(float touchX, float touchY, GameManager gameManager) {
        // определяем, было ли касание кнопки start, используя границы спрайта
        if ((touchX >= StartButton.startButtonSprite.getX()) && touchX <= (StartButton.startButtonSprite.getX() + StartButton.startButtonSprite.getWidth()) && (touchY >= StartButton.startButtonSprite.getY()) && touchY <= (StartButton.startButtonSprite.getY() + StartButton.startButtonSprite.getHeight())) {

            if (!gameManager.spinLine.lockButtonStart &&
                    !gameManager.spinLine2.lockButtonStart &&
                    !gameManager.spinLine3.lockButtonStart &&
                    !gameManager.spinLine4.lockButtonStart &&
                    !gameManager.spinLine5.lockButtonStart) {
                this.result = resultController.getResult(amountSpinVisibleElements, amountSpins);

                gameManager.spinLine.reRun(result);
                gameManager.spinLine2.reRun(result);
                gameManager.spinLine3.reRun(result);
                gameManager.spinLine4.reRun(result);
                gameManager.spinLine5.reRun(result);
            }

//            System.out.println("Button start");
        }
    }
}
