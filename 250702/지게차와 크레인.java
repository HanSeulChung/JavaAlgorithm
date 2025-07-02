/*
    요청이 알파벳 하나일때 -> 지게차(요청된 것들 중 4면 중 최소 1면이 창고 외부와 연결된 컨테이너만 꺼냄)
    요청이 알파벳 두개 일때 -> 크레인(요청된 모든 컨테이너를 꺼냄)

    외부와 1면이라도 맞닿아 있는 경우
    1) 외곽일때 row == 0, row == rowSize - 1, col == 0; col == colSize - 1 무슨 값이든 외부와 맞닿아있음
    2) 외곽아니고 내부일 때 4방향 중 1개라도 2차원 boolean 배열이 true인 경우 외부와 맞닿아있음
      -> 2차원 boolean 배열을 true만드는 조건, 외곽에서 시작했을때 컨테이너가 없어진 자리까지 들어갈 수 있는 곳/ 
*/

import java.util.*;

class Solution {
    static char[][] board;
    static int rowSize;
    static int colSize;
    
    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] storage, String[] requests) {

        init(storage);
        
        for (String request : requests) {
            if (request.length() > 1) {
                char[] requestChar = request.toCharArray();
                if (requestChar.length > 2 || requestChar[0] != requestChar[1]) return 0; // input error
                crain(requestChar[0]);
            } else {
                gigeCar(request.charAt(0));
            }
        }
        // print(board);
        return calRemainContainer();
    }
    
    private void print(char[][] targetBoard) {
        for (int row = 0; row < rowSize; row++) {
            System.out.println(Arrays.toString(targetBoard[row]));
        }
    }
    
    private void print(boolean[][] targetBoard) {
        for (int row = 0; row < rowSize; row++) {
            System.out.println(Arrays.toString(targetBoard[row]));
        }
    }
    
    
    private int calRemainContainer() {
        int answer = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] != '-') answer++;
            }
        }
        
        return answer;
    }
    
    private void crain(char target) {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == target) board[row][col] = '-';
            }
        }
    }
    
    private void gigeCar(char target) {
        boolean[][] isNextExternal = checkExternal();
        
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == target) {
                    // 1) 외곽에 있으면 제거
                    if (row == 0 || row == rowSize - 1 || col == 0 || col == colSize - 1) {
                        board[row][col] = '-';
                    } else { // 2) 내부라면 외부 공기와 맞닿아있는지 확인 (isNextExternal 으로 확인 해당 2차원 배열에는 내부에서 제거된 위치만 true 표시되어있음)
                        for (int[] direction: DIRECTIONS) {
                            int nextRow = row + direction[0];
                            int nextCol = col + direction[1];
                            if (isInBoard(nextRow, nextCol) && isNextExternal[nextRow][nextCol]) {
                                board[row][col] = '-';
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private boolean[][] checkExternal() {
        boolean[][] checkBoard = new boolean[rowSize][colSize];
        Queue<int[]> q = new ArrayDeque<>();
        // 외곽은 무조건 외부 공기 1개는 맞닿아있기 때문에
        // 외곽의 모든 칸을 외부공기 접촉으로 간주
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (row == 0 || row == rowSize - 1 || col == 0 || col == colSize - 1) {
                    // 외곽이 빈칸이면 BFS 탐색 시작
                    if (board[row][col] == '-') {
                        q.add(new int[]{row, col});
                        checkBoard[row][col] = true;
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] curStatus = q.poll();
            int row = curStatus[0];
            int col = curStatus[1];
            
            for (int[] direciton : DIRECTIONS) {
                int nextRow = row + direciton[0];
                int nextCol = col + direciton[1];
                
                if (!isInBoard(nextRow, nextCol) || checkBoard[nextRow][nextCol] ) continue;
                if (board[nextRow][nextCol] != '-') continue;
                
                checkBoard[nextRow][nextCol] = true;
                q.add(new int[]{nextRow, nextCol});
            }
        }
        
        // System.out.println("======");
        // print(checkBoard);
        // System.out.println("======");
        return checkBoard;
    }
    
    private boolean isInBoard(int row, int col) {
        return row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }
    
    private void init(String[] storage) {
        rowSize = storage.length;
        colSize = storage[0].length();
        
        board = new char[rowSize][colSize];
        
        for (int row = 0; row < rowSize; row++) {
            String storageRow = storage[row];
            for (int col = 0; col < colSize; col++) {
                board[row][col] = storageRow.charAt(col);
            }
        }
        
    }
}
