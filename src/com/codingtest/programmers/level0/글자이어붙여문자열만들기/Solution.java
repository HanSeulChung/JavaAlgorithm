package com.codingtest.programmers.level0.글자이어붙여문자열만들기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String mySolution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for (int index : index_list) {
            sb.append(my_string.charAt(index));
        }
        return sb.toString();
    }

    public String streamSolution(String myString, int[] indexList) {
        return Arrays.stream(indexList).mapToObj(operand -> String.valueOf(myString.charAt(operand))).collect(Collectors.joining());
    }
}
