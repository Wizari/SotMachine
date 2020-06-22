package com.gmail.wizaripost.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.gmail.wizaripost.gameobjects.Background;
import com.gmail.wizaripost.gameobjects.SpinLine;
import com.gmail.wizaripost.gameobjects.StartButton;

public class GameManager {

    Background background;
    static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат
    private static FrameRate frameRate;
    private  SpinLine spinLine;
    private SpinLine spinLine2;
    private SpinLine spinLine3;
    private SpinLine spinLine4;
    private SpinLine spinLine5;
    private StartButton startButton;


    public void initialize(float width, float height) {
        background = new Background();
        background.initialize(width, height);
        spinLine = new SpinLine();
        spinLine.initialize(width, height, 0, 0, -10.00f, 0.1f, 200, 1);
        spinLine2 = new SpinLine();
        spinLine2.initialize(width, height, 100, 0, -20.00f, 0.1f, 200, 2);
        spinLine3 = new SpinLine();
        spinLine3.initialize(width, height, 200, 0, -30.00f, 0.1f, 200, 3);
        spinLine4 = new SpinLine();
        spinLine4.initialize(width, height, 300, 0, -40.00f, 0.1f, 200, 4);
        spinLine5 = new SpinLine();
        spinLine5.initialize(width, height, 400, 0, -50.00f, 0.1f, 300, 5);

        startButton = new StartButton();
        startButton.initialize(width, height);
        frameRate = new FrameRate();
        frameRate.initialize(width, height);
    }

    public void renderGame(SpriteBatch batch) {
        background.renderBack(batch);

        spinLine.renderSpinLine(batch);
        spinLine2.renderSpinLine(batch);
        spinLine3.renderSpinLine(batch);
        spinLine4.renderSpinLine(batch);
        spinLine5.renderSpinLine(batch);

        background.renderMask(batch);
        startButton.displayStartButton(batch);
        frameRate.displayFPS(batch);
    }


    public void dispose() {
        background.dispose();
        startButton.dispose();
    }

}
