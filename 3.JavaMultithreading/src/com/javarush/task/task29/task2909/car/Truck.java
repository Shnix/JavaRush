package com.javarush.task.task29.task2909.car;

public class Truck extends Car {
    public Truck( int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    public int getMaxSpeed(){
        final int TRUCK_MAX_SPEED = 80;
        return TRUCK_MAX_SPEED;
    }
}