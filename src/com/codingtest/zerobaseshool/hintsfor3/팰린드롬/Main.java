package com.codingtest.zerobaseshool.hintsfor3.팰린드롬;
//1254번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer = str.length();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i);
            if(isPalind(s)){
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    public static boolean isPalind(String s){
        int p1 = 0;
        int p2 = s.length() -1 ;
        while(p1<p2){
            if(s.charAt(p1)!=s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}

//public class Main{
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String str = br.readLine();
//        int p1 = 0;
//        int p2 = str.length() -1;
//        int cnt = 0;
//        while(p1<p2){
//            if(str.charAt(p1)==str.charAt(p2)){
//                p1++;
//                p2--;
//                cnt++;
//            } else {
//                p1++;
//            }
//        }
//        System.out.println(p1);
//        System.out.println(p2);
//        if(cnt==str.length()){
//            System.out.println(cnt);
//        } else if (cnt==0 && str.length()%2==0){
//            System.out.println(str.length()*2);
//        } else if (cnt==0 && str.length()%2!=0){
//            System.out.println(str.length()*2 - 1);
//        } else if (cnt<str.length()&& p1!=p2){
//            System.out.println((str.length() - cnt)*2);
//        } else if (cnt<str.length() && p1==p2){
//            System.out.println((str.length() - cnt)*2-(str.length()-p2+1));
//        }
//    }
//}
