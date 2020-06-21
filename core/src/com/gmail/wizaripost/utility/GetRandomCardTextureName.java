package com.gmail.wizaripost.utility;

public class GetRandomCardTextureName {
//    private int a = 1; // Начальное значение диапазона - "от"
//    private int b = 7; // Конечное значение диапазона - "до"

    public static String getTexture() {
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
        return randomNumber +".jpg";
    }

}
