package com.codingtest.programmers.level0.문자앞or뒤의n글자;

public class Solution {

    /**
     *  뒤의 n글자
     * @param my_string
     * @param n
     * @return
     */
    public String mySolution1(String my_string, int n) {
        String answer = my_string.substring(my_string.length() - n, my_string.length());
        return answer;
    }

    public String simpleSolution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }

    /**
     * 앞의 n글자
     */

    public String mySolution2(String my_string, int n) {
        String answer = my_string.substring(0, n);
        return answer;
    }
}
