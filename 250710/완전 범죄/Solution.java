
/*
    A도둑은 n이상 흔적을 남기면 경찰에 붙잡히고,
    B도둑은 m이상 흔적을 남기면 경찰에 붙잡힌다.
    
    물건 i번째를 훔칠때 A도둑이 훔치면 info[i][0]만큼의 A 흔적을,
                    
                    B도둑이 훔치면 info[i][1]만큼의 B 흔적을 남기게 된다.

    [출력]
    A 도둑이 남긴 흔적의 누적 개수의 최솟값
    
    [방법]
    1. 2차원 dp 배열을 만든다. dp[물건의 총 개수][A가 남길 수 있는 누적 흔적]
    2. dp배열의 모든 값을 MAX 값으로 초기화 설정한다.
    3. 초기 셋팅은 첫번째 물건을 A가 훔쳤을 때, 안훔쳤을 때(B가 훔쳤을 때)의 값을 갱신한다.
        3-0. 갱신 식: dp[훔칠 물건의 idx][A가 남긴 누적된 흔적] = B가 남긴 누적된 흔적
        3-1. info[0][0] < n 이여야 A가 훔칠 수 있고,
                info[0][1] < m 이여야 B가 훔칠 수 있다.
        3-2. dp[0][info[0][0]] = 0, dp[0][0] = info[0][1];
    4. dp 갱신은 모든 물건을 A의 가능한 누적 흔적별로 훑는다.
        4-1. 현재 idx의 물건을 A가 훔쳤을 경우 
            4-1-1.a가 현재 idx의 물건을 훔쳐 새롭게 누적되는 흔적 : newATrace
                    기존 A의 누적 흔적 값: aTrace
                newATrace = aTrace + info[idx][0]
            4-1-2. newATrace < n이여야 A가 훔칠 수 있다.
                dp[idx][newATrace] = 
                    Math.min(dp[idx - 1][newATrace], dp[idx - 1][aTrace])
        4-2. 현재 idx의 물건을 B가 훔쳤을 경우
            4-2-1. dp[idx - 1][aTrace] + info[idx][1] < m이여야 B가 훔칠 수 있다.
                dp[idx][aTrace] = dp[idx - 1][aTrace] + info[idx][1]
*/
class Solution {
    static final int MAX = 1_000_000_000;
    
    public int solution(int[][] info, int n, int m) {
        int thingsCount = info.length;
        int[][] canBTraces = new int[thingsCount][n];
        
        for (int idx = 0; idx < thingsCount; idx++) {
            for (int canATrace = 0; canATrace < n; canATrace++) {
                canBTraces[idx][canATrace] = MAX;
            }
        }
        
        if (info[0][0] < n) canBTraces[0][info[0][0]] = 0;
        if (info[0][1] < m) canBTraces[0][0] = info[0][1];
        
        for (int idx = 1; idx < thingsCount; idx++) {
            for (int aTrace = 0; aTrace < n; aTrace++) {
                if (canBTraces[idx - 1][aTrace] == MAX) continue;
                
                // A가 훔치는 경우
                int newATrace = aTrace + info[idx][0];
                if (newATrace < n) {
                    canBTraces[idx][newATrace] = 
                        Math.min(canBTraces[idx - 1][aTrace], canBTraces[idx][newATrace]);
                }
                
                // A가 훔치지 않는 경우 = B가 훔치는 경우
                if (canBTraces[idx - 1][aTrace] + info[idx][1] < m) {
                    canBTraces[idx][aTrace] = 
                        Math.min(canBTraces[idx - 1][aTrace] + info[idx][1], canBTraces[idx][aTrace]);
                }
            }
        }
        
        int answer = MAX;
        for (int aTrace = 0; aTrace < n; aTrace++) {
            if (canBTraces[thingsCount - 1][aTrace] < m && answer > aTrace) {
                answer = aTrace;
                break;
            }
        }
        
        return answer == MAX ? -1 : answer;
    }
}
