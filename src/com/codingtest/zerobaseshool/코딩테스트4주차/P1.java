package com.codingtest.zerobaseshool.코딩테스트4주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1 {
    public static String[][] mysolution(String[] titles, String[] lyrics, String[] problems) {
        /*
 정확성 테스트
테스트 1 〉 통과 (0.52ms, 84.4MB)
테스트 2 〉 통과 (0.32ms, 76.7MB)
테스트 3 〉 통과 (0.80ms, 77.1MB)
테스트 4 〉 통과 (0.57ms, 73.6MB)
테스트 5 〉 통과 (0.20ms, 75.9MB)
효율성 테스트
테스트 1 〉 통과 (0.77ms, 52.4MB)
테스트 2 〉 통과 (3.31ms, 52.8MB)
테스트 3 〉 통과 (9.74ms, 53.6MB)
테스트 4 〉 통과 (11.96ms, 64.5MB)
테스트 5 〉 통과 (112.92ms, 85.5MB)
        * */
        List<String[]> answerList = new ArrayList<>();

        for (String problem : problems) {
            List<String> matchingTitles = new ArrayList<>();
            for (int i = 0; i < lyrics.length; i++) {
                // lyrics[i] 가사의 시작이 problems[i]와 같을 경우 titles[i] 추가
                if (lyrics[i].startsWith(problem)) {
                    matchingTitles.add(titles[i]);
                }
            }
            answerList.add(matchingTitles.toArray(new String[0]));
        }

        String[][] answer = answerList.toArray(new String[0][]);

        return answer;
    }

    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        /*
정확성 테스트
테스트 1 〉 통과 (7.33ms, 88.9MB)
테스트 2 〉 통과 (5.15ms, 80MB)
테스트 3 〉 통과 (5.81ms, 84.6MB)
테스트 4 〉 통과 (19.17ms, 90.8MB)
테스트 5 〉 통과 (2.47ms, 69.8MB)
효율성 테스트
테스트 1 〉 통과 (13.08ms, 55MB)
테스트 2 〉 통과 (30.39ms, 64.7MB)
테스트 3 〉 통과 (24.71ms, 60.4MB)
테스트 4 〉 통과 (595.04ms, 406MB)
테스트 5 〉 통과 (33.64ms, 82MB)*/
        Trie trie = new Trie();
        for (int i = 0; i < titles.length; i++) {
            trie.addLyrics(titles[i], lyrics[i]);
        }

        List<String[]> resultList = new ArrayList<>();
        for (String query : problems) {
            resultList.add(trie.getResult(query));
        }
        return resultList.toArray(new String[0][0]);
    }
    public static void main(String[] args) {

    }
}

class Node {
    char val;
    Map<Character, Node> children = new HashMap<>();
    List<String> songs = new ArrayList<>(); // 순서대로 나와야하기 때문에 arraylist를 사용

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    Node head = new Node('\n');

    public void addLyrics(String songName, String lyric) {
        Node curr = head;

        for (char c: lyric.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
            curr.songs.add(songName);
        }
    }

    public String[] getResult(String query) {
        Node curr = head;

        for (char c : query.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return new String[]{};
            }
            curr = curr.children.get(c);
        }
        return curr.songs.toArray(new String[0]); //0으로 넣는게 가장 최적화가 되어있음.
    }
}