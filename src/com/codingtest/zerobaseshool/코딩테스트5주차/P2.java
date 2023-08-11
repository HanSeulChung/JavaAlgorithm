package com.codingtest.zerobaseshool.코딩테스트5주차;

import java.util.Arrays;
import java.util.Comparator;

public class P2 {
    public static String mysolution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2); // 오름차순
            }
        });

        StringBuilder result = new StringBuilder();
        for (String str : strNumbers) {
            result.append(str);
        }

        String resultstr = result.toString();

        if (resultstr.charAt(0) == '0') {
            return "0";
        }
        return resultstr;
    }

    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers).boxed().sorted((x, y) -> {
            int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
            int b = Integer.parseInt(String.valueOf(y) + String.valueOf(x));
            return b - a; // 내림차순. 만일 오름차순으로 하고싶으면 a - b;
        }).forEach(sb::append);

        String result = sb.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }
}
