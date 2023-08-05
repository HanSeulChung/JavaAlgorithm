package com.codingtest.zerobaseshool.코딩테스트4주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2 {
    public static int[] mysolution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int cnt;

        for (int i = 0; i < queries.length; i++) {
            cnt = 0;
            String query = queries[i];
            if (query.charAt(0) == '*') {
                query = query.replaceAll("\\*","");
                for (String word : words) {
                    if (word.endsWith(query)) {
                        cnt++;
                    }
                }
            } else if (query.charAt(query.length() - 1) == '*') {
                query = query.replaceAll("\\*","");
                for (String word : words) {
                    if (word.startsWith(query)) {
                        cnt++;
                    }
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

    public int[] solution(String[] words, String[] queries) {
        Trie2 trie = new Trie2();
        Trie2 inTrie = new Trie2();

        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            trie.addWord(word);
            inTrie.addWord(sb.reverse().toString());
        }

        List<Integer> resultList = new ArrayList<>();
        for (String query : queries) {
            if (query.charAt(0) != '*') {
                resultList.add(trie.getResult(query));
            } else {
                StringBuilder sb = new StringBuilder(query);
                resultList.add(inTrie.getResult(sb.reverse().toString()));
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
class Node2 {
    char val;
    Map<Character, Node2> children = new HashMap<>();
    int words = 0;

    public Node2(char val) {
        this.val = val;
    }
}

class Trie2 {
    Node2 head = new Node2('\n');

    public void addWord(String word) {
        Node2 curr = head;
        //curr.words++; // *만 들어왔을 경우 but test case에 맞지않음...!
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node2(c));
            }
            curr = curr.children.get(c);
            curr.words++;
        }
    }
    public int getResult(String query) {
        Node2 curr = head;

        for (char c: query.toCharArray()) {
            if (c =='*') {
                return curr.words;
            }
            if (!curr.children.containsKey(c)) {
                return 0;
            }
            curr = curr.children.get(c);
        }
        return curr.words;
    }
}

/*
* import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] words, String[] queries) {
    /* 정확성 테스트
테스트 1 〉 통과 (15.30ms, 85.7MB)
테스트 2 〉 통과 (16.82ms, 87.3MB)
테스트 3 〉 통과 (23.30ms, 88.9MB)
테스트 4 〉 통과 (15.79ms, 83.8MB)
테스트 5 〉 통과 (15.41ms, 77.9MB)
효율성 테스트
테스트 1 〉 통과 (23.69ms, 60.1MB)
테스트 2 〉 통과 (44.70ms, 60.9MB)
테스트 3 〉 통과 (97.52ms, 86.8MB)
테스트 4 〉 통과 (106.97ms, 86.7MB)
테스트 5 〉 통과 (256.01ms, 110MB)
* /
        Trie trie = new Trie();
        Trie invTrie = new Trie();

        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            trie.addWord(word);
            invTrie.addWord(sb.reverse().toString());
        }

        List<Integer> resultList = new ArrayList<>();
        for (String query: queries) {
            if (query.charAt(0) != '*') {
                resultList.add(trie.getResult(query));
            } else {
                StringBuilder sb = new StringBuilder(query);
                resultList.add(invTrie.getResult(sb.reverse().toString()));
            }
        }
        return resultList.stream().
                mapToInt(Integer::intValue).toArray();
    }
}

class Node {
    char val;
    Map<Character, Node> children = new HashMap<>();
    int words = 0;

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    Node head = new Node('\n');

    public void addWord(String word) {
        Node curr = head;

        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
            curr.words++;
        }
    }

    public int getResult(String query) {
        Node curr = head;

        for (char c: query.toCharArray()) {
            if (c == '*') {
                return curr.words;
            }
            if (!curr.children.containsKey(c)) {
                return 0;
            }
            curr = curr.children.get(c);
        }
        return curr.words;
    }
}*/