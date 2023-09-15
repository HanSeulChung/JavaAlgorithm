package com.codingtest.programmers.level0.five명씩;

public class Solution {
    public String[] mySolution(String[] names) {
        String[] answer = new String[(int)Math.ceil(names.length / (5 * 1.0))];

        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < names.length; i++) {
            cnt++;

            if (cnt == 5) {
                cnt = 0;
            } else if (cnt == 1){
                answer[idx++] = names[i];
            }

        }
        return answer;
    }

    public String[] solution(String[] names) {
        int idx = 0;
        String[] answer = new String[names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1];
        for (int i = 0;i < names.length;i+=5)
            answer[idx++] = names[i];
        return answer;
    }
}
