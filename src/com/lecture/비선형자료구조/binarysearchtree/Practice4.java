package com.lecture.비선형자료구조.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

// 비선형 자료구조 - 이진 탐색 트리_3
// Red-Black 트리 - 삽입
class RBNode{
    int key;
    int color;
    RBNode left;
    RBNode right;
    RBNode parent;

    public RBNode(int key, int color, RBNode left, RBNode right, RBNode parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    } // alt + insert로 생성
}

class RedBlackTree{
    final int BLACK = 0;
    final int RED = 1;

    RBNode head;

    public void insert(int key){
        RBNode checkNode = null;
        if (this.head == null){
            this.head  = new RBNode(key,BLACK,null,null,null);
        } else {
            RBNode cur = this.head;

            while (true){
                RBNode pre = cur;

                if(key < cur.key){
                    cur = cur.left;
                    if(cur == null){
                        pre.left = new RBNode(key, RED, null, null, pre);
                        checkNode = pre.left;
                        break;
                    }
                } else {
                    cur = cur.right;
                    if(cur == null){
                        pre.right = new RBNode(key, RED, null, null, pre);
                        checkNode = pre.right;
                        break;
                    }
                }
            }

            reBlance(checkNode);
        }
    }

    public void reBlance(RBNode node){
        while (node.parent != null && node.parent.color == RED){  // 삽입 노드는 항상 red, 그 때 부모노드도 red일 경우 double red 현상 발생
            RBNode sibling =null;

            if(node.parent == node.parent.parent.left){ // 부모 노드의 형제를 찾기위함 즉, 노드의 엄마(부모)노드가 할머니(조상)노드의 왼쪽 자식일때
                sibling = node.parent.parent.right; // 그럼 부모 노드의 형제는 할머니 노드의 오른쪽 자식이다.
            } else {
                sibling = node.parent.parent.left;
            }

            if(sibling != null && sibling.color ==RED){ // 부모노드의 형제 노드도 빨간색일 땐 recoloring! + 현재 삽입노드와 부모노드 둘다 빨간색인 double red현상임
                node.parent.color = BLACK;
                sibling.color = BLACK;
                node.parent.parent.color = RED;

                if(node.parent.parent == this.head){
                    node.parent.parent.color = BLACK;
                    break;
                } else {
                    node = node.parent.parent;
                    continue;
                }
            } else {    // 부모노드의 형제 노드가 검정색일 땐 restructering! + 현재 삽입노드와 부모노드 둘다 빨간색인 double red현상임
                if( node.parent == node.parent.parent.left){
                    if(node == node.parent.right) { //LR 일경우
                        node = node.parent;
                        // 회전
                        leftRotate(node);
                    }

                    node.parent.color = BLACK;
                    node.parent.parent.color =RED;
                    rightRottate(node.parent.parent);
                } else if( node.parent == node.parent.parent.right){
                    if(node==node.parent.left){ //RL 일경우
                        node = node.parent;

                        rightRottate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color =RED;
                    leftRotate(node.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(RBNode node){
        if(node.parent == null){ // 이미 LR로 했는데 왜 굳이 부모노드의 부모노드가 null인 경우 까지 넣었지?
            RBNode rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            rNode.parent = null;
            this.head = rNode;
        } else {
            if(node == node.parent.left){
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent= node.right;

            if(node.right.left != null){
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left= node;
        }
    }

    public void rightRottate(RBNode node){
        if(node.parent == null){
            RBNode lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        } else {
            if(node == node.parent.left){
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
            node.left.parent = node.parent;
            node.parent= node.left;

            if(node.left.right != null){
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right= node;
        }
    }

    public void levelOrder(RBNode node){
        char[] color = {'B', 'R'};

        Queue<RBNode> queue = new LinkedList<>();
        queue.add(node);
        while( !queue.isEmpty()){
            RBNode cur = queue.poll();

            System.out.print("[" +color[cur.color] +"}" + cur.key + " ");
            if(cur.left !=null){
                queue.offer(cur.left);
            }
            if ( cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice4 {
    public static void main(String[] args) {
        // Test code
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(20);
        rbTree.levelOrder(rbTree.head);
    }
}

