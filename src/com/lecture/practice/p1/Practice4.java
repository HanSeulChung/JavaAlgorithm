package com.lecture.practice.p1;
// 다양한 별찍기 문제 (5가지 type의 별찍기)
import java.util.Scanner;

public class Practice4 {
    public static void starprint(int N, int T){
        switch(T){
            case 1:
                System.out.println("== Type1 ==");
                for(int i=0; i<N; i++){
                    for(int j =0; j<N; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("== Type2 ==");
                for(int i=0; i<N; i++){
                    for(int j=0; j< i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("== Type3 ==");
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(j < N - i -1){
                            System.out.print(" ");
                        }
                        else{
                            System.out.print("*");
                        }
                    }
                }
                break;

            case 4:
                System.out.println("== Type4 ==");
                for(int i=0; i<N; i++){
                    for(int j =0; j< N-i-1; j++){
                        System.out.print(" ");
                    }
                    for(int j =0; j< i*2 +1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            case 5:
                System.out.println("== Type5 ==");
                // 상단부
                for(int i=0; i<= N/2; i++){
                    for(int j=0; j< N/2 - i; j++){
                        System.out.print(" ");
                    }
                    for(int j =0; j < i *2 +1; j++ ){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                // 하단부
                for(int i=N/2; i>0; i--){
                    for(int j=0; j< N/2 + 1 - i; j++){
                        System.out.print(" ");
                    }
                    for(int j =0; j < i *2 - 1; j++ ){
                        System.out.print("*");
                    }
                }
                break;

        }

    }

    public static void main(String[] args){
        int row = 0;
        int type = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("별 출력 행의 수를 입력해 주세요.: ");
        row = sc.nextInt();
        System.out.print("별 출력 타입을 입력해 주세요.: ");
        type = sc.nextInt();

        starprint(row, type);


    }

}
