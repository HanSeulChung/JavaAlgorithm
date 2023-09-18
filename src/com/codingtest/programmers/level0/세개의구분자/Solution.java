package com.codingtest.programmers.level0.세개의구분자;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String[] mySolution(String myStr) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (char c : myStr.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                if (sb.length() > 0) {
                    list.add(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        if (sb.length() > 0) {
            list.add(sb.toString());
        }

        return list.size() == 0 ? new String[]{"EMPTY"} : list.toArray(new String[0]);
    }
}
