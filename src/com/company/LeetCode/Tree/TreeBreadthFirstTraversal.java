package com.company.LeetCode.Tree;

import com.company.DataStructure.Tree.Node;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * �������-�������������
 * 102.�������Ĳ������
 * ��Ŀ��ַ��https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
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
        // ����һ������
        ArrayQueue<Node> queue = new ArrayQueue(10);
        queue.add(node);
        while (!queue.isEmpty()){
            // �ó���������ȡ��������
            Node root = queue.get(0);
            // ��ֵ
            resultList.add(root.getData());
            // �Ӷ�����ȡ��
            queue.remove(0);
            // ��������������
            if (root.getLeft()!=null){
                queue.add(root.getLeft());
            }
            // ��������������
            if (root.getRight()!=null){
                queue.add(root.getRight());
            }
        }
        System.out.println(resultList.toArray());
    }


    /**
     *  * 107.�������Ĳ�α��� II
     *  * ��Ŀ���ӣ�https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
     *  * ����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
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
        // ���һ����ת����
        Collections.reverse(resultList);
        return resultList;
    }

    /**
     * ������������ͼ
     * ��Ŀ���ӣ�https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * ����һ�ö������������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
     * ��˼·����ֻȡ�ұߣ�ע������Ƴ����Ⱥ�˳��
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
        // ע�⣬��listִ��removeʹsize��Ϊ0ʱ�������ж�Ϊnull�������Ƽ�ʹ��queue!=null&&queue.size()>0����!queue.isEmpty()
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
     * 637.�������Ĳ�ƽ��ֵ
     * ��Ŀ���ӣ�https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * ����һ���ǿն�����, ����һ����ÿ��ڵ�ƽ��ֵ��ɵ����顣
     * ��˼·����ÿ��ڵ���ͣ��ж�һ��ڵ������ɺ󣬼���ƽ��ֵ���洢
     * ��ע�⡿��whileѭ��������forѭ�����������ȼ�¼�Ķ��г��Ƚ���ѭ���ۼӣ����ڶ�����������һ��Ľڵ㣨��ʱ�Ķ���ֻ����ʵ�����ڵ㣩
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
