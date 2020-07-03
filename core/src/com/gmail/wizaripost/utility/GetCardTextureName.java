package com.gmail.wizaripost.utility;

public class GetCardTextureName {

    public static String getRandomTextureName() {
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
        return randomNumber +".jpg";
    }

    public static String getRandomSpriteSheetUnitName() {
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
        return ""+randomNumber;
    }


}
