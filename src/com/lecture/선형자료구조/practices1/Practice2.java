package com.lecture.선형자료구조.practices1;

public class Practice2 {

    public static void solution(int[][] matrix) {
        boolean frZero = false; // 첫째 row에 0이 있는지
        boolean fcZero = false; // 첫째 col에 0이 있는지

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if (i == 0){
                        frZero = true;
                    }

                    if (j == 0){
                        fcZero = true;
                    }
                    matrix[i][0] = 0; // 최외각쪽을 0으로 변경
                    matrix[0][j] = 0; // 최외각쪽을 0으로 변경
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (frZero) {
            for (int i = 0; i <matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if (fcZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
