package com.codingtest.zerobaseshool.코딩테스트12주차;
import java.util.*;
import java.util.stream.Collectors;

public class P1 {
    public int mySolution(String s) {
        int answer = 0;

        while(!s.equals("a")) {
            System.out.println(s);
            List<Integer> aList = new ArrayList<>();
            Stack<Integer> aStack = new Stack<>();

            s = s.replaceAll("[a]+", "a");
            char[] charArray = s.toCharArray();

            for (int i = 0; i < charArray.length; i++) {

                if(charArray[i] =='a') {
                    if (aStack.isEmpty() || aStack.peek() != i - 1) {
                        aList.add(i);
                        aStack.add(i);
                    } else if (aStack.peek() == i - 1) {
                        aStack.add(i);
                        aList.remove(Integer.valueOf(i - 1));
                    }
                }
            }


            for (int i = 0; i < aList.size(); i++) {

                if (aList.get(i) - 1 >= 0) {
                    charArray[aList.get(i) - 1] = 'a';
                }
                if (aList.get(i) + 1 < charArray.length) {
                    charArray[aList.get(i) + 1] = 'a';
                }
            }
            s = new String(charArray);

            answer++;
        }

        return answer;
    }

    public int solution(String s) {
        int count = 0;
        List<Character> chars = s.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.toList());

        // 'a'일 떄 까지 반복합니다.
        while (!(chars.size() == 1 && chars.get(0) == 'a')) {
            count++;

            // a가 연속해서 나오면 시작/끝 인덱스를 기록
            // a가 하나씩 나오면 a의 위치를 기록
            List<int[]> multiA = new ArrayList<>();
            List<Integer> singleA = new ArrayList<>();

            int start = -1;
            int end = -1;
            boolean aFound = false;
            for (int i = 0; i < chars.size(); i++) {
                if (!aFound) { // a를 찾으면 시작점으로 여깁니다.
                    if (chars.get(i) == 'a') {
                        aFound = true;
                        start = i;
                        if (i == chars.size() - 1) { // 단, 마지막 자리에서 시작하면 단일 a입니다.
                            singleA.add(start);
                            aFound = false;
                        }
                    }
                } else {
                    if (chars.get(i) != 'a') {
                        end = i - 1;
                        if (start == end) { // 시작과 끝이 같으면 단일 a로 취급
                            singleA.add(start);
                        } else { // 시작과 끝이 다르면 연속된 a로 취급
                            multiA.add(new int[]{start, end});
                        }
                        aFound = false;
                    } else if (i == chars.size() - 1) { // 마지막까지 a가 있는 경우에도 꼼꼼하게 처리
                        end = i;
                        multiA.add(new int[]{start, end});
                        aFound = false;
                    }
                }
            }

            // 단일 a 양옆을 a로 바꿔줍니다.
            for (int i: singleA) {
                if ((i+1) < chars.size()) {
                    chars.set(i+1, 'a');
                }
                if (i-1 >= 0) {
                    chars.set(i-1, 'a');
                }
            }

            List<Character> newChars = new ArrayList<>();
            int lastEnd = -1;
            for (int[] ints: multiA) {
                start = ints[0];
                end = ints[1];

                newChars.addAll(chars.subList(lastEnd+1, start)); // 연속된 a가 나타나기 전까지 문자열 삽입
                newChars.add('a'); // 여러개의 a를 (start ~ end 구간) 하나의 a로 변경
                lastEnd = end;
            }
            newChars.addAll(chars.subList(lastEnd+1, chars.size()));
            chars = newChars;
        }
        return count;
    }
}