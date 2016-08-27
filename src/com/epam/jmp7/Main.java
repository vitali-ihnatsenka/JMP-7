package com.epam.jmp7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final int CONSUMERS_NUMBER = 5;
    private static final int PRODUCERS_NUMBER = 5;
    private static final int PRODUCER_MESSAGES_NUMBER = 10;

    public static void main(String[] args) {
        BlockingQueue sharedQueue = new LinkedBlockingQueue<Integer>();
        ExecutorService producersExecutor = Executors.newFixedThreadPool(PRODUCERS_NUMBER);
        ExecutorService consumersExecutor = Executors.newFixedThreadPool(CONSUMERS_NUMBER);

        for (int i = 0; i < CONSUMERS_NUMBER; i++) {
            producersExecutor.execute(new Producer(sharedQueue, PRODUCER_MESSAGES_NUMBER));
        }

        for (int i = 0; i < PRODUCERS_NUMBER; i++) {
            consumersExecutor.execute(new Consumer(sharedQueue));
        }
    }
}
