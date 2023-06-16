package com.lecture.자바기초.자바기초practice.p2;
// 정수형 숫자를 로마형 숫자로 변환
// 와 이건 진짜 대박이다!

public class Practice2 {
    public static void solution(int number ){
        String result ="";
        String[] rome ={"M", "CM", "D","CD","C","XC", "L", "XL","X", "IX","V","IV","I"};
        int[] intnum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i =0;
        while(number>0){
            while(number >= intnum[i]){
                result += rome[i];
                number -= intnum[i];
            }
            i++;
        }
        System.out.println(result);
    }

    public static  void main(String[] args){
        solution(3);
        solution(4);
        solution(6);
        solution(13);
        solution(26);
        solution(1994);
    }
}
