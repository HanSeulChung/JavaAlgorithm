package com.codingtest.programmers.level1.바탕화면정리;
/**
* @package : com.codingtest.programmers.level1.바탕화면정리
* @name : Solution.java
* @date : 2023-06-19 오전 9:05
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
public class Solution {
    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int miny = 53; // Integer.MIN_VALUE도 기억하기
        int minx = 53;
        int maxy = 0; // Integer.MAX_VALUE
        int maxx = 0;

        for(int i =0; i<wallpaper.length; i++){
            for(int j =0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#'){
                    miny = Math.min(miny, i);
                    minx = Math.min(minx, j);
                    maxy = Math.max(maxy, i);
                    maxx = Math.max(maxx, j);
                }
            }
        }
        answer[0] = miny;
        answer[1] = minx;
        answer[2] = maxy + 1;
        answer[3] = maxx + 1;
        return answer;
    }
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(solution(wallpaper));

        wallpaper = new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(solution(wallpaper));

        wallpaper = new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        System.out.println(solution(wallpaper));
    }

    /* 틀린 solution
    *     public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int miny = 51;
        int minx = 51;
        int maxy = 0;
        int maxx = 0;

        int cnt = 0;

        for(int i =0; i<wallpaper.length; i++){
            for(int j =0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#'){
                    cnt+=1;
                    if(miny > i || minx > j){
                        if(miny > i && minx > j){
                            miny = i;
                            minx = j;
                        } else if(miny > i && minx <j){
                            miny = i;
                        } else if(miny <i && minx > j){
                            minx = j;
                        }
                    }
                    else if(maxy < i || maxx < j){
                        if(maxy< i && maxx <j){
                            maxy = i;
                            maxx = j;
                        } else if(maxy < i && maxx >j){
                            maxy = i;
                        } else if(maxy > i && maxx < j){
                            maxx = j;
                        }
                    }
                }
            }
        }
        System.out.println("#개수: "+ cnt);
        if(cnt == 1){
            answer[0] = miny;
            answer[1] = minx;
            answer[2] = miny + 1;
            answer[3] = minx + 1;
        }else{
            answer[0] = miny;
            answer[1] = minx;
            answer[2] = maxy + 1;
            answer[3] = maxx + 1;
        }
        return answer;
    }
    * */
}
