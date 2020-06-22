package com.gmail.wizaripost.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.gmail.wizaripost.gameobjects.Background;
import com.gmail.wizaripost.gameobjects.SpinLine;
import com.gmail.wizaripost.gameobjects.StartButton;
import lombok.Data;

@Data
public class GameManager {

    Background background;
    static Vector3 temp = new Vector3(); // временный вектор для хранения входных координат
    private static FrameRate frameRate;
    public static SpinLine spinLine;
    public static SpinLine spinLine2;
    public static SpinLine spinLine3;
    public static SpinLine spinLine4;
    public static SpinLine spinLine5;
    private StartButton startButton;


    public void initialize(float width, float height) {
        background = new Background();
        background.initialize(width, height);
        spinLine = new SpinLine();
        spinLine.initialize(width, height, -17.00f, 0.1f, 30, 1);
        spinLine2 = new SpinLine();
        spinLine2.initialize(width, height, -22.50f, 0.1f, 35, 2);
        spinLine3 = new SpinLine();
        spinLine3.initialize(width, height, -30.00f, 0.1f, 70, 3);
        spinLine4 = new SpinLine();
        spinLine4.initialize(width, height, -40.00f, 0.1f, 100, 4);
        spinLine5 = new SpinLine();
        spinLine5.initialize(width, height, -50.00f, 0.1f, 160, 5);

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
        spinLine.dispose();
        spinLine2.dispose();
        spinLine3.dispose();
        spinLine4.dispose();
        spinLine5.dispose();
    }

}
