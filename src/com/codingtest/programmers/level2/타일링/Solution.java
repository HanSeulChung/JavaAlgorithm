package com.codingtest.programmers.level2.타일링;

public class Solution {

    /**
     * 3 x n 타일링
     */
//    static final int MOD = 1_000_000_007;
    // static은 정적변수, 다른 클래스와 같이 쓸때 쓰자
    // static을 쓰면 heap 영역이 아닌 stack 영역에 들어가게 되어서 GC로 메모리를 지울수가 없다.
    // 남발하지 말자.
    final int MOD = 1_000_000_007;
        // final은? 불변성, 상수, 오버라이딩 불가, 상속 불가
    // 변수 : 상수 , 메서드 : 오버라이딩 불가, 클래스 : 상속 불가
    public int solution3xn(int n) {

        if (n % 2 != 0) {
            return 0;
        }

        int N = n / 2;

        long[] dp = new long[N + 1];
        long[] sum = new long[N];
        dp[1] = 3; // 초기값 설정
        sum[0] = 2;

        for (int i = 2; i <= N; i++) {
            // f(n) = f(n-1) * 3 + Σ(k=1 to n-2) f(k) * 2
            dp[i] = (dp[i - 1] * 3 + sum[i - 2]) % MOD;

            sum[i - 1] = (dp[i - 1] * 2 + sum[i - 2]) % MOD;

        }
        return (int)dp[N] % MOD;
    }


    /**
     * 2 x n 타일링
     */
//    static int MOD = 1_000_000_007;
    public int solution2x1(int n) {
        int[] dp = new int[n  + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 2; i < n; i++) {
            dp[i + 1] = (dp[i] + dp[i - 1]) % MOD;
        }

        return dp[n];
    }

        // 틀린 답

    public int solution1(int n) {
        int N = n / 2;
        long[] evenDp = new long[N + 1]; // long으로 둬야함.. int로 두면 틀림
        evenDp[1] = 3;
        long beforedps = 0;

        for (int i = 2; i <= N; i++) {
            evenDp[i] = (3 * evenDp[i - 1] + 2 * (beforedps + 1)) % MOD;
            beforedps = (beforedps + evenDp[i - 1]) % MOD;
        }

        return (int) evenDp[N] % MOD;
    }

    // 다른 사람이 푼 답
    public int solution2(int n) {
        long adder = 0;

        long[] arr = new long [n + 1]; // 최대 5000의 값을 넣는다고 했으니 5000 + 1 = 5001으로 둬도 된다.
        arr[0] = 0;
        arr[2] = 3;
        for(int i = 4; i <= n; i = i+2) {
            arr[i] = (3*arr[i-2] + 2*(adder+1))%MOD;
            adder = (adder + arr[i-2])%MOD;
        }
        return (int) arr[n]%MOD;
    }


}
