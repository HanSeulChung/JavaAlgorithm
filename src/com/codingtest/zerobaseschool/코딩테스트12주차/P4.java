package com.codingtest.zerobaseschool.코딩테스트12주차;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P4 {
    public int mySolution(String s) {
        int answer = 0;

        while(!s.equals("a")) {
            System.out.println(s);
            List<Integer> aList = new ArrayList<>();
            Stack<Integer> aStack = new Stack<>();

            s = s.replaceAll("[a]+", "a");
            char[] charArray = s.toCharArray();

            for (int i = 0; i < charArray.length; i++) {

                if(charArray[i] =='a') {
                    if (aStack.isEmpty() || aStack.peek() != i - 1) {
                        aList.add(i);
                        aStack.add(i);
                    } else if (aStack.peek() == i - 1) {
                        aStack.add(i);
                        aList.remove(Integer.valueOf(i - 1));
                    }
                }
            }


            for (int i = 0; i < aList.size(); i++) {

                if (aList.get(i) - 1 >= 0) {
                    charArray[aList.get(i) - 1] = 'a';
                }
                if (aList.get(i) + 1 < charArray.length) {
                    charArray[aList.get(i) + 1] = 'a';
                }
            }
            s = new String(charArray);

            answer++;
        }

        return answer;
    }


}