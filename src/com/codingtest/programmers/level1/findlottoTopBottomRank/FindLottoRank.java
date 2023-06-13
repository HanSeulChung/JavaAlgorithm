package com.codingtest.programmers.level1.findlottoTopBottomRank;
/*
*
* 정한슬
문제 url:
https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=java
gist url:
https://gist.github.com/HanSeulChung/22684e3148898639f68cc1c1c9644d75
*/

// ArrayList로도 풀어보기!!!!!!!!!

public class FindLottoRank {
    public static int checkRank(int correctCnt){
        int rank = 0;
        switch(correctCnt){
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
                break;
        }
        return rank;
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int topRank = 0, bottomRank = 0;
        int zeroCnt = 0;
        int initcorrectCnt = 0;

        // lottos(내 로또)에서 지워진 값(0으로 표기)의 개수 세기
        for(int number : lottos){
            if(number==0){
                zeroCnt++;
            }
        }
        // 두 배열 같은 값 개수
        for(int first:lottos){
            for(int second:win_nums){
                if(first==second){
                    initcorrectCnt++;
                }
            }
        }
        if(zeroCnt!=0){
            System.out.println("zeroCnt is "+zeroCnt);
            int correctCnt =  zeroCnt+initcorrectCnt;
            topRank = checkRank(correctCnt);
            bottomRank = checkRank(initcorrectCnt);
        } else{
            topRank = checkRank(initcorrectCnt);
            bottomRank = topRank;
        }
        answer[0] = topRank;
        answer[1] = bottomRank;
        return answer;
    }
    public static void main(String[] args){
        //
    }
}


