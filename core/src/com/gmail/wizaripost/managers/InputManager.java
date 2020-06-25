package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.gmail.wizaripost.SlotMachineCore;
import com.gmail.wizaripost.gameobjects.SpinLine;
import com.gmail.wizaripost.gameobjects.StartButton;

public class InputManager {



    public void handleInput(OrthographicCamera camera, GameManager gameManager) {
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

                gameManager.spinLine.reRun();
                gameManager.spinLine2.reRun();
                gameManager.spinLine3.reRun();
                gameManager.spinLine4.reRun();
                gameManager.spinLine5.reRun();
            }

//                GameManager.spinLine.reRun();
//                GameManager.spinLine2.reRun();
//                GameManager.spinLine3.reRun();
//                GameManager.spinLine4.reRun();
//                GameManager.spinLine5.reRun();
//            }
//            if (!GameManager.spinLine.lockButtonStart &&
//                    !GameManager.spinLine2.lockButtonStart &&
//                    !GameManager.spinLine3.lockButtonStart &&
//                    !GameManager.spinLine4.lockButtonStart &&
//                    !GameManager.spinLine5.lockButtonStart) {
//                GameManager.spinLine.reRun();
//                GameManager.spinLine2.reRun();
//                GameManager.spinLine3.reRun();
//                GameManager.spinLine4.reRun();
//                GameManager.spinLine5.reRun();
//            }

            System.out.println("Button start");
        }
    }
}
