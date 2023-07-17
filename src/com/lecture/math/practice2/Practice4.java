package com.lecture.math.practice2;


public class Practice4 {
    final static int mod = (int) 1e9 + 7;
    static final int Mod = 0;


    public static int solution(long n) {
       //final int MOD = 1_000_000_007;
        return (int) (recursion(5, (n + 1)/2) * recursion(4, n / 2) % mod);
    }

    public static long recursion(long x, long y){
        if (y == 0){
            return 1;
        }

        long p = recursion(x, y / 2);
        return p * p * (y % 2 > 0 ? x : 1) % mod;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(50));
    }
}
