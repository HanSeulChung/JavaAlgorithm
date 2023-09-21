package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.util.*;

public class P1 {

    public int failSolution(int n, int num) {
        // test case만 됨
        while(n > 0) {
            Map<Character, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            String strNum = String.valueOf(num);
            for (int i = 0; i < strNum.length(); i++) {
                map.put(strNum.charAt(i), map.getOrDefault(strNum.charAt(i), 0) + 1);
            }
            List<Character> list = new ArrayList<>(map.keySet());
            Collections.sort(list);

            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                sb.append(map.get(list.get(i)));
            }

            num = Integer.parseInt(sb.toString());
            n--;
        }

        return num % 10004;
    }
}
