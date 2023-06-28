package com.lecture.비선형자료구조.연습문제1;

import java.util.*;

// 같은 이름 돔일인일때는 연결된 그래프
// 같은 이름 동명이인일때는 동떨어진 노드
//그 외 다른 이름은 동떨어진 노드
// 로 그래프로 생각하면 된다.
public class Practice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashMap<String, String> name = new HashMap<>();

        for(ArrayList<String> account : accounts) {
            String username = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }

                name.put(account.get(i), username);

                if (i == 1) { // 매 account의 처음은 간선 연결할 필요가 없으니까 넘어간다.
                    continue;
                }

                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i)); // 쌍방향으로 연결해주는 그래프
            }
        }

        HashSet<String> visited = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(String email : name.keySet()){
            ArrayList<String> list = new ArrayList<>();

            if(visited.add(email)){ // 중복 불가이므로 넣어지면 중복이 없었던 것이므로 1반환 or -1 반환하면 Set에 넣어지지 않는 경우 이때 if문 안으로 넘어가지 않음
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                result.add(list);
            }
        }
        return result;
    }
    public static void dfs(HashMap<String, HashSet<String>> graph, String email, HashSet<String> visited, ArrayList<String> list){
        list.add(email);

        for(String next: graph.get(email)){
            if(visited.add(next)){
                dfs(graph, next, visited, list);
            }
//            if(!visited.add(email)){
//                dfs(graph, next, visited, list);
//            }
         }
    }
    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);

//        System.out.println(accounts);
//        System.out.println();
//        System.out.println(accounts.get(0).get(0));
        for (ArrayList<String> item: accounts) {
            System.out.println(item);
        }
    }
}
