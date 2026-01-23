package org.example.task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2_1<T> {
    public Map<T, Integer> countElemMap(T[] array){
        List<T> list = Arrays.asList(array);
        List<T> distinct = list.stream().distinct().toList();

        Map<T, Integer> map = new HashMap<>();
        for (T t: distinct){
            for (int i = 0; i < list.size(); i++){
                if (t.equals(list.get(i))){
                    map.put(t, map.getOrDefault(t, 0) + 1);
                }
            }
        }

        return map;
    }
}
