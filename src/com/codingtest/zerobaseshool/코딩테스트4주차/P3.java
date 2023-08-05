package com.codingtest.zerobaseshool.코딩테스트4주차;


import java.util.*;

public class P3 {
    public static String[][] solution(String[] words, String[] queries) {
        /*
정확성 테스트
테스트 1 〉 통과 (2.36ms, 76.3MB)
테스트 2 〉 통과 (2.39ms, 74.3MB)
테스트 3 〉 통과 (16.56ms, 86.2MB)
테스트 4 〉 통과 (13.37ms, 79.9MB)
테스트 5 〉 통과 (8.55ms, 89.7MB)
효율성 테스트
테스트 1 〉 통과 (30.39ms, 62.7MB)
테스트 2 〉 통과 (540.40ms, 325MB)
테스트 3 〉 통과 (1042.58ms, 745MB)
테스트 4 〉 통과 (100.15ms, 92.1MB)
테스트 5 〉 통과 (874.14ms, 584MB)
        * */
        Map<Integer, Trie3> trieHashMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            if (!trieHashMap.containsKey(n)) {
                trieHashMap.put(n, new Trie3());
            }
            Trie3 trie = trieHashMap.get(n);
            trie.addWord(words[i], i);
        }

        List<String[]> resultList = new ArrayList<>();
        for (String query: queries) {
            int n = query.length();
            if (!trieHashMap.containsKey(n)) {
                resultList.add(new String[0]);
            } else {
                String[] result = trieHashMap.get(n).getResult(query).stream().map(x -> words[x]).toArray(String[]::new);

                resultList.add(result);
            }
        }
        return resultList.toArray(new String[0][]);
    }

}
class Node3 {
    char val;
    Map<Character, Node3> children = new HashMap<>();
    List<Integer> words = new ArrayList<>(); // 순서대로 나와야하기 때문에 arraylist를 사용

    public Node3(char val) {
        this.val = val;
    }
}
class Trie3 {
    Node3 head = new Node3('\n');

    public void addWord(String word, int idx) {
        Node3 curr = head;
        curr.words.add(idx);

        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node3(c));
            }
            curr = curr.children.get(c);
            curr.words.add(idx);
        }
    }

    public List<Integer> getResult(String query) {
        Node3 curr = head;

        for (char c : query.toCharArray()) {
            if (c == '?') {
                return curr.words;
            }
            if (!curr.children.containsKey(c)) {
                return new ArrayList<>();
            }
            curr = curr.children.get(c);
        }
        return curr.words;
    }
}