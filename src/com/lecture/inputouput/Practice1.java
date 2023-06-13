package com.lecture.inputouput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean inputContinue = true;
        int count =0, sum =0;

        do{
            try{
                System.out.print("Enter an integer: ");
                int number = sc.nextInt();
                System.out.println("the number entered is "+ number);
                count++;
            }catch(InputMismatchException e){
                System.out.println("Try again.("+
                        "Incorrect input: an integer is required)");
                inputContinue=false;
                sc.nextLine();
            }

        }while(count <10 && inputContinue);

        if(count==10){
            System.out.println("sum is :"+ sum + " Average is "+ sum/10);
        }


        //좋지 않은 코드..
//        int[] numbers = new int[10];
//        int sum= 0;
//        int avg = 0;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("숫자 10개를 입력하세요.");
//        System.out.print("첫번째 숫자: ");
//        numbers[0] = sc.nextInt();
//        System.out.print("두번째 숫자: ");
//        numbers[1] = sc.nextInt();
//        System.out.print("세번째 숫자: ");
//        numbers[2] = sc.nextInt();
//        System.out.print("네번째 숫자: ");
//        numbers[3] = sc.nextInt();
//        System.out.print("다섯번째 숫자: ");
//        numbers[4] = sc.nextInt();
//        System.out.print("여섯번째 숫자: ");
//        numbers[5] = sc.nextInt();
//        System.out.print("일곱번째 숫자: ");
//        numbers[6] = sc.nextInt();
//        System.out.print("여덟번째 숫자: ");
//        numbers[7] = sc.nextInt();
//        System.out.print("아홉번째 숫자: ");
//        numbers[8] = sc.nextInt();
//        System.out.print("열번째 숫자: ");
//        numbers[9] = sc.nextInt();
//        for(int num:numbers){
//            sum+=num;
//        }
//        avg = sum / 10;
//
//
//        System.out.println(avg);
    }
}
