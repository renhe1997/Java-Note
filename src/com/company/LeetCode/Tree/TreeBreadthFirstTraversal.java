package com.company.LeetCode.Tree;

import com.company.DataStructure.Tree.Node;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 广度优先-二叉树层序遍历
 * 102.二叉树的层序遍历
 * 题目地址：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Author: RenHe
 * @Date: 2021/8/16 9:26
 */
public class TreeBreadthFirstTraversal {
    /**
     *
     * @param node
     */
    public static void select(Node node){
        if (null==node){
            return;
        }
        List resultList = new ArrayList<>();
        // 定义一个队列
        ArrayQueue<Node> queue = new ArrayQueue(10);
        queue.add(node);
        while (!queue.isEmpty()){
            // 拿出来，用于取左右子树
            Node root = queue.get(0);
            // 放值
            resultList.add(root.getData());
            // 从队列中取出
            queue.remove(0);
            // 放左子树到队列
            if (root.getLeft()!=null){
                queue.add(root.getLeft());
            }
            // 放右子树到队列
            if (root.getRight()!=null){
                queue.add(root.getRight());
            }
        }
        System.out.println(resultList.toArray());
    }


    /**
     *  * 107.二叉树的层次遍历 II
     *  * 题目链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     *  * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
     public static List selectReverse(Node node){
        if (node==null){
            return null;
        }
        List resultList = new ArrayList();
        List<Node> queue = new ArrayQueue(10);
        queue.add(node);
        while(queue!=null){

            resultList.add(queue.get(0).getData());

            Node thisNode = queue.remove(0);

            if (thisNode.getLeft()!=null){
                queue.add(thisNode.getLeft());
            }
            if (thisNode.getRight()!=null){
                queue.add(thisNode.getRight());
            }
        }
        // 添加一个反转函数
        Collections.reverse(resultList);
        return resultList;
    }

    /**
     * 二叉树的右视图
     * 题目链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 【思路】：只取右边，注意队列移除的先后顺序
     * @param node
     * @return
     */
    public static List getRightSideView(Node node){
        if (node==null){
            return null;
        }
        List resultList = new ArrayList();
        List<Node> queue = new ArrayQueue(10);
        queue.add(node);
        // 注意，当list执行remove使size变为0时，不会判定为null，所以推荐使用queue!=null&&queue.size()>0或者!queue.isEmpty()
        while(!queue.isEmpty()){
            Node thisNode = queue.get(0);
            if (thisNode.getRight()!=null){
                queue.add(thisNode.getRight());
            }
            resultList.add(thisNode.getData());
            queue.remove(0);
        }
        return resultList;
    }

    /**
     * 637.二叉树的层平均值
     * 题目链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * 【思路】把每层节点求和，判断一层节点遍历完成后，计算平均值并存储
     * 【注意】在while循环里增加for循环，根据事先记录的队列长度进行循环累加，并在队列中增加下一层的节点（这时的队列只会访问到本层节点）
     * @param node
     * @return
     */
    public static Object[] getAverage(Node node){
        if(node==null){
            return null;
        }
        List resultList = new ArrayList();
        List<Node> queue = new ArrayQueue(10);
        queue.add(node);
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node thisNode = queue.get(0);
                sum += (int)thisNode.getData();
                if (thisNode.getLeft()!=null){
                    queue.add(thisNode.getLeft());
                }
                if (thisNode.getRight()!=null){
                    queue.add(thisNode.getRight());
                }
                queue.remove(0);
            }
            resultList.add(sum/size);
        }
        return resultList.toArray();
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.add(new Node(0));
        node.add(new Node(2));
        node.add(new Node(4));
        node.add(new Node(-1));
        node.add(new Node(3));
        //List returnList  = getRightSideView(node);
        System.out.println(Arrays.toString(getAverage(node)));
    }

}
