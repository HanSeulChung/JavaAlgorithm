package com.codingtest.zerobaseschool.코딩테스트10주차;

public class P2 {


    public int mySolution(int num) {
        // int -> int[] 로 변환

        return num;
    }

    public int solution(int num) {
        // 브루트포스가 아니라 그리디로 풀어야한다.

        final char[] digits = String.valueOf(num).toCharArray();

        // 자릿수가 낮아지면서 숫자가 커지는 위치가 있는지 확인
        // O(n)
        int incIdx = -1;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > digits[i - 1]) {
                incIdx = i;
                break;
            }
        }

        if (incIdx == -1) {
            return num;
        }

        // 위에서 찾은 숫자를 기준으로 더 큰 숫자가 있는지 확인
        // 크기가 같더라도, 더 낮은 자리수라면 그걸로 ㄱ체
        // 크기가 크면서 자릿수가 낮은 숫자를 찾는다
        // O(n)
        char maxVal = digits[incIdx];
        int maxIdx = incIdx;
        for (int i = incIdx + 1; i < digits.length; i++) {
            if (digits[i] >= maxVal) {
                maxVal = digits[i];
                maxIdx = i;
            }
        }

        // 큰 자리수부터 교체할 maxVal보다 작은 숫자를 찾고 스탑 return
        // O(n)
        for (int i = 0; i < incIdx; i++){
            if (digits[i] < maxVal) {
                digits[maxIdx] = digits[i];
                digits[i] = maxVal;
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        return num;
    }
}
