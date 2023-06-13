package com.lecture.practice.p1;
// 입력된 정수 자료형의 숫자를 거꾸로 변환하는 프로그램을 작성하세요

public class Practice1 {
    public static void solution(int num){
        int numReverse = 0;
        boolean isMinus = false;
        if(num<0){
            isMinus = true;
            num *= -1;
        }
        while(num>0){
            int r = num%10;
            num /=10;
            numReverse = numReverse*10 +r;

        }
        System.out.println(isMinus ? numReverse*-1: numReverse);
    }
    public static void main(String[] args){
//        String input = "0";
//        int intoutput= 0;
//        String stroutput = "0";
//        System.out.print("숫자를 입력해 주세요: ");
//        Scanner sc = new Scanner(System.in);
//        input = sc.nextLine();

        // 1. String: 메소드 이용
//        if( input.charAt(0)=='-'){
//            StringBuffer str = new StringBuffer(input.substring(1));
//            intoutput -= Integer.parseInt(str.reverse().toString());
//        }
//        else{
//            StringBuffer str = new StringBuffer(input);
//            intoutput += Integer.parseInt(str.reverse().toString());
//        }

        // 2. Stirng : 반복문
//        if(input.charAt(0)=='-'){
//            input = input.substring(1);
//            for(int i=input.length()-1; i>=0; i--){
//                stroutput += input.charAt(i);
//                intoutput = Integer.parseInt(stroutput);
//                intoutput = -intoutput;
//            }
//
//        }
//        else{
//            for(int i=input.length()-1; i>=0; i--){
//                stroutput = stroutput+ input.charAt(i);
//                intoutput = Integer.parseInt(stroutput);
//            }
//        }
//        System.out.printf("%d", intoutput);

        // 3. int : 나누기와 몫으로 자릿수
        solution(-12345);
        solution(100);
        solution(0);
        solution(93423);


    }
}
