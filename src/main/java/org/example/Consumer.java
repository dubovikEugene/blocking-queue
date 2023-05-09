package org.example;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private Integer consumerNumber;
    private BlockingQueue<Message> blockingQueue;

    public Consumer( BlockingQueue<Message> blockingQueue, Integer consumerNumber) {
        this.blockingQueue = blockingQueue;
        this.consumerNumber = consumerNumber;
    }

    @Override
    public void run() {
        try {
            Message message;
            while (!(message = blockingQueue.take()).getMessage().equals("Exit")) {
                Thread.sleep(500);
                System.out.printf(" Consumed by %s %s \n", consumerNumber, message.getMessage());

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
