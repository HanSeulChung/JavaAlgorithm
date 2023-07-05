package com.codingtest.zerobaseshool.No3.Four;

public class Practice1 {

//    public static void goDistance(int n, int k, int answer, int distance, int v){
//        if(distance == n){
//            answer++;
//            answer%=1000000007;
//            return;
//        }
//
//        for(int i =1; i<=k; i++){
//            if(v==i){
//                continue;
//            }
//            distance +=i;
//            goDistance(n, k, answer, distance, i);
//        }
//    }
//    public static int solution(int n, int k) {
//        int answer = 0;
//        goDistance(n, k, answer, 0, 0);
//        return answer;
//    }
    public static int[] choose = new int[1];

    public static int permutation(int n, int k, int total, int cnt){
        if(total == n){
            cnt++;
            return cnt;
        }
        for(int i =1; i<=k; i++){
            if(choose[0] == i){
                choose[0] = 0;
                continue;
            }
            if(total + i >n){
                continue;
            }
            choose[0] = i;
            permutation(n, k, total + i, cnt);
        }
        return cnt;
    }

    public static int solution(int n, int k) {
        long answer = 0;
        int cnt =0;
        answer += (long)permutation(n, k, 0, cnt);

        return (int)answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(5, 3));
    }
}
