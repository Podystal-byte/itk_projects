package org.example.task3.task3_2;

import java.util.Random;

public class ComplexTask {
    Random random = new Random();

    public void execute() throws InterruptedException {
        Thread.sleep(random.nextInt());
    }
}
