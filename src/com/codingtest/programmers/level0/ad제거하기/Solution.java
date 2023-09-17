package com.codingtest.programmers.level0.ad제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String[] mySolution(String[] strArr) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            }
        }
        return list.toArray(new String[0]);
    }

    public String[] solution1(String[] strArr) {
        List<String> list = Arrays.stream(strArr).filter(m -> !m.contains("ad")).collect(Collectors.toList());
        String[] answer  = new String[list.size()];
        list.toArray(answer);
        return answer;
    }

    public String[] solution2(String[] strArr) {
        return Arrays.stream(strArr).filter(s -> !s.contains("ad")).toArray(String[]::new);
    }
}
