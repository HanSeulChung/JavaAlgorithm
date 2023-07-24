package com.codingtest.backjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13458{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long[] students = new long[(int)N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            students[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long superIntendent = Integer.parseInt(st.nextToken());
        long deputyIntendent = Integer.parseInt(st.nextToken());

        long result = students.length;
        for (int i = 0; i < students.length; i++) {
            students[i] -= superIntendent;

            if (students[i] > 0) {
                result += students[i] / deputyIntendent;

                if (students[i] % deputyIntendent != 0) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

