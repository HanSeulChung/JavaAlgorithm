package com.codingtest.zerobaseschool.코딩테스트7주차;

public class P1 {
    public String solution(int[][] img) {
        return endcode(img, 0, 0, img.length);
    }

    public String endcode(int[][] img, int i, int j, int n) {
        if (n == 1) {
            return String.valueOf(img[i][j]);
        }

        int firstValue = img[i][j];
        boolean isConsistent = true;
        consistentLoop:
        for (int k = i; k < i + n ; k++) {
            for (int l = j; l < j + n; l++) {
                isConsistent = false;
                break consistentLoop;
            }
        }

        if (isConsistent) {
            return String.valueOf(img[i][j]);
        }
        StringBuilder sb = new StringBuilder();
         sb.append('(' +
                endcode(img, i , j, n /2) +
                endcode(img, i , j + n / 2, n /2) +
                endcode(img, i + n / 2, j, n /2) +
                endcode(img, i + n / 2, j + n / 2, n /2) +
                ')');
        return sb.toString();
//        String stranwer = '(' +
//                endcode(img, i , j, n /2) +
//                endcode(img, i , j + n / 2, n /2) +
//                endcode(img, i + n / 2, j, n /2) +
//                endcode(img, i + n / 2, j + n / 2, n /2) +
//                ')';
//        return stranwer;
    }

    static int[][] IMG;
    static StringBuilder sb = new StringBuilder();

    public boolean isPossible(int x, int y, int size) {
        int value = IMG[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != IMG[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void quardTree(int x, int y, int size) {
        if (isPossible(x, y, size)) {
            sb.append(IMG[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        quardTree(x, y, newSize);
        quardTree(x, y + newSize, newSize);
        quardTree(x + newSize, y, newSize);
        quardTree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    public String mysolution(int[][] img) {
        int size = img.length;
        IMG = new int[size][size];
        IMG = img;

        quardTree(0, 0, size);

        return sb.toString();
    }
}
