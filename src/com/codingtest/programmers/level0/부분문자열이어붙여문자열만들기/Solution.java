package com.codingtest.programmers.level0.부분문자열이어붙여문자열만들기;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public String mySolution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int[] part : parts) {
            sb.append(my_strings[idx++].substring(part[0], part[1] + 1));
        }
        return sb.toString();
    }

    public String streamSolution(String[] myStrings, int[][] parts) {
        return IntStream.range(0, myStrings.length).mapToObj(i -> myStrings[i].substring(parts[i][0], parts[i][1] + 1)).collect(Collectors.joining());
    }
}
