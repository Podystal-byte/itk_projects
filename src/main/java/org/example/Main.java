package org.example;

import org.example.task1.DiyStringBuilder;
import org.example.task2.Task2;
import org.example.task2.Task2_1;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DiyStringBuilder diyStringBuilder = new DiyStringBuilder();



        diyStringBuilder.append("Доделал");

        diyStringBuilder.append(" задание");

        System.out.println(diyStringBuilder.getValue());

        String x = diyStringBuilder.undo(1);


        System.out.println(x);

        Task2_1<String> task2 = new Task2_1<>();

        String[] strings = new String[]{"a", "a", "b", "a", "b", "c", "a", "a", "y"};

        Map<String, Integer> map = task2.countElemMap(strings);

        System.out.println(map);



    }
}
