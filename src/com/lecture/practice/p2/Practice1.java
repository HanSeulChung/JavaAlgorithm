package com.lecture.practice.p2;
// 로마 숫자를 정수형 숫자로 변환

import java.util.HashMap;

public class Practice1 {
    public static void solution(String s){
        // 나의 풀이
//        HashMap<String, Integer> romeNumber = new HashMap<>();
//        romeNumber.put("I",1);
//        romeNumber.put("V",5);
//        romeNumber.put("X",10);
//        romeNumber.put("L",50);
//        romeNumber.put("C",100);
//        romeNumber.put("D",500);
//        romeNumber.put("M",1000);
//
//        int value = 0;
//        for(int i=0; i< s.length(); i++){
//            if(i==s.length()-1){
//                String base = s.substring(i);
//                int baasevalue = romeNumber.get(base);
//                value += baasevalue;
//            }
//            else{
//                String base = s.substring(i,i+1);
//                String next = s.substring(i+1, i+2);
//                int basevalue = romeNumber.get(base);
//                int nextvalue = romeNumber.get(next);
//                if( basevalue>=nextvalue){
//                    value += romeNumber.get(base);
//                }
//                else {
//                    value -= romeNumber.get(base);
//                }
//            }
//        }
//        System.out.println(value);

        // 강의 풀이
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum =0;
        char[] charArray = s.toCharArray();
        for(int i =0; i<charArray.length-1; i++){
            if(map.get(charArray[i])<map.get(charArray[i+1])){
                sum -= map.get(charArray[i]);
            }
            else{
                sum += map.get(charArray[i]);
            }
        }
        sum +=  map.get(charArray[charArray.length-1]);
        System.out.println(sum);
    }
    public static void main(String[] args){

        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}
