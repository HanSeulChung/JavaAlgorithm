package com.codingtest.zerobaseshool.코딩테스트9주차;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 문제
 * 당신은 좀비 바이러스 치료제를 단 하나 가지고 있다.
 *
 * 이번에 매우 전염성이 높은 좀비 바이러스가 퍼져, 긴급히 방역이 필요한 상황이다.
 *
 * 총 N명의 인원이 관리 대상으로, i번째 인원과 j번째 인원이 서로 가까이 있어 감염시킬 수 있는 경우 graph[i][j]가 1로 주어진다.
 *
 * 서로 가까이 있는 인원 중에 한 명이라도 감염된 인원이 있다면, 결국 모두 서로를 감염시키게 된다.
 *
 * 현재 좀비 바이러스에 감염된 인원은 infected 배열에 주어진다.
 *
 * 당신은 치료제가 단 하나 있기 때문에, infected 의 인원 중 한 명을 치료할 수 있다.
 *
 * 이 때, 어떤 인원을 치료해야 좀비 바이러스에 감염되는 인원을 최소화할 수 있는지 해당 인원의 인덱스를 출력하시오.
 *
 * 단, 정답이 여럿인 경우 더 작은 인덱스를 출력하시오.
 *
 * 입력설명
 * 0 < N <= 100
 * graph.length = graph[0].length = N
 * 0 < infected.length <= N
 * 출력설명
 * 감염을 최소로 하기 위해 치료해야 하는 인원의 인덱스를 정수로 반환
 *
 * 매개변수 형식
 * N = 3
 *
 * graph = {{1, 1, 0},
 *          {1, 1, 0},
 *          {0, 0, 1}}
 * infected = {0, 2}
 *
 * 반환값 형식
 * 0
 *
 * 예시입출력 설명
 * 0번 인원을 치료할 경우 2명을 감염을 막을 수 있으나, 2번 인원을 치료할 경우 1명만 감염을 막을 수 있다.
 */

public class P3 {

    public int wrongSolution(int N, int[][] graph, int[] infected) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int infectedelement : infected) {
            map.put(infectedelement, new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            if (map.containsKey(i)) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (graph[i][j] == 1) {
                        map.get(i).add(j);
                    }
                }
            }
        }

        int maxSize = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int currentKey = entry.getKey();
            List<Integer> currentList = entry.getValue();
            int currentSize = currentList.size();

            if (currentSize > maxSize) {
                maxSize = currentSize;
                answer = currentKey;
            }
        }

        return answer;
    }

    public int solution(int N, int[][] graph, int[] infected) {
        UnionFind uf = new UnionFind(N);

        // 서로 연결된 인원을 모두 묶어준다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        // 더 작은 인덱스가 앞에 오도록 정렬
        Arrays.sort(infected);

        // 각 그룹 별로 어떤 감염자가 있는지 기록
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i: infected) {
            int root = uf.find(i);
            if (!group.containsKey(root)) {
                group.put(root, new ArrayList<>());
            }
            group.get(root).add(i);
        }

        int maxInd = -1;
        int maxSize = -1;
        for (int i: infected) {
            // 1. 감염자가 한명인 그룹은 그룹의 크기만큼 감염자를 줄일 수 있다.
            int currSize = uf.size(i);
            int root = uf.find(i);

            // 2. 감염자가 여럿인 그룹은 줄일 수 있는 감염자가 0 명
            if (group.get(root).size() > 1) {
                currSize = 0;
            }

            // 3. 더 많은 감염자를 줄일 수 있을 때에만 정답 업데이트
            if (currSize > maxSize) {
                maxInd = i;
                maxSize = currSize;
            }
        }
        return maxInd;
    }
}

class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int N) {
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }

        rank = new int[N];
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
            rank[rootX] += rank[rootY];
        } else {
            root[rootX] = rootY;
            rank[rootY] += rank[rootY];
        }
        return true;
    }

    public int size(int x) {
        return rank[find(x)];
    }
}