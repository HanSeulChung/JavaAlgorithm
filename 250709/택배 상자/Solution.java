import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n / w + 1;
        int[][] boxes = new int[h][w];
        
        int rowIdx = h - 1;
        int bottomValue = rowIdx % 2;
        int value = 1;
        while (rowIdx >= 0) {
            if (value == n + 1) break;
            
            int colIdx = 0;
            if (rowIdx % 2 == bottomValue) {
                colIdx = 0;
                while (colIdx < w && value <= n) {
                    boxes[rowIdx][colIdx] = value++;
                    colIdx++;
                }
            } else {
                colIdx = w - 1;
                while (colIdx >= 0 && value <= n) {
                    boxes[rowIdx][colIdx] = value++;
                    colIdx--;
                }
            }
            
            rowIdx--;
        }
        
        // print(boxes);
        
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (boxes[row][col] == num) {
                    if (boxes[0][col] == 0) {
                        answer = row;
                    } else {
                        answer = row + 1;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private void print(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
