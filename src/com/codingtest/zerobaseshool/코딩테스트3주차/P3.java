package com.codingtest.zerobaseshool.코딩테스트3주차;

public class P3 {
    static int time;
    static int delayTime;
    static int result;
    public static int solution(int delay, int N) {
        result = 1;
        time = N;
        delayTime = delay;

        divide(0, 1);

        return result;
    }

    public static void divide(int cnt, int amebacnt) {
        if (cnt == time) {
            result = amebacnt;
            return;
        }
        amebacnt *= 2;
        divide(cnt + 1, amebacnt / 2);
        divide(cnt + delayTime, amebacnt / 2);
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 5));
    }
}
