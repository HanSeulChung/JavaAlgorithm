package com.codingtest.programmers.level0.뒤에서5등까지;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution1(int[] num_list) {
        return Arrays.stream(num_list).sorted().limit(5).toArray();

//        return Arrays.stream(num_list)
//                .boxed()
//                .sorted(Comparator.reverseOrder())  // 내림차순 정렬 sorted()메서드는 stream형식을 넣어야하고 Comparator 객체를 사용해야함.
                                                        // Collections는 주로 List나 Set 주로 컬렉션에 사용하는 것이다. 배열에대한 내림차순을 직접적으로 제공해주지않음 soluiton2 참고
//                .limit(5)
//                .mapToInt(Integer::intValue)
//                .toArray();
    }

    public int[] solution2(int[] num_list) {
        Arrays.sort(num_list);
        return Arrays.copyOfRange(num_list, 0, 5);
    }

    public int[] mysolution(int[] num_list) {
        Arrays.sort(num_list);

//        Integer[] boxedArray = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
//        Arrays.sort(boxedArray, Collections.reverseOrder());  // 이렇게 Integer형식으로 래핑해줘야 Collections.reverseOrder()를 사용할 수 있다.
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }
}