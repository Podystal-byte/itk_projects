package org.example.task2;

import java.util.Arrays;

public class Task2<T> {
    public T[] filter(T[] t, Filter<T> map){
        T[] result = Arrays.copyOf(t, t.length);

        for (int i = 0; i < result.length; i++){
            result[i] = map.apply(result[i]);
        }

        return result;
    }
}

interface Filter<T>{
    T apply(T t);
}
