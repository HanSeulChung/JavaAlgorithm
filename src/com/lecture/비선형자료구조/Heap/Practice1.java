package com.lecture.비선형자료구조.Heap;

//최대 힙 구현
import java.util.ArrayList;

class MaxHeap{
    ArrayList<Integer> heap;

    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data){
        heap.add(data);

        int cur = heap.size() - 1;
        while( cur > 1 && heap.get(cur/2) < heap.get(cur)){
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete(){
        if(heap.size() ==1){
            System.out.println("Heap is empty");
            return null;
        }

        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() -1));
        heap.remove(heap.size() -1);

        int cur = 1; // 최상위 노드로 위치시킴
        while(true){
            int leftIdx = cur*2;
            int rightIdx = cur*2 +1;
            int targetIdx = -1;

            if(rightIdx < heap.size()){ // 자식 노드가 두개 있을 경우
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx:rightIdx;
            } else if (leftIdx < heap.size()){ // 자식 노드가 한개 있을 경우
                targetIdx = cur*2;
            } else {
                break; // 자식노드가 없을 경우
            }

            if(heap.get(cur) > heap.get(targetIdx)){
                break;
            }else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx; // 아래로 내려가면서 계속 반복
            }
        }

        return target;
    }
    public void printTree(){
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i)+ " ");
        }
        System.out.println();
    }
}
public class Practice1 {
    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap();
        System.out.println("== 데이터 삽입 ==");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();
        maxHeap.insert(30);

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: "+ maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: "+ maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: "+ maxHeap.delete());
        maxHeap.printTree();
    }
}

