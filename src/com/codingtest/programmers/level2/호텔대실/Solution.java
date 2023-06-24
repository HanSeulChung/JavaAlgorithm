package com.codingtest.programmers.level2.호텔대실;
/**
* @package : com.codingtest.programmers.level1.호텔대실
* @name : Solution.java
* @date : 2023-06-23 오전 8:24
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
// 누적합과 우선순위 큐 우선순위 주는 compare방법 기억하기


import java.util.*;
class Solution {
    private static final int MAX_TIME = 1450;
    private static final int CLEAN_TIME = 10;
    public static int solution1(String[][] book_time) {
        int answer = 0;
        int time[][] = new int[book_time.length][2];

        for(int i =0;i<book_time.length;i++){
            int startTime = Integer.parseInt(book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(book_time[i][1].replace(":",""));

            endTime += 10;
            if(endTime%100 >= 60){
                endTime+=40;
            }
            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

//        // return 1은 정렬 안해도 된다는 것, return -1은 정렬을 한다는 것
//        Arrays.sort(time, (o1 , o2) -> {
//            if(o1[0]<o2[0]){
//                return 1;
//            } else if(o1[0]> o2[0]){
//                return -1;
//            } else{
//                if(o1[1]<o2[1]){
//                    return -1;
//                } else{
//                    return 1;
//                }
//            }
//         });

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for(int[] timeTemp : time){
            if(queue.size() == 0){
                queue.add(timeTemp[1]);
                continue;
            }
            if((queue.peek()) <= timeTemp[0]){
                System.out.println(queue);
                queue.poll();
                System.out.println(queue);
                queue.add(timeTemp[1]);
                System.out.println(queue);
            }else{

                queue.add(timeTemp[1]);
            }
        }

        return queue.size();
    }

    public static int solution2(String[][] book_time) {
        int answer = 0;

        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            rooms[calTime(inTime)] += 1;
            rooms[calTime(outTime) + CLEAN_TIME] -= 1;
        }

        // 누적합
        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }
    private static int calTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);

        return hour + minute;
    }
    // public int solution(String[][] book_time) {
    //     int answer = 0;
    //     Arrays.sort(book_time,(a, b) -> a[0].compareTo(b[0]));
    //     for(int i=0; i<book_time.length; i++){
    //         System.out.print(Arrays.asList(book_time[i])+ " ");
    //     }
    //     return answer;
    // }
    public static void main(String[] args) {
        String[][] booktime = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution1(booktime));
        booktime = new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}};
        System.out.println(solution1(booktime));
        booktime = new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        System.out.println(solution1(booktime));
    }
}