package com.gmail.wizaripost.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.gmail.wizaripost.gameobjects.Card;
import com.gmail.wizaripost.gameobjects.SpinLine;
import lombok.Data;

@Data
public class Helper {

//    static Texture cardTexture; // текстурное изображение нашего зомби

    public static float getXPosition(float width, float widthCard, float range, int id) {
        float result = 0;
        if (id == 1) {
            result = ((width / 2 - widthCard / 2) - ((widthCard + range) * 2));
        }
        if (id == 2) {
            result = ((width / 2 - widthCard / 2) - (widthCard + range));
        }
        if (id == 3) {
            result = (width / 2 - widthCard / 2);
        }
        if (id == 4) {
            result = ((width / 2 - widthCard / 2) + (widthCard + range));
        }
        if (id == 5) {
            result = ((width / 2 - widthCard / 2) + ((widthCard + range) * 2));

        } else {
//            throw new OutOfRangeException("di должен быть от 1 до 5. Ваш id:", id);
//            System.out.println("di должен быть от 1 до 5");
        }
        return result;
    }

}

