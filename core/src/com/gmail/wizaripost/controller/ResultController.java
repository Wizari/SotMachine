package com.gmail.wizaripost.controller;

import java.util.ArrayList;

public class ResultController {
    public ArrayList<Integer> getRandomResult() {
        ArrayList array = new ArrayList<Integer>();
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
//        int randomNumber = 2;

            for (int i = 0; i < 15; i++) {
                array.add(randomNumber);
            }
            return array;
        }


    public ArrayList<Integer> getStartMatrix() {
        ArrayList array = new ArrayList<Integer>();
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (j == 5) {
                        array.add(a + (int) (Math.random() * b));
                    } else {
                        array.add(randomNumber);
                    }
                }
            }
            return array;
        }
    }

