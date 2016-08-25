# JMP-7

Implement message bus using Producer-Consumer pattern.


1. Implement asynchronous message bus. Please use different queue implementations from java.util.concurrent (Check difference between behaviour ConcurrentLinkedQueue, ArrayBlockingQueue, SynchronousQueue).


2. Implement producer, which will generate and post randomly messages to the queue


3. Implement consumer, which will consume messages on specific topic and log to the console message payload


Application should create several consumers and producers that run in parallel. Use Executors to run all threads.