package com.codingtest.programmers.level0.공백으로구분하기2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] mySolution(String my_string) {
        String[] answer = my_string.split(" +");

        List<String> list = new ArrayList<>();
        for (String a : answer) {
            if (!a.equals("")) {
                list.add(a);
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] solution1(String my_string) {
        return my_string.trim().split("[ ]+");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = s.mySolution("  i Like you   i  ");
    }
}
