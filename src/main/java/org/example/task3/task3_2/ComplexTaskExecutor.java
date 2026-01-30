package org.example.task3.task3_2;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final int tasksCount;
    private final CyclicBarrier barrier;

    public ComplexTaskExecutor(int tasksCount) {
        this.tasksCount = tasksCount;
        this.barrier = new CyclicBarrier(tasksCount);
    }

    public void executeTasks(){
        ExecutorService executor = Executors.newFixedThreadPool(tasksCount);
        ComplexTask task = new ComplexTask();

        for (int i = 0; i < tasksCount; i++) {
            executor.submit(() -> {
                try {
                    task.execute();
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


}
