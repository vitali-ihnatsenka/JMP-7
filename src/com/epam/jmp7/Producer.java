package com.epam.jmp7;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Vitali on 27.08.2016.
 */
public class Producer implements Runnable {
    private BlockingQueue<String> sharedQueue;
    private int messagesNumber;

    public Producer(BlockingQueue sharedQueue, int messagesNumber) {
        this.sharedQueue = sharedQueue;
        this.messagesNumber = messagesNumber;
    }

    @Override
    public void run() {
        for(int i=0; i< messagesNumber; i++){
            try {
                sharedQueue.put(Thread.currentThread().getName() + "---" + i);
                System.out.println("Produced: " + Thread.currentThread().getName() + "---" + i);
                Thread.currentThread().sleep(400);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
