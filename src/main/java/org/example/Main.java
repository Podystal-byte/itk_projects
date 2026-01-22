package org.example;

import org.example.task1.DiyStringBuilder;

public class Main {
    public static void main(String[] args) {
        DiyStringBuilder diyStringBuilder = new DiyStringBuilder();



        diyStringBuilder.append("Доделал");

        diyStringBuilder.append(" задание");

        System.out.println(diyStringBuilder.getValue());

        String x = diyStringBuilder.undo(1);


        System.out.println(x);
    }
}
