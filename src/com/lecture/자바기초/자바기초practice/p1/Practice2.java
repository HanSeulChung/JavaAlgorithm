package com.lecture.자바기초.자바기초practice.p1;

// 아스키 코드 중 사용자가 입력한 알파벳이 대소문자를 변경하는 프로그램을 작성하시오
// 소문자 알파벳 : 97 ~ 122 (26개)
// 대문자 알파벳 : 65 ~ 90 (26개)
import java.util.Scanner;

public class Practice2 {
    public static void solution(char alpabet){
        int ascii = 0;
        ascii = (int)alpabet;
        if(ascii>=97 && ascii<=122){
            ascii -=32;
            System.out.println((char)ascii);
        }
        else if(ascii>=65 && ascii<=90){
            ascii +=32;
            System.out.println((char)ascii);
        }
        else{
            System.out.println("알파벳이 아닙니다.");
        }
    }
    public static void main(String[] args){
//        solution('a');
//        solution('b');
//        solution('c');
//        solution('d');
//        solution('e');
//        solution('f');
//        solution('A');
//        solution('B');
//        solution('C');
//        solution('D');
//        solution('E');
//        solution('F');
        char alpabet ='0';
        System.out.print("알파벳을 입력해 주세요.: ");
        Scanner sc = new Scanner(System.in);
        alpabet = sc.next().charAt(0);

        solution(alpabet);
    }
}
