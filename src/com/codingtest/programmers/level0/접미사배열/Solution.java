package com.codingtest.programmers.level0.접미사배열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public String[] mySolution(String my_string) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < my_string.length(); i++){
            list.add(my_string.substring(i));
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    public String[] streamSolution(String myString) {
        return IntStream.range(0, myString.length()).mapToObj(myString::substring).sorted().toArray(String[]::new);
    }
}
