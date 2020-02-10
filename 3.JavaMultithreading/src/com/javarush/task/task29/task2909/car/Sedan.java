package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {

    public  Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    public int getMaxSpeed(){
        final int SEDAN_MAX_SPEED = 120;
        return SEDAN_MAX_SPEED;
    }
}
