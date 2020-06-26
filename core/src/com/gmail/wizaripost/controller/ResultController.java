package com.gmail.wizaripost.controller;

import java.util.ArrayList;

public class ResultController {
    public ArrayList<Integer> getRandomResult() {
        ArrayList array = new ArrayList<Integer>();
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
//        int randomNumber = 2;
        if (randomNumber == 1) {
            for (int i = 0; i < 15; i++) {
                array.add(1);
            }
            return array;
        }
        if (randomNumber == 2) {
            for (int i = 0; i < 15; i++) {
                array.add(2);
            }
            return array;
        }
        if (randomNumber == 3) {
            for (int i = 0; i < 15; i++) {
                array.add(3);
            }
            return array;
        }
        if (randomNumber == 4) {
            for (int i = 0; i < 15; i++) {
                array.add(4);
            }
            return array;
        }
        if (randomNumber == 5) {
            for (int i = 0; i < 15; i++) {
                array.add(5);
            }
            return array;
        }
        if (randomNumber == 6) {
            for (int i = 0; i < 15; i++) {
                array.add(6);
            }
            return array;
        } else {
            for (int i = 0; i < 15; i++) {
                array.add(7);
            }
            return array;
        }

//        return
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

