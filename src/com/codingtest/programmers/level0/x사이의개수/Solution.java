package com.codingtest.programmers.level0.x사이의개수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] mySolution(String myString) {
        List<Integer> list = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == 'x') {
                list.add(cnt);
                cnt = 0;
            } else {
                cnt++;
            }

            if (i == myString.length() - 1) {
                list.add(cnt);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution(String myString) {

        return Arrays.stream(myString.split("x", myString.length()))
                .mapToInt(x -> x.length())
                .toArray();
    }
}
