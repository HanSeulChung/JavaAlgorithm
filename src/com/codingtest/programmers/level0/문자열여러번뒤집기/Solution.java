package com.codingtest.programmers.level0.문자열여러번뒤집기;

public class Solution {

    static String answer;
    public void swapString(int start, int end, char[] charArray) {
        for (int i = start; i < (end + start + 1) / 2; i++){
            char tmp = charArray[(start + end) - i];
            charArray[(start + end) - i] = charArray[i];
            charArray[i] = tmp;
        }
        answer = new String(charArray);
    }

    public String mySolution(String my_string, int[][] queries) {
        char[] charArray = my_string.toCharArray();
        for (int[] query : queries) {
            swapString(query[0], query[1], charArray);
        }
        return answer;
    }
    public String streamSolution(String myString, int[][] queries) {
        for (int[] arr : queries) {
            myString = myString.substring(0, arr[0]) + new StringBuilder(myString.substring(arr[0], arr[1] + 1)).reverse().toString() + myString.substring(arr[1] + 1);
        }
        return myString;
    }

    static StringBuilder rvr(StringBuilder s, int l, int r) {
        StringBuilder t = new StringBuilder(s.substring(l, r + 1));
        t.reverse();
        s.replace(l, r + 1, t.toString());
        return s;
    }

    public String rvrSolution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);
        for (int[] q : queries) {
            answer = rvr(answer, q[0], q[1]);
        }
        return answer.toString();
    }

    char[] arr;

    public String awesomeSolution(String my_string, int[][] queries) {

        arr = my_string.toCharArray();

        for (int[] query : queries) {
            reverse(query[0], query[1]);
        }

        return new String(arr);
    }

    private void reverse(int s, int e) {
        while (s < e) {
            char temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }
}
