package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class RacingBike extends Motorbike {
    private String owner;
    private int age;

    public RacingBike(String name, String owner, int age) {
        super(name);
        this.owner = owner;
        this.age = age;
    }

    public RacingBike() {
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "RacingBike{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", age=" + age +
                '}';
    }
}