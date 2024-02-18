package com.codingtest.zerobaseschool.코딩테스트7주차;

import java.util.ArrayList;
import java.util.List;

public class P3 {
    List<String> addressList = new ArrayList<>();

    public String[] solution(String s) {
        solve(s, new ArrayList<>());
        return addressList.stream().sorted().toArray(String[] :: new);
    }

    void solve(String s, List<Integer> dots) {
        int n = dots.size();
        if (n == 3) {
            if (isPromising(s.substring(dots.get(2)))) {
                addressList.add(makeAddress(s, dots));
            }
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (n == 0) {
                dots.add(i);
                if ( i < s.length() &&
                        isPromising(s.substring(0, i))) {
                    solve(s, dots);
                    }
                } else {
                int lastDot = dots.get(n - 1);
                int currDot = lastDot + i;
                dots.add(currDot);
                if (currDot < s.length() &&
                        isPromising(s.substring(lastDot, currDot))) {
                    solve(s, dots);
                }
            }
            dots.remove(n);
        }
    }

    boolean isPromising(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        int n = Integer.parseInt(s);
        if (n >= 0 && n <= 255) {
            return true;
        }
        return false;
    }

    String makeAddress (String s, List<Integer> dots) {
        return s.substring(0, dots.get(0)) + "." +
                s.substring(dots.get(0), dots.get(1)) + "." +
                s.substring(dots.get(1), dots.get(2)) + "." +
                s.substring(dots.get(2));
    }
}
