package com.codingtest.zerobaseshool.코딩테스트4주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1 {
    public static String[][] mysolution(String[] titles, String[] lyrics, String[] problems) {
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