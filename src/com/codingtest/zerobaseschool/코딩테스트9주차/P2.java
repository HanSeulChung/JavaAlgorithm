package com.codingtest.zerobaseschool.코딩테스트9주차;


import java.util.*;

/**
 * 문제
 * N개의 국가를 연결하는 다양한 비행기편이 있다. 각 국가는 0부터 N-1의 인덱스로 표현된다.
 *
 * 각 비행기편은 flight[i] = {출발지 인덱스, 도착지 인덱스, 비용}으로 주어진다고 한다.
 *
 * 당신은 k번 이하로 비행기를 탑승하면서, a 국가에서 b 국가에 도착하기 위한 최소의 비용을 구하려고 한다.
 *
 * 위 프로그램을 구현하시오. 단, k번 이하의 비행편으로 a 국가에서 b 국가로 도달할 수 없는 경우 -1을 출력하시오.
 *
 * 입력설명
 * 0 < N <= 100
 * 0 <= flight[i][0] <= N-1
 * 0 <= flight[i][1] <= N-1
 * 0 < flight[i][2] <= 100
 * 0 <= a <= N-1
 * 0 <= b <= N-1
 * 0 < k <= N
 * 출력설명
 * 최소의 비용을 정수로 반환
 *
 * 매개변수 형식
 * N = 4
 *
 * flight = {{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}}
 *
 * a = 1
 *
 * b = 3
 *
 * k = 2
 *
 * 반환값 형식
 * 11
 *
 * 예시입출력 설명
 * 아래 순서대로 항공편을 이용하면 최소의 비용으로 이동할 수 있다.
 *
 * 1 -> 0 항공편 (비용 8)
 * 0 -> 3 항공편 (비용 3)
 * 2번 이하로 항공을 이용해야 하므로 아래 항공편은 정답에 해당하지 않는다.
 *
 * 1 -> 0 항공편 (비용 8)
 * 0 -> 2 항공편 (비용 1)
 * 2 -> 3 항공편 (비용 1)
 */
public class P2 {

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] ints : flight) {
            int src = ints[0];
            int dst = ints[1];
            int price = ints[2];
            adjList.get(src).add(new int[]{dst, price});
        }


        int[] bestCount = new int[N];
        Arrays.fill(bestCount, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(x -> x[0])
        );

        // 누적 비용, 이동 횟수, 노드
        pq.offer(new int[]{0, 0, a});

        while (!pq.isEmpty()) {
            int[] value = pq.poll();
            int price = value[0];
            int count = value[1];
            int node = value[2];

            if (bestCount[node] <= count) {
                continue;
            }

            bestCount[node] = count;

            if (count > k) {
                continue;
            }

            if (node == b) {
                return price;
            }

            for (int[] ints: adjList.get(node)) {
                int adjNode = ints[0];
                int addPrice = ints[1];
                pq.offer(new int[]{price + addPrice, count + 1, adjNode});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] flight = {{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}};
        System.out.println(solution(4, flight, 1, 3, 2));
    }
}