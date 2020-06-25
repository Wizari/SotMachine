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
    public SpinLine spinLine;//TODO
    public SpinLine spinLine2;
    public SpinLine spinLine3;
    public SpinLine spinLine4;
    public SpinLine spinLine5;
    private StartButton startButton;

    public void initialize(float width, float height) {
        background = new Background();
        background.initialize(width, height);
        spinLine = new SpinLine();
        spinLine.initialize(width, height, 30, 1, 1, 1, 1);
        spinLine2 = new SpinLine();
        spinLine2.initialize(width, height, 40, 2, 1, 1, 1);
        spinLine3 = new SpinLine();
        spinLine3.initialize(width, height, 50, 3, 1, 1, 1);
        spinLine4 = new SpinLine();
        spinLine4.initialize(width, height, 60, 4, 1, 1, 1);
        spinLine5 = new SpinLine();
        spinLine5.initialize(width, height, 75, 5, 1, 1, 1);

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
