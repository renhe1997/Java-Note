package com.company.LeetCode.Tree;

import com.company.DataStructure.Tree.Node;

/**
 * �������-��������ǰ�к������
 * @Author: RenHe
 * @Date: 2021/8/12 15:08
 */
public class TreeDepthFirstTraversal {
    /**
     * �������
     * �ݹ���ã����Է��ʵ����ڵ�
     * @param root
     */
    public static void firstOrder(Node root){ //ȷ���ݹ麯���Ĳ����ͷ���ֵ
        if(root != null){ // ��ֹ����
            System.out.println(root.getData());
            firstOrder(root.getLeft()); // ȷ������ݹ���߼�
            firstOrder(root.getRight());
        }
    }
    //�������
    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }
    //�������
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
