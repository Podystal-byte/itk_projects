package org.example.task4.task4_3;

import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class FactorialTask extends RecursiveTask<Integer> {
    private final int start;
    private final int end;
    private Integer factorial;

    private static final Integer THRESHOLD = 2; // Это у нас порог того когда задача не делится

    public FactorialTask(Integer factorial) {
        this(1, factorial);
    }

    public FactorialTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int product = 1;
            for (int i = start; i <= end; i++) {
                product *= i;
            }
            return product;
        }

        int mid = start + (end - start) / 2;

        FactorialTask leftTask = new FactorialTask(start, mid);
        FactorialTask rightTask = new FactorialTask(mid + 1, end);

        leftTask.fork();

        int rightResult = rightTask.compute();

        int leftResult = leftTask.join();

        return leftResult * rightResult;
    }
}
