package com.gmail.wizaripost.controller;

import java.util.ArrayList;

public class ResultController {
    public ArrayList<Integer> getResult(int amountSpinVisibleElements,
                                        int amountSpins) {
        ArrayList array = new ArrayList<Integer>();
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (j < amountSpinVisibleElements) {
                    array.add(randomNumber);
                } else {
                    array.add(a + (int) (Math.random() * b));
                }
            }
        }
        System.out.println(array);
            return array;
        }


    public ArrayList<Integer> getStartMatrix(int amountSpinVisibleElements,
                                             int amountSpins) {
        ArrayList array = new ArrayList<Integer>();
        int a = 1; // Начальное значение диапазона - "от"
        int b = 7; // Конечное значение диапазона - "до"
        int randomNumber = a + (int) (Math.random() * b);

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (j >= amountSpinVisibleElements) {
                        array.add(a + (int) (Math.random() * b));
                    } else {
                        array.add(randomNumber);
                    }
                }
            }
            return array;
        }
    }

