package com.lecture.선형자료구조.hashtable.practices;

import java.util.Hashtable;

/**
 * // Practice1
 * // 해시 테이블을 이용한 수 찾기
 * // 주어진 첫 번째 배열을 이용하여 해시 테이블을 초기화 한 후
 * // 두 번째 배열이 주어졌을 때 해당 배열 내 데이터가 해시 테이블에 있는지 확인하는 코드를 작성하세요.
 *
 * // 입출력 예시)
 * // 배열1: 1, 3, 5, 7, 9
 * // 배열2: 1, 2, 3, 4, 5
 * // 출력: True, False, True, False, True
* @package : com.lecture.선형자료구조.hashtable.practices
* @name : P1.java
* @date : 2023-06-19 오후 6:13
* @author : HSChung
* @version : 1.0.0
* @modifyed :
**/
public class P1 {

    public static void solution(int[] arr1, int[] arr2){
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for(int arr1N : arr1){
            ht.put(arr1N,  arr1N);
        }
        for(int arr2N : arr2){
            if(ht.containsKey(arr2N)){
                System.out.println("True");
            } else{
                System.out.println("False");
            }
        }

    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5};
        solution(arr1, arr2);
    }
}
