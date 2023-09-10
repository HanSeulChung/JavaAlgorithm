package com.codingtest.programmers.level0.수조작하기1;

public class Solution {
    public int mySolution(int n, String control) {

        for (int i = 0; i < control.length(); i++) {
            char controlChar = control.charAt(i);
            switch (controlChar) {
                case 'w' :
                    n += 1;
                    break;
                case 's' :
                    n -= 1;
                    break;
                case 'd' :
                    n += 10;
                    break;
                case 'a' :
                    n -= 10;
                    break;
            }
        }
        return n;
    }

    public int streamSolution(int n, String control) {
        return control.chars().reduce(n, (acc, c) -> acc + (c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10));
    }

    public int charArraySolution1(int n, String control) {
        int answer = n;

        for(char ch : control.toCharArray()) {
            switch(ch) {
                case 'w': answer += 1; break;
                case 's': answer -= 1; break;
                case 'd': answer += 10; break;
                case 'a': answer -= 10; break;
                default:break;
            }
        }

        return answer;
    }
    public int charArraySolution2(int n, String control) {
        for(char c : control.toCharArray()){
            n += c == 'w' ? 1 : c == 's' ? -1 : c == 'd' ? 10 : -10;
        }
        return n;
    }
}
