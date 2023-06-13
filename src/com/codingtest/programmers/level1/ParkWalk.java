package com.codingtest.programmers.level1;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParkWalk {

    public static int[] solution1(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;

        char[][] arr = new char[park.length][park[0].length()];

        for(int i = 0; i < park.length; i++){
            arr[i] = park[i].toCharArray();

            if(park[i].contains("S")){
//                sy = i;
//                sx = park[i].indexOf("S");
                sx = i;
                sy = park[i].indexOf("S");
            }
        }

        for(String st : routes){
            String way = st.split(" ")[0];
            int len = Integer.parseInt(st.split(" ")[1]);

            int nx = sx;
            int ny = sy;

            for(int i = 0; i < len; i++){
                if(way.equals("E")){
                    nx++;
                }
                if(way.equals("W")){
                    nx--;
                }
                if(way.equals("S")){
                    ny++;
                }
                if(way.equals("N")){
                    ny--;
                }
                if(nx >=0 && ny >=0 && ny < arr.length && nx < arr[0].length){
                    if(arr[ny][nx] == 'X'){
                        break;
                    }
                    // 범위내 & 장애물 x
                    if(i == len-1){
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }

        int[] answer = {sy, sx};
        return answer;
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(String str:routes){
            map.put(str.split(" ")[0],Integer.parseInt(str.split(" ")[1]));
        }

        String[][] parkArr = new String[park.length][park[0].length()];
        for(int i=0; i< park.length; i++){
            parkArr[i] = park[i].split("");
        }

        for(int i =0; i< park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                if(parkArr[i][j].equals("S")){
                    checkRoute(i,j, parkArr, map,answer);
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void checkRoute(int rowIdx, int colIdx, String[][] parkArr, HashMap<String, Integer> map, int[] answer){
        // N, S, E, W
        int[] dH = {1, -1, 0, 0};
        int[] dW = {0, 0, 1, -1};
        // 출력 (세로방향, 가로방향 좌표) = 즉 (rowIdx, colIdx)
        // 세로방향 = height, row 인덱스 | 세로 길이 row행 갯수
        // 가로방향 = width, col 인덱스  | 가로 길이 col행 갯수
        int widthRoute =0;
        int heightRoute =0;

        for(String direction: map.keySet()){
            switch(direction){
                case "N":{
                    if(rowIdx + map.get("N")*dH[0]<0 | rowIdx + map.get("N")*dH[0]> parkArr.length){
                        break;
                    }
                    else{
                        heightRoute = rowIdx + map.get("N")*dH[0];
                        if( parkArr[heightRoute][widthRoute].equals("X") ){
                            heightRoute = rowIdx;
                        }
                        else{
                            rowIdx = heightRoute;
                        }
                    }
                    break;
                }
                case "S":{
                    if(rowIdx + map.get("S")*dH[1]<0 | rowIdx + map.get("S")*dH[1]> parkArr.length){
                        break;
                    }
                    else{
                        heightRoute = rowIdx + map.get("S")*dH[1];
                        if( parkArr[heightRoute][widthRoute].equals("X") ){
                            heightRoute = rowIdx;
                        }
                        else{
                            rowIdx = heightRoute;
                        }
                    }
                    break;
                }
                case "E":{
                    if( colIdx + map.get("E")*dW[2]<0 |  colIdx + map.get("E")*dW[2]> parkArr[0].length){
                        break;
                    }
                    else{
                        widthRoute = colIdx + map.get("E")*dW[2];
                        if( parkArr[heightRoute][widthRoute].equals("X") ){
                            widthRoute = colIdx;
                        }
                        else{
                            colIdx =widthRoute;
                        }
                    }
                    break;
                }
                case "W":{
                    if(colIdx + map.get("W")*dW[3]<0 | colIdx + map.get("W")*dW[3]>parkArr[0].length){
                        break;
                    }
                    else{
                        widthRoute = colIdx + map.get("W")*dW[3];
                        if( parkArr[heightRoute][widthRoute].equals("X") ){
                            widthRoute = colIdx;
                        }
                        else{
                            colIdx = widthRoute;
                        }
                    }
                    break;
                }
            }
        }
        answer[0] = rowIdx;
        answer[1] = colIdx;
    }
    public static void main(String[] args){

        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};
        int[] answer = new int[2];
        answer = solution(park, routes);


        park = new String[] {"SOO","OXX","OOO"};
        routes = new String[] {"E 2","S 2","W 1"};
        answer = solution(park, routes);


        park = new String[] {"OSO","OOO","OXO","OOO"};
        routes = new String[] {"E 2","S 3","W 1"};
        answer = solution(park, routes);

    }
}
/**
 *
 Programmers ~!~1
 *
 */

//import java.util.*;
//
//class Solution {
//    public static int[] solution(String[] park, String[] routes) {
//        int[] answer = new int[2];
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//        for(String str:routes){
//            map.put(str.split(" ")[0],Integer.parseInt(str.split(" ")[1]));
//        }
//
//        String[][] parkArr = new String[park.length][park[0].length()];
//        for(int i=0; i< park.length; i++){
//            parkArr[i] = park[i].split("");
//        }
//
//        for(int i =0; i< park.length; i++){
//            for(int j=0; j<park[0].length(); j++){
//                if(parkArr[i][j].equals("S")){
//                    checkRoute(i,j, parkArr, map,answer);
//                    break;
//                }
//            }
//        }
//        System.out.println(answer);
//        return answer;
//    }
//
//    public static void checkRoute(int rowIdx, int colIdx, String[][] parkArr, HashMap<String, Integer> map, int[] answer){
//        // N, S, E, W
//        int[] dH = {1, -1, 0, 0};
//        int[] dW = {0, 0, 1, -1};
//        // 출력 (세로방향, 가로방향 좌표) = 즉 (rowIdx, colIdx)
//        // 세로방향 = height, row 인덱스 | 세로 길이 row행 갯수
//        // 가로방향 = width, col 인덱스  | 가로 길이 col행 갯수
//        int widthRoute =0;
//        int heightRoute =0;
//
//        for(String direction: map.keySet()){
//            switch(direction){
//                case "N":{
//                    if(rowIdx + map.get("N")*dH[0]<0 | rowIdx + map.get("N")*dH[0]> parkArr.length){
//                        break;
//                    }
//                    else{
//                        heightRoute = rowIdx + map.get("N")*dH[0];
//                        if( parkArr[heightRoute][widthRoute].equals("X") ){
//                            heightRoute = rowIdx;
//                        }
//                        else{
//                            rowIdx = heightRoute;
//                        }
//                    }
//                    break;
//                }
//                case "S":{
//                    if(rowIdx + map.get("S")*dH[1]<0 | rowIdx + map.get("S")*dH[1]> parkArr.length){
//                        break;
//                    }
//                    else{
//                        heightRoute = rowIdx + map.get("S")*dH[1];
//                        if( parkArr[heightRoute][widthRoute].equals("X") ){
//                            heightRoute = rowIdx;
//                        }
//                        else{
//                            rowIdx = heightRoute;
//                        }
//                    }
//                    break;
//                }
//                case "E":{
//                    if( colIdx + map.get("E")*dW[2]<0 |  colIdx + map.get("E")*dW[2]> parkArr[0].length){
//                        break;
//                    }
//                    else{
//                        widthRoute = colIdx + map.get("E")*dW[2];
//                        if( parkArr[heightRoute][widthRoute].equals("X") ){
//                            widthRoute = colIdx;
//                        }
//                        else{
//                            colIdx =widthRoute;
//                        }
//                    }
//                    break;
//                }
//                case "W":{
//                    if(colIdx + map.get("W")*dW[3]<0 | colIdx + map.get("W")*dW[3]>parkArr[0].length){
//                        break;
//                    }
//                    else{
//                        widthRoute = colIdx + map.get("W")*dW[3];
//                        if( parkArr[heightRoute][widthRoute].equals("X") ){
//                            widthRoute = colIdx;
//                        }
//                        else{
//                            colIdx = widthRoute;
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//        answer[0] = rowIdx;
//        answer[1] = colIdx;
//    }
//}