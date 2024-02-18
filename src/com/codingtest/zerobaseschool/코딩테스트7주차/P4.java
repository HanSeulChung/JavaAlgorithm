package com.codingtest.zerobaseschool.코딩테스트7주차;

import java.util.ArrayList;
import java.util.List;

public class P4 {
    int[] res;
    long MAX_INT = (long)Integer.MAX_VALUE;

    public int[] solution(String num) {
        res = new int[0];
        backTrack(num, new ArrayList<>());
        return res;
    }

    void backTrack(String s, List<Integer> path) {
        // 남은 문자열이 없고, 마지막 세개의 수가 피보나치 수열을 만족하면 정답
        if (s.equals("") && path.size() >= 3 && isFibo(path)) {
            res = path.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            return;
        }

        for (int i = 1; i < s.length() + 1; i++) {

            if ((i > 1 && s.charAt(0) =='0') ||
                    (Long.parseLong(s.substring(0, i)) > MAX_INT)) {
                return;
            }

            if (path.size() >= 3 && !isFibo(path)) {
                return;
            }
//            List<Integer> newPath = new ArrayList<>();
//            newPath.add(Integer.parseInt(s.substring(0, i)));
//            backTrack(s.substring(i), newPath);

            path.add(Integer.parseInt(s.substring(0, i)));
            backTrack(s.substring(i), path);
            path.remove(path.size() - 1);
        }
    }

    boolean isFibo(List<Integer> arr) {
        int n = arr.size();
        return arr.get(n - 3) + arr.get(n - 2) == arr.get(n - 1);
    }
}
