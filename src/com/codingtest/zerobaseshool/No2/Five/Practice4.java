package com.codingtest.zerobaseshool.No2.Five;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Practice4 {

    public static long longtotalN = 0;
    public static long longmultiN = 1;
    public static int solution(int n) {
        while(n>1){
            // 9223372036854775807L
            longmultiN *=2;
            longmultiN %= 1000000007;
            longtotalN += longmultiN;
            longtotalN %= 1000000007;

            n--;
        }
        return (int)longtotalN+1;

        // BigDecimal bigNum = new BigDecimal("1");
        // BigDecimal addNum = new BigDecimal("1");

        // while(n>1){
        //     bigNum = bigNum.multiply(new BigDecimal(2));
        //     addNum = addNum.add(bigNum);
        //     addNum = addNum.remainder(new BigDecimal(1000000007));
        //     n--;
        // } // -> 테스트 4 시간초과
        // return addNum.intValue();

        // long longanswer = 0;
        // for (int i = 0; i < n; i++) {
        //     if((long)Math.pow(2,i)>9223372036854775807L){

        //     }
        //     longanswer +=((long)Math.pow(2,i));
        //     longanswer %= 1000000007;
        // }
        // return (int)longanswer;  //-> 테스트 3, 4 실패
    }
    public static void main(String[] args) {
//        System.out.println(solution(100000));
//        System.out.println(solution(1));
//        System.out.println(solution(5));
//        System.out.println(solution(6));
//        System.out.println(solution(500));
//        System.out.println(solution(1));

//        System.out.println((long)Math.pow(2,1000000));
//        System.out.println((long)Math.pow(2,999999));
//        System.out.println(new BigDecimal((long)Math.pow(2,99999)));
        System.out.println();

//        BigDecimal bigNum = new BigDecimal("1");
//        BigDecimal addNum = new BigDecimal("1");
//        int n =1000000;
//        while(n>1){
//            bigNum = bigNum.multiply(new BigDecimal(2));
//            addNum = addNum.add(bigNum);
//            addNum = addNum.remainder(new BigDecimal(1000000007));
//            n--;
//        }
//        System.out.println(addNum);
        //9,223,372,036,854,775,807
        long testlong = 9223372036854775807L;
        System.out.println(testlong%1000000007);
    }
}
