package com.lecture.기출문제.연습문제2;

import java.util.Arrays;
import java.util.HashMap;

public class Practice3 {

    public static long[] solution(long n, long[] rooms) {
        HashMap<Long, Long> map = new HashMap<>();
        long[] result = new long[rooms.length];

        for (int i = 0; i < rooms.length; i++) {
            if (!map.containsKey(rooms[i])) {
                result[i] = rooms[i];
                map.put(rooms[i], (rooms[i] + 1) % n);
            } else {
                long cur = rooms[i];
                while (map.containsKey(cur)) {
                    cur = map.get(cur);
                }
                result[i] = cur;
                map.put(cur, (cur + 1) % n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        long[] rooms = {0, 2, 3, 3};
        System.out.println(Arrays.toString(solution(3, rooms)));

        rooms = new long[] {1, 5, 7, 9, 9, 9, 1, 2, 2, 2};
        System.out.println(Arrays.toString(solution(10, rooms)));
    }
}
