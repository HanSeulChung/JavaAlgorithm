/*
    출발지(0, 0) -> 도착지(rowSize - 1, colSize - 1)까지의 전체 경로의 수
    
    [규칙]
    1. 0인 칸은 제한없이 통행 가능
    2. 1인 칸은 통행 금지
    2. 2인 칸은 회전 불가 오직 온 방향에서 직진만 가능
    
    [풀이]
    1) 규칙에 따라 dfs 진행 -> row, col Size가 좀만 커지면 시간초과
    2) dp로 아래쪽, 오른쪽 방향으로 온 경로의 갯수를 count
*/
class Solution {
    static final int MOD = 20170805;
    static int[][][] paths;
    
    public int solution(int m, int n, int[][] cityMap) {
        paths = new int[m][n][2];
        
        // dp 초기화
        paths[0][0][0] = paths[0][0][1] = 1;
        
        for (int row = 1; row < m; row++) {
            if (cityMap[row][0] == 1) break;
            paths[row][0][0] = paths[row - 1][0][0];
        }
        
        for (int col = 1; col < n; col++) {
            if (cityMap[0][col] == 1) break;
            paths[0][col][1] = paths[0][col - 1][1];
        }
        
        // dp 시작
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) { 
                if (cityMap[row][col] == 1) continue;
                
                if (cityMap[row - 1][col] == 2) {
                    paths[row][col][0] = paths[row - 1][col][0] % MOD;
                } else if (cityMap[row - 1][col] == 0){
                    paths[row][col][0] = 
                        (paths[row - 1][col][0] + paths[row - 1][col][1]) % MOD;
                } 
                
                if (cityMap[row][col - 1] == 2) {
                    paths[row][col][1] = paths[row][col - 1][1] % MOD;
                } else if (cityMap[row][col - 1] == 0) {
                    paths[row][col][1] = 
                        (paths[row][col - 1][1] + paths[row][col - 1][0]) % MOD;
                }  
            }
        }
        
        return (paths[m - 1][n - 1][0] + paths[m - 1][n - 1][1]) % MOD;
    }
}
