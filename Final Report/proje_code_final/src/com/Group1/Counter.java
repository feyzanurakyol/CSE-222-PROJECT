package com.Group1;

public class Counter {
    private static int counter = 0;
    public static int getID(){
        counter++;
        return counter;
    }
}
