package org.example;

import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {

        var queue = new ArrayBlockingQueue<Message>(5);
        var producer1 = new Producer(queue, 1);
        var producer2 = new Producer(queue, 2);
        var consumer1 = new Consumer(queue, 1);
        var consumer2 = new Consumer(queue, 2);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        System.out.println("Started");

    }
}