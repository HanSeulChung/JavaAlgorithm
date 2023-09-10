package com.codingtest.programmers.level0.조건문자열;

import java.util.Map;
import java.util.function.BiFunction;


public class Solution {
    public int mySolution(String ineq, String eq, int n, int m) {
        int answer = 0;

        if (ineq.equals("<")) {
            switch(eq) {
                case "=" :
                    if (n <= m) {
                        return 1;
                    }
                case "!" :
                    if (n < m) {
                        return 1;
                    }
            }
        } else {
            switch(eq) {
                case "=" :
                    if (n >= m) {
                        return 1;
                    }
                case "!" :
                    if (n > m) {
                        return 1;
                    }
            }
        }
        return answer;
    }

    // Map.of ??
//    public int solution(String ineq, String eq, int n, int m) {
//        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
//                ">=", (a, b) -> a >= b,
//                "<=", (a, b) -> a <= b,
//                ">!", (a, b) -> a > b,
//                "<!", (a, b) -> a < b
//        );
//
//        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
//    }

    public int booleanSolution(String ineq, String eq, int n, int m) {
        boolean answer = false;
        if (ineq.equals(">") && eq.equals("="))
            answer = n >= m;
        else if (ineq.equals("<") && eq.equals("="))
            answer = n <= m;
        else if (ineq.equals(">") && eq.equals("!"))
            answer = n > m;
        else
            answer = n < m;
        return answer ? 1 : 0;
    }
}
