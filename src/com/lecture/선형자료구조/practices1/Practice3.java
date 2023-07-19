package com.lecture.선형자료구조.practices1;

class Node {
    int data;
    int cmd;  // 풍선에 적힌 얼마나 어디로 옮겨질지의 대한 command. ex 3: 오른쪽으로 3칸, -1: 왼쪽으로 1칸

    boolean visited;
    Node next;
    Node prev;

    public Node(int data, int cmd, boolean visited, Node next, Node prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedListC { //필요한 메서드만 만듦
    Node head;

    public void add(int data, int cmd){
        if (this.head == null) {
            this.head = new Node(data, cmd, false, null, null);
            this.head.next = this.head;
            this.head.prev = this.head;
        } else {
            Node cur = this.head;
            while (cur.next != this.head) {
                cur = cur.next;
            }
            cur.next = new Node(data, cmd, false,  cur.next, cur);
            this.head.prev = cur.next;
        }
    }
}

public class Practice3 {
    // 기본 배열구조에서도 풀 수 있을 것 같음
    // 그러나 원형 배열느낌이니까 연결리스트
    public static void solution(int[] data) {
        LinkedListC linkedlist = new LinkedListC();
        for (int i = 0; i < data.length; i++) {
            linkedlist.add(i + 1, data[i]);
        }

        Node cur = linkedlist.head;

        int visitCnt = 0;
        int cmd = 0;
        while (visitCnt != data.length) {
            int cnt = 0;
            while (cnt != Math.abs(cmd)) {
                if (cmd > 0){
                    cur = cur.next;
                } else {
                    cur = cur.prev;
                }

                if (cur.visited == false){
                    cnt++;
                }
            }
            System.out.print(cur.data + " ");
            cur.visited = true;
            visitCnt++;
            cmd = cur.cmd;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}
