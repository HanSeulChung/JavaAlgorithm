package com.codingtest.programmers.level0.주사위게임3;

import java.util.*;

public class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        List<Integer> keySetList = new ArrayList<>(map.keySet());

        switch(map.size()) {
            case 1:
                return 1111 * a;
            case 2:
                if (map.get(keySetList.get(0)) == 1 || map.get(keySetList.get(1)) == 1) {
                    int p = map.get(keySetList.get(0)) == 3 ? keySetList.get(0) : keySetList.get(1);
                    int q = map.get(keySetList.get(0)) == 1 ? keySetList.get(0) : keySetList.get(1);

                    return (int)Math.pow((10 * p + q), 2);
                } else {
                    int p = keySetList.get(0);
                    int q = keySetList.get(1);
                    return (p + q) * Math.abs(p - q);
                }
            case 3:
                int tmp = 0;
                for (Integer key : keySetList) {
                    if (map.get(key) != 2) {
                        if (tmp == 0) {
                            tmp = key;
                        } else {
                            return tmp * key;
                        }
                    }
                }
            case 4:
                Collections.sort(keySetList);
                return keySetList.get(0);
        }
        return 0;
    }
}
