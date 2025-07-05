
/*
    열쇠만 회전 가능하다고 할때, 
    1) 열쇠 회전 4번 가능
    2) 열쇠를 이동 시킬 수 있음
    
    [해당 열쇠로 lock을 풀수 있는 지 확인하는 방법]
    1. lock 2차원 배열에 위/아래, 좌/우 key 길이만큼 padding으로 채워 놓는다.
    2. 해당 padding된 2차원 배열을 기준으로
        key가 회전 0, 1, 2, 3일 때 window sliding을 진행한다.
        2-1. padding 채우지 않은 가운데 lock 부분이 모두 1로 채워져있는지 확인한다.
        2-2. 1이 아닌 2거나 0일땐 lock부분의 돌기와 key부분의 돌기가 부딪히거나 채워지지 않은것이므로 false
        2-3. 모두 1이면 열쇠가 자물쇠에 딱 맞는 것 -> 로직 종료 후 true 반환 

    // 잘못된 생각
    1. lock의 빈칸(0)의 위치(pos)를 List에 담아 놓는다.
    2. key의 회전 0, 1, 2, 3인것과 비교한다
        2-1. 회전했을때의 key의 1 값 위치를 담는다.
        2-2. lock의 빈칸의 위치와 해당 key의 1값의 위치를 각각 x,y 값을 비교한다.
        2-3. 같은 차이(ex> x값 방향에서 1차이 등)가 난다면 이동했을 때 lock을 풀수있다는 의미
        2-4. 같은 차이가 나지 않는다면 lock을 풀수없다는 의미 다음 회전에서 확인해야함.
*/
class Solution {
    static int[][] key;
    static int[][] lock;
    static int[][] board;
    
    static int keySize;
    static int lockSize;
    
    static boolean answer;
    
    public boolean solution(int[][] key, int[][] lock) {
        answer = false;
        this.key = key;
        this.lock = lock;
        
        keySize = key.length;
        lockSize = lock.length;
        
        matchKey();
        
        return answer;
    }
    
    private void matchKey() {
        int boardSize = lockSize + 2 * keySize;
        board = new int[boardSize][boardSize];
        
        // padding된 배열 가운데에 lock 배열 삽입
        for (int y = 0; y < lockSize; y++) {
            for (int x = 0; x < lockSize; x++) {
                board[keySize - 1 + y][keySize - 1 + x] = lock[y][x];
            }
        }
        
        // key값을 90도씩 회전 시키면서 sliding window 방식으로 검사한다.
        for (int rotateIdx = 0; rotateIdx < 4; rotateIdx++) {
            key = rotateKey();
          
            checkKeyAndLock();
            
            if (answer) break;
        }
    }
    
    private void checkKeyAndLock() {
        for (int yShift = 0; yShift < lockSize + keySize; yShift++) {
            for (int xShift = 0; xShift < lockSize + keySize; xShift++) {
                for (int y = 0; y < keySize; y++) {
                    for (int x = 0; x < keySize; x++) {
                        board[yShift + y][xShift + x] += key[y][x];
                    }
                }
              // 딱 맞는지 확인 
                if (isFit(board)) {
                    answer = true;
                    return;
                }
              // 맞지 않으면 다시 채웠던 것 빼기
                for (int y = 0; y < keySize; y++) {
                    for (int x = 0; x < keySize; x++) {
                        board[yShift + y][xShift + x] -= key[y][x];
                    }
                }
            }
        }
    }
    
    private boolean isFit(int[][] board) {
        for (int y = 0; y < lockSize; y++) {
            for (int x = 0; x < lockSize; x++) {
                if (board[keySize - 1 + y][keySize - 1 + x] != 1) return false;
            }
        }
        
        return true;
    }
    
    private int[][] rotateKey() { // 시계방향으로 rotate
        int[][] rotate = new int[keySize][keySize];
        
        for (int y = 0; y < keySize; y++) {
            for (int x = 0; x < keySize; x++) {
                rotate[x][keySize - 1 - y] = key[y][x];
            }
        }
        
        return rotate;
    }
}
