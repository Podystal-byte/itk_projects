package org.example.task1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiyStringBuilder {

    private char[] value = new char[]{};

    private List<String> images = new ArrayList<>();


    public char[] append(String str){
        if (str == null){
            return value;
        }
        saveImage(Arrays.toString(value));

        char[] strChar = str.toCharArray();

        char[] newArray = new char[strChar.length + value.length];

        System.arraycopy(value, 0, newArray, 0, value.length);

        System.arraycopy(strChar, 0, newArray, value.length, strChar.length);
        value = newArray;
        return value;
    }

    public String getValue(){
        return Arrays.toString(value);
    }

    private void saveImage(String image){
        images.add(image);
    }

    public String undo(int step){
        if (step == 0){
            return getValue();
        }

        int indexArrayList = images.size() - 1;

        return images.get(indexArrayList);
    }
}
