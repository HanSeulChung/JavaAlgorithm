package com.codingtest.zerobaseschool.hintsfor2.구현;
// 계산기 프로그램
// +, -, *, /, =
import java.util.Scanner;

public class BJ5613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        String str = "";
        answer = sc.nextInt();
        while (true) {
            str = sc.nextLine();
            if (str.equals("=")) {
                break;
            }
            switch (str) {
                case "+":
                    answer += sc.nextInt();
                    break;
                case "-":
                    answer -= sc.nextInt();
                    break;
                case "/":
                    answer /= sc.nextInt();
                    break;
                case "*":
                    answer *= sc.nextInt();
                    break;
            }
        }
        System.out.println(answer);
    }

//    public static void main(String[] args)throws IOException  {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int answer = 0;
//        String str = "";
//
//        answer = reader.read();
//        while(true){
//            str = reader.readLine();
//            if(str.equals("=")){
//                break;
//            }
//            switch (str){
//                case "+":
//                    answer += reader.read();
//                    break;
//                case "-":
//                    answer-= reader.read();
//                    break;
//                case "/":
//                    answer/= reader.read();
//                    break;
//                case "*":
//                    answer*= reader.read();
//                    break;
//
//            }
//        }
//        System.out.println(answer);
//    }
}
