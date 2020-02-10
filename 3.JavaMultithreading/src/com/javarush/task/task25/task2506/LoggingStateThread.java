package com.javarush.task.task25.task2506;

import java.sql.SQLOutput;

public class LoggingStateThread extends Thread {
    public Thread thread;
    public State state;
    public LoggingStateThread(Thread thread){
        this.thread=thread;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(state);
                if (state == State.TERMINATED) {
                    break;
                }
            }
        }
    }
}
