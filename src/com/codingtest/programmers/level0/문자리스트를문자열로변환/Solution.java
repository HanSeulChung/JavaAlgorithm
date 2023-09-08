package com.codingtest.programmers.level0.문자리스트를문자열로변환;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String stringbuilderSolution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (String ele : arr) {
            sb.append(ele);
        }
        return sb.toString();
    }

    public String joinSolution(String[] arr) {
        return String.join("", arr);
    }

    public String streamSolution(String[] arr) {

        String stringArrayToString = Arrays.stream(arr)
                                        .collect(Collectors.joining());
        return stringArrayToString;
    }

}
