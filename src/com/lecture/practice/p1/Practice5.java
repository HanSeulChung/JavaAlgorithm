package com.lecture.practice.p1;
// n개의 데이터가 hegith 배열에 주어졌을 경우, 어떤 두 벽을 고르면 가장 많은 물을 담을 수 있는지 확인하고 면적 출력
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Collections;
public class Practice5 {
    public static int solution(int[] height){
        int maxArea =0;
        int left =0;
        int right = height.length -1;

        while(left< right){
            int x = (right - left);
            int y = height[left] <height[right] ? height[left]: height[right];
            int currentArea = x*y;
            maxArea = maxArea > currentArea ? maxArea:currentArea;
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }


        return maxArea;
    }
    public static void main(String[] args){
//        ArrayList heightArray = new ArrayList();
//        heightArray.add(1);
//        heightArray.add(8);
//        heightArray.add(6);
//        heightArray.add(2);
//        heightArray.add(5);
//        heightArray.add(4);
//        heightArray.add(8);
//        heightArray.add(3);
//        heightArray.add(7);
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution(height));
        height = new int[] {5, 3, 9, 2, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(solution(height));
    }
}
