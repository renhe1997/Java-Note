package com.company.LeetCode.Tree;

import com.company.DataStructure.Tree.Node;

/**
 * 深度优先-二叉树的前中后序遍历
 * @Author: RenHe
 * @Date: 2021/8/12 15:08
 */
public class TreeDepthFirstTraversal {
    /**
     * 先序遍历
     * 递归调用，可以访问到根节点
     * @param root
     */
    public static void firstOrder(Node root){ //确定递归函数的参数和返回值
        if(root != null){ // 终止条件
            System.out.println(root.getData());
            firstOrder(root.getLeft()); // 确定单层递归的逻辑
            firstOrder(root.getRight());
        }
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }
    //后序遍历
    public void afterOrder(Node root){
        if(root != null){
            afterOrder(root.getLeft());
            afterOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.add(new Node(0));
        node.add(new Node(2));
        inOrder(node);
    }
}
