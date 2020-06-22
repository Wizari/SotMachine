package com.gmail.wizaripost.utility;

import com.gmail.wizaripost.exceptions.OutOfRangeException;

public class Helper {
    public static float getXPosition(float width, float widthCard, float range, int id)  {
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
            result = ((width / 2 - widthCard / 2) + ((widthCard + range)*2));

        } else {
//            throw new OutOfRangeException("di должен быть от 1 до 5. Ваш id:", id);
            System.out.println("di должен быть от 1 до 5");
        }



        return result;
    }




}
