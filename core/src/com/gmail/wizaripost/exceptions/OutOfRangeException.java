package com.gmail.wizaripost.exceptions;

public class OutOfRangeException extends Exception {

    private int number;
    public int getNumber(){return number;}
    public OutOfRangeException(String message, int num){

        super(message);
        number=num;
    }
}
