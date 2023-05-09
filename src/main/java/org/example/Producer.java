package org.example;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private Integer producerNumber;
    private BlockingQueue<Message> blockingQueue;

    public Producer(BlockingQueue<Message> blockingQueue, Integer producerNumber) {
        this.blockingQueue = blockingQueue;
        this.producerNumber = producerNumber;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            var message = new Message(String.format("message No %s, produced by producer No %s", i, producerNumber));

            try {
                Thread.sleep(100);
                blockingQueue.put(message);
                System.out.printf("Produced %s \n", message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        var exitMsg = new Message("Exit");
        try {
            blockingQueue.put(exitMsg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
