package com.codingtest.programmers.level0.리스트자르기;

import java.util.stream.IntStream;

public class Solution {
    public int[] mySolution(int n, int[] slicer, int[] num_list) {
        int idx = 0;
        int[] answer = {};
        switch (n) {
            case 1:
                idx = 0;
                answer = new int[slicer[1] - 0 + 1];
                for (int i = 0; i < slicer[1] + 1; i++) {
                    answer[idx++] = num_list[i];
                }
                break;
            case 2:
                idx = 0;
                answer = new int[num_list.length - slicer[0]];
                for (int i = slicer[0]; i < num_list.length; i++) {
                    answer[idx++] = num_list[i];
                }
                break;

            case 3:
                idx = 0;
                answer = new int[slicer[1] - slicer[0] + 1];
                for (int i = slicer[0]; i < slicer[1] + 1; i++) {
                    answer[idx++] = num_list[i];
                }
                break;

            case 4:
                idx = 0;
                answer = new int[
                        (slicer[1] - slicer[0] + 1) % slicer[2] == 0 ? (slicer[1] - slicer[0] + 1) / slicer[2] : (slicer[1] - slicer[0] + 1) / slicer[2]  + 1];
                for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                    answer[idx++] = num_list[i];
                }
                break;
        }
        return answer;
    }

    public int[] solution(int n, int[] slicer, int[] num_list) {
        int start = n == 1 ? 0 : slicer[0];
        int end = n == 2 ? num_list.length - 1 : slicer[1];
        int step = n == 4 ? slicer[2] : 1;
        int[] answer = new int[(end - start + step) / step];
        for (int i = start, j = 0; i <= end; i += step) {
            answer[j++] = num_list[i];
        }
        return answer;
    }

//    public int[] streamSolution(int n, int[] slicer, int[] numList) {
//        return IntStream.iterate(n == 1 ? 0 : slicer[0], i -> i <= (n == 2 ? numList.length - 1 : slicer[1]), i -> n == 4 ? i + slicer[2] : i + 1).map(i -> numList[i]).toArray();
//    }
}
