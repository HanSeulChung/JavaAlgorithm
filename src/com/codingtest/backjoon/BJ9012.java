package com.codingtest.backjoon;

/**
* @package : com.codingtest.backjoon
* @name : BJ9012.java
* @date : 2023-06-19 오후 6:13
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
import java.util.Scanner;
import java.util.Stack;
public class BJ9012 {
    /*
    *   public static String checkYN(String s){
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(stack.empty()){
                return "NO";
            }else {
                stack.pop();
            }
        }

        if(stack.empty()){
            return "YES";
        }else{
            return "NO";
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i =0; i< N; i++){
            System.out.println(checkYN(sc.next()));
        }
        */
    public static String checkYN(String s){
        String answer = "";
        Stack stack = new Stack();

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c==')' && !stack.isEmpty()){
                answer ="NO";
                break;
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            answer="YES";
        }else{
            answer="NO";
            }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String s = "";
        for(int i =0; i< N; i++){
            System.out.println(checkYN(sc.next()));
        }


    }
}
