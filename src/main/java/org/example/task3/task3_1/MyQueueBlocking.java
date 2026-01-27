package org.example.task3.task3_1;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueueBlocking <T>{
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;


    public MyQueueBlocking(int capacity) {
        this.capacity = capacity;
    }


    public synchronized void enqueue(T elem) throws InterruptedException {
        while (queue.size() == capacity){
            this.wait();
        }

        queue.add(elem);

        this.notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()){
            this.wait();
        }

        T elem = queue.poll();

        this.notifyAll();
        return elem;
    }

    public synchronized int size() {
        return queue.size();
    }
}
