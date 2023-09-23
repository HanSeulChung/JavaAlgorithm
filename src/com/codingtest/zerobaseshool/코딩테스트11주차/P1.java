package com.codingtest.zerobaseshool.코딩테스트11주차;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class P1 {

    public int solution(int n, int num) {
        String strNum = String.valueOf(num);

        while (n > 0) {
            Set<Integer> set = new HashSet<>();
            for (char c : strNum.toCharArray()) {
                set.add(Character.getNumericValue(c));
            }

            List<Integer> list = set.stream()
                    .sorted().collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            for (int j : list) {
                long c = strNum.chars().filter(chr -> chr == (char) (j + '0')).count();
                sb.append(j);
                sb.append(c);
            }

            strNum = sb.toString();
        }

        BigInteger bigInteger = new BigInteger(strNum);
        return bigInteger.mod(new BigInteger("10004")).intValue();
    }


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
