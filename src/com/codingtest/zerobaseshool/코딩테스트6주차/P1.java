package com.codingtest.zerobaseshool.코딩테스트6주차;

public class P1 {
    public int[] bestsolution(int[] values) {
        int left = 0;
        int right = 0;
        int[] answer = {left, right};

        while (right < values.length - 1) {
            while (right < values.length - 1 && values[right] < values[right + 1]) {
                right++;
            }

            if (answer[1] - answer[0] < right - left) {
                answer = new int[]{left, right};
            }

            left = right + 1;
            right = left;
        }
        return answer;
    }
    // 투포인터
    public int[] mysolution(int[] values) {
        int n = values.length;
        int left = 0;
        int right = 0;
        int maxLength = 0; // 가장 긴 우상향 구간의 길이
        int maxStart = 0; // 가장 긴 우상향 구간의 시작 인덱스

        while (right < n - 1) {
            while (right < n - 1 && values[right] < values[right + 1]) {
                right++;
            }

            int length = right - left + 1;

            if (length > maxLength) {
                maxLength = length;
                maxStart = left;
            }

            left = right + 1;
            right = left;
        }

        return (maxLength == 0) ? new int[]{0, 0} : new int[]{maxStart, maxStart + maxLength - 1};
    }

    public int[] solution1(int[] values) {
        int left = 0, right = 0;
        int[] result = {left, right};

        while (left <= right) {
            boolean increasing = true;
            for (int i = left; i < right; i++) {
                if (values[i] >= values[i + 1]) {
                    increasing = false;
                    break;
                }
            }

            if (increasing) {
                if (result[1] - result[0] < right - left) {
                    result = new int[]{left, right};
                }
                right++;
                if (right == values.length) {
                    break;
                }
            } else {
                left++;
            }
        }
        return result;
    }

    public int[] solution2(int[] values) {
        int left = 0, right = 0;
        int[] result = {left, right};

        while (left <= right)    {
            if (right == values.length) {
                break;
            }

            while (values[right] < values[right + 1]) {
                right++;
            }

            if (result[1] - result[0] < right - left) {
                result = new int[]{left, right};
            }

            left = right + 1;
            right = left;
        }
        return result;
    }
}
