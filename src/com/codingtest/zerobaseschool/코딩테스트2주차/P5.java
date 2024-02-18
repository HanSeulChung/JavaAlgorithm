package com.codingtest.zerobaseschool.코딩테스트2주차;

public class P5 {
    public static int[][] solution(int[][] image, int K) {
        int rowN = image.length;
        int colN = image[0].length;
        int[][] answer = new int[rowN][colN];

        for (int row = 0; row < rowN; row++) {
            for (int col = 0; col < colN; col++) {
                answer[row][col] = calMask(image, col, row, K);
            }
        }
        return answer;
    }

    private static int calMask(int[][] image, int x, int y, int K) {
        int result = 0;
        if (K % 2 == 0) {
            return -1;
        }
        int addN = K / 2;
        int[] leftUp = new int[2];
        int[] rightBottom = new int[2];
        if( x - addN >= 0 && y - addN >= 0){
            leftUp[0] = x - addN;
            leftUp[1] = y - addN;
        } else if (x - addN >= 0 && y - addN < 0) {
            leftUp[0] = x - addN;
            leftUp[1] = 0;
        } else if (x - addN < 0 && y - addN >= 0) {
            leftUp[0] = 0;
            leftUp[1] = y - addN;
        } else if (x - addN < 0 && y - addN < 0) {
            leftUp[0] = 0;
            leftUp[1] = 0;
        }

        if( x + addN < image[0].length && y + addN < image.length){
            rightBottom[0] = x + addN;
            rightBottom[1] = y + addN;
        } else if (x + addN >= image[0].length && y + addN < image.length) {
            rightBottom[0] = image.length - 1;
            rightBottom[1] = y + addN;
        } else if (x + addN < image[0].length && y + addN >= image.length) {
            rightBottom[0] = x + addN;
            rightBottom[1] = image.length - 1;
        } else if (x + addN >= image[0].length && y + addN >= image.length ) {
            rightBottom[0] = image.length - 1;
            rightBottom[1] = image.length - 1;
        }

        for (int i = leftUp[1]; i <= rightBottom[1]; i++){
            for (int j = leftUp[0]; j <= rightBottom[0]; j++) {
                result += image[i][j];
            }
        }

        return result / (K * K);
    }

    public static void main(String[] args) {
        int[][] image = {{4, 5, 2, 6, 7},
                        {5, 4, 2, 4, 6},
                        {6, 8, 4, 8, 7},
                        {7, 3, 6, 6, 4},
                        {5, 0, 4, 1, 5}};

        int[][] answer = solution(image, 3);
        for(int[] rows : answer){
            for (int cols : rows) {
                System.out.print(cols + " ");
            }
            System.out.println();
        }
    }
}
