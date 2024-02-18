package com.codingtest.zerobaseschool.코딩테스트2주차;

public class P2 {
    static long A, B;
    static int[] answer;

    public int[] solution(int[] a, int[] b) {

        A = 0;
        int lengthN = a.length;
        for (int i = 0; i < lengthN; i++) {
            A += a[i] * Math.pow(10, lengthN - i - 1);
        }
        System.out.println(A);
        B = 0;
        lengthN = b.length;
        for (int i = 0; i < lengthN; i++) {
            B += b[i] * Math.pow(10,  lengthN - i - 1);
        }
        System.out.println(B);
        A = A + B;
        String temp = Long.toString(A);
        answer = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++){
            answer[i] = temp.charAt(i) - '0';
        }
        // ArrayList<Integer> arraylist = new ArrayList<>();
        // while (A > 0) {
        //     int tmp = (int)(A % 10);
        //     arraylist.add(tmp);
        //     A /= 10;
        // }
        // Collections.reverse(arraylist);
        // answer = arraylist.stream().mapToInt(x -> x).toArray();

        return answer;
    }
    public static int[] solution1(int[] a, int[] b) {

        if (a.length == 0) {
            a = new int[]{0};
        }
        if (b.length == 0) {
            b = new int[]{0};
        }

        // if (a.length > b.length) {
        //     int[] tmp = new int[a.length];
        //     int index = 0;
        //     for (int i =  tmp.length - b.length; i < tmp.length; i++) {
        //         tmp[i] = b[index++];
        //     }
        //     //b = new int[a.length];
        //     b = tmp;

        // } else if (a.length < b.length) {
        //     int[] tmp = new int[b.length];
        //     int index = 0;
        //     for (int i =  tmp.length - a.length; i < tmp.length; i++) {
        //         tmp[i] = a[index++];
        //     }
        // }

        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        int A = 0;
        int B = 0;
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 6};
        int[] b = {6, 1, 0, 4, 4};
        int[] answer = solution1(a, b);
        a = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        b = new int[]{1};
        answer = solution1(a, b);

//        String A = "33";
//        String B = "22";
//        String[] splitA = A.split("");
//        String[] splitB = B.split("");



    }
}
