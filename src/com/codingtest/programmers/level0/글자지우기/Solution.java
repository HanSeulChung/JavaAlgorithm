package com.codingtest.programmers.level0.글자지우기;

public class Solution {
    public String mySolution(String my_string, int[] indices) {
        String answer = "";
        char[] charArray = my_string.toCharArray();

        for (int i = 0; i < indices.length; i++) {
            charArray[indices[i]] = 'X';
        }
        return new String(charArray).replace("X", "");
    }

    public String solution1(String my_string, int[] indices) {
        char[] arr = my_string.toCharArray();
        for(int i : indices) {
            arr[i] = ' ';
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != ' ') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
