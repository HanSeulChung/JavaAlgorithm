package com.lecture.비선형자료구조.graph;

// Practice1
// 인접 리스트를 이용한 그래프 구현

class Node{
    int id;
    Node next;

    public Node(int id, Node next){
        this.id = id;
        this.next = next;
    }
}
class MyGraphList {
    char[] vertices;
    Node[] adjList;
    int elemCnt;

    public MyGraphList(){}
    public MyGraphList(int size){
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.adjList.length;
    }

    public void addVertex(char data){
        if(isFull()){
            System.out.println("Graph is full");
            return;
        }
        this.vertices[elemCnt++] = data;
    }

    public void addEdge(int x, int y){
        this.adjList[x] = new Node(y, this.adjList[x]); // 맨 뒤에 추가하면 매번 뒤까지 가는것이 시간이 오래걸리니까 앞에 추가!!
        this.adjList[y] = new Node(x, this.adjList[y]);
    }
    public void addDirectedEdge(int x, int y){
        this.adjList[x] = new Node(y, this.adjList[x]); // 맨 뒤에 추가하면 매번 뒤까지 가는것이 시간이 오래걸리니까 앞에 추가!!
    }

    public void printAdjacentList(){
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + ": ");

            Node cur = this.adjList[i];
            while(cur!=null){
                System.out.print(this.vertices[cur.id]+" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        MyGraphList graph = new MyGraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}

