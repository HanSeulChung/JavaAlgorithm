package com.codingtest.programmers.level0.문자열잘라서정렬하기;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Solution {
    public String[] mySolution(String myString) {
        if (!myString.contains("x")) {
            return new String[]{myString};
        }
        String[] answer = myString.split("x+");
        Arrays.sort(answer);

        if (!answer[0].equals("")) {
            return answer;
        }

        String[] replaceAnswer = new String[answer.length - 1];
        for (int i = 0; i < replaceAnswer.length; i++) {
            replaceAnswer[i] = answer[i + 1];
        }
        return replaceAnswer;
    }

    public String[] solution1(String myString) {
        StringTokenizer st = new StringTokenizer(myString, "x");
        int idx = 0, N = st.countTokens();
        String[] result = new String[N];
        for (int n = 0;n < N;n++)
            result[idx++] = st.nextToken();
        Arrays.sort(result);
        return result;
    }

    public String[] solution2(String myString) {
        return Stream.of(myString.split("x")).filter(str->str.length()>0).sorted().toArray(String[]::new);
    }
}
