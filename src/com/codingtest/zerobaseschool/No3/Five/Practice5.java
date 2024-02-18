package com.codingtest.zerobaseschool.No3.Five;

import java.util.*;
public class Practice5 {
    public static int[] changesMoney(int money){
        int[] coins = {500, 100, 50, 10};
        List<Integer> changes = new LinkedList<>();
        int idx = 0;
        while(true){
            if(idx == coins.length -1 || money == 0){
                break;
            }

            if(money < coins[idx]){
                idx++;
            }

            if( money % coins[idx]==0){
                for(int i =0; i< money/coins[idx]; i++){
                    changes.add(coins[idx]);
                }
                break;
            } else {
                changes.add(coins[idx]);
                money %= coins[idx];
            }
        }

        // for(int i = 0; i < coins.length; i++){
        //     if(money < coins[i]){
        //         continue;
        //     }

        //     //int q = money/coins[i];
        //     changes.add(coins[i]);
        //     money %= coins[i];

        // }
        System.out.println(changes);
        return changes.stream().mapToInt( i -> i).toArray();

    }

    public static int[] solution(int[] arr) {
        int[] tmps = {};
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> papers = new HashSet<>(Arrays.asList(10000, 5000, 1000));
        HashSet<Integer> coins = new HashSet<>(Arrays.asList(500, 100, 50, 10));

        boolean init = false;
        for(int money : arr){
            if(papers.contains(money) && !init){
                ans.add(money);
                init = true;
            } else if( papers.contains(money) && init){
                tmps = changesMoney(money);
                System.out.println(Arrays.toString(tmps));
            } else {
                ans.add(money);
            }
        }
        for(int tmp : tmps){
            ans.add(tmp);
        }
        //System.out.println(tmps);

        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1000, 1000, 100};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
