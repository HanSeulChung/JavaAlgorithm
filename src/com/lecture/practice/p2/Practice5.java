package com.lecture.practice.p2;

public class Practice5 {
    public static void solution(int[] ratings){
        if(ratings==null | ratings.length==0){
            return;
        }
        int sum =1;
        int upCnt = 1;
        int downCnt = 0;
        int peak =0;
        for(int i =1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                upCnt++;
                peak =upCnt;
                downCnt =0;
                sum += upCnt;
            } else if( ratings[i]==ratings[i-1]){
                upCnt =1;
                downCnt=0;
                peak = 0;
                sum+=1;
            } else{
                downCnt++;
                upCnt =1;
                sum += downCnt;

                if(peak <= downCnt){
                    sum +=1;
                }
            }

        }
        System.out.println(sum);
    }

 /*   // 각 사탕받은 배열을 구하려고 했음.. 이것도 나중에 풀자 !
    public static void solution1(int[] ratings){
        int sum =0;
        int candy = 1;
        boolean direction = true;
        boolean downcheck = false;
        int[] candysArr = new int[ratings.length];
        int i = 0;
        while(i <ratings.length-1){
            if(ratings[i]<ratings[i+1]&&direction&&!downcheck){
                candysArr[i] = candy++;
            } else if( ratings[i]>ratings[i+1]&&direction&&!downcheck){
                candysArr[i]=candy;
                candy =1;
                downcheck =true;
            } else if(ratings[i]>ratings[i+1])
        }

        for(int i =0; i<ratings.length; i++){
            if(ratings[i]<ratings[i+1]&&direction&& !downcheck){
                candysArr[i] = candy++;
            } else if(ratings[i]>ratings[i+1]&&direction&&!downcheck){
                candy =1 ;
                candysArr[i]= candy;
                downcheck = true;
            } else if(ratings[i]>ratings[i+1]&&direction && downcheck){
                i--;
                candysArr[i] +=1;
                downcheck=false;
                i=i+2;
            }
        }
        System.out.println((candysArr));
    }*/

    public static void main(String[] args){
        int[] ratings = {1, 2, 3};
        solution(ratings);
        ratings = new int[]{3, 2, 1};
        solution(ratings);
        ratings = new int[]{1, 0, 2};
        solution(ratings);
        ratings = new int[]{1, 2, 2};
        solution(ratings);
        ratings = new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1,0};
        solution(ratings);
    }
}
