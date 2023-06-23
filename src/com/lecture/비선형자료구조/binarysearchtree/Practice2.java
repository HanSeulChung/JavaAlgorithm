package com.lecture.비선형자료구조.binarysearchtree;
// 비선형 자료구조 - 이진 탐색 트리_2(균형 이진 탐색 트리) 보통 AVL트리와 Red-Black 트리가 존재함
// AVL 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class NodeAVL {
    int key;
    int height;
    NodeAVL left;
    NodeAVL right;

    public NodeAVL(int key, NodeAVL left, NodeAVL right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    NodeAVL head;

    public int height(NodeAVL node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public NodeAVL rightRotate(NodeAVL node) {
        NodeAVL lNode = node.left;

        node.left = lNode.right; // lNode의 오른쪽에 또다른 노드가 있을 경우 !!
        lNode.right = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right)) + 1;

        return lNode;
    }

    public NodeAVL leftRotate(NodeAVL node) {
        NodeAVL rNode = node.right;

        node.right = rNode.left; // 마찬가지로 rNode의 왼쪽에 또 다른노드가 있을 경우
        rNode.left = node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rNode.height = Math.max(height(rNode.left), height(rNode.right)) + 1;

        return rNode;
    }

    public NodeAVL lrRotate(NodeAVL node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public NodeAVL rlRotate(NodeAVL node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(NodeAVL node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    public void insert(int key) {
        this.head = insert(this.head, key);
    }

    public NodeAVL insert(NodeAVL node, int key) {
        if (node == null) {
            return new NodeAVL(key, null, null);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        //LL
        if (balance > 1 && key < node.left.key) { // 5 - 10 - 20(root) case
            return rightRotate(node);
        }
        //RR
        if (balance < -1 && key > node.right.key) { // 20(root) - 30 - 40 case
            return leftRotate(node);
        }
        //LR
        if (balance > 1 && key > node.left.key) { // 15 - 10 - 20(root) case
            return lrRotate(node);
        }
        //RL
        if (balance < -1 && key < node.right.key) { // 20(root) - 30 - 25 case
            return rlRotate(node);
        }

        return node;
    }

    public void levelOrder(NodeAVL node) {

        Queue<NodeAVL> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            NodeAVL cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}
public class Practice2 {
    public static void main(String[] args) {
        // Test code
        AVLTree avl = new AVLTree();

        // Insert
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);     // LL
        avl.levelOrder(avl.head);

        avl.insert(40);
        avl.insert(50);     // RR
        avl.levelOrder(avl.head);

        avl.insert(5);
        avl.insert(7);      // LR
        avl.levelOrder(avl.head);

        avl.insert(60);
        avl.insert(55);     // RL
        avl.levelOrder(avl.head);
    }
}

