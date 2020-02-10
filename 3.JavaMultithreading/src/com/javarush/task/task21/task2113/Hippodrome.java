package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome extends Thread {
    private List<Horse> horses;

    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args)  {
        Horse tonya = new Horse("Tonya",3,0);
        Horse marina = new Horse("Marina", 3,0);
        Horse glasha = new Horse("Glasha",3,0);
        List<Horse> hippo = new ArrayList<>();
        hippo.add(tonya);
        hippo.add(marina);
        hippo.add(glasha);
        game = new Hippodrome(hippo);
        game.run();
        game.printWinner();
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
        }
    }

    public void run()  {
        for (int i =1;i<=100;i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        for(int i = 0;i<10;i++){
            System.out.println();
        }
    }

    public  Horse getWinner(){
        Horse winner = new Horse("",0,0);
        for (Horse horse : horses){
            if (horse.getDistance()>winner.getDistance()){
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        Horse winner = getWinner();
        System.out.println("Winner is " + winner.getName() + "!");
    }
}

