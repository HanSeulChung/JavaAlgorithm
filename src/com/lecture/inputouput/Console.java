package com.lecture.inputouput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Java 프로그래밍 - 콘솔 입출력
public class Console {
    public static void referInputSteram() throws IOException {
        // 1.System.in
        System.out.println("== System in ==");
        System.out.print("입력: ");
        int a = System.in.read()-'0'; // 하나의 값만 읽어올수있음
        System.out.println("a = " + a);
        System.in.read(new byte[System.in.available()]);

        // 2.InputStreamReader
        System.out.println("== InputStreamReader ==");
        InputStreamReader reader = new InputStreamReader(System.in);
        char[] c = new char[3];
        System.out.print("입력: ");
        reader.read(c);
        System.out.println(c);

        // 3.BufferedReader
        System.out.println("== BufferedReader ==");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("입력: ");
        String s1 = br.readLine();
        System.out.println("s1 = " + s1);

    }

    public static void main(String[] args) throws IOException{
        //1. 입력
        //1-1. 다른 입력 방식 참고
        //referInputSteram();

        //1-2. Scanner
        System.out.println("== Scanner ==");
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 입력: ");
        int a = sc.nextInt();
        System.out.println("a = " + a);

        System.out.print("문자 입력: ");
        String b = sc.next(); // 띄어쓰기 이후 저장 안함
        sc.nextLine();// 아까와 같이 엔터키 소진하기 위함
        System.out.println("b = " + b);
        
        System.out.print("문장 입력: ");
        String c = sc.nextLine();
        System.out.println("c = " + c);

        //참고) 정수, 문자열 변환
        int num = Integer.parseInt("12345");
        String str = Integer.toString(12345);

        //2. 출력
        System.out.println("== 출력 ==");
        System.out.println("Hello");
        System.out.println("World!");

        System.out.print("Hello");
        System.out.print("World!");

        String s = "자바";
        int number = 3;

        System.out.println(s+ "는 언어 선호도"+ number+"입니다");
        System.out.printf("%s는 언어 선호도 %d입니다", s, number);

        System.out.printf("%d\n", 10); //10진수
        System.out.printf("%o\n", 10); //8진수
        System.out.printf("%x\n", 10); //16진수
        System.out.printf("%c\n", 'A');
        System.out.printf("%s\n", "안녕하세요");
        System.out.println();
    }
}
