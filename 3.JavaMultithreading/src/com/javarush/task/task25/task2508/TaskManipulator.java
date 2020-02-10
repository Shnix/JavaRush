package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        while (true) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        Thread thread = new Thread(this,threadName);
        this.thread=thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
