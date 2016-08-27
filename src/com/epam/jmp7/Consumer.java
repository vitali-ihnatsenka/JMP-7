package com.epam.jmp7;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Vitali on 27.08.2016.
 */
public class Consumer implements Runnable {
    BlockingQueue<String> sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                if(!sharedQueue.isEmpty()){
                    System.out.println("Consumed: "+ sharedQueue.take());
                    Thread.currentThread().sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
