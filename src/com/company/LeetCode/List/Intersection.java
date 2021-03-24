package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * 链表相交
 * @Author: RenHe
 * @Date: 2021/3/18 20:25
 */
public class Intersection {
    /**
     * 求相交单向链表的第一个交点
     * 方法一： 先求a-b，同时向后移动指针，对比相同点
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static int getIntersection(NodeData nodeA, NodeData nodeB){
        NodeData A = nodeA;
        NodeData B = nodeB;
        // 相差节点数，定位到相同节点数
        int step = A.length(A)-B.length(B);
        if (A.length(A)-B.length(B)>0){
            while(step==0){
                step--;
                nodeA=nodeA.getNextNode();
            }
        }else{
            while(step==0){
                step++;
                nodeB=nodeB.getNextNode();
            }
        }
        // 此时的A，B链表指针后剩余节点数相同，循环对比
        while (null!=nodeA){
            if (nodeA.getData()==nodeB.getData()){
                break;
            }else{
                nodeA=nodeA.getNextNode();
                nodeB=nodeB.getNextNode();
            }
        }
        return nodeA.getData();
    }

    /**
     * 求单向链表的第一个交点
     * 方法二： a+(b-c)=b+(a-c)
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static int getIntersection2(NodeData nodeA, NodeData nodeB){
        // 判空
        if (null==nodeA||null==nodeB){
            return 0;
        }
        NodeData A = nodeA;
        NodeData B = nodeB;
        // 循环 a+(b-c)=b+(a-c)
        while (A.getData()!=B.getData()){
            A=A.getNextNode()==null?nodeB:A.getNextNode();
            B=B.getNextNode()==null?nodeA:B.getNextNode();
        }
        return A.getData();
    }

    /**
     * 判断链表是不是带环
     * A走一格，B走两格，如果最后A=B，则带环
     * @param nodeA
     * @return
     */
    public static Boolean isLoop(NodeData nodeA){
        // 判空
        Boolean isLoop = false;
        if (null==nodeA){
            return false;
        }
        NodeData A = nodeA.getNextNode();
        NodeData B = nodeA.getNextNode().getNextNode();
        while (A!=null&&B!=null){
            if(A==B){
                isLoop = true;
                break;
            }
            A = nodeA.getNextNode();
            B = B.getNextNode().getNextNode();
        }
        return isLoop;
    }




















    public static void main(String[] args) {
        NodeData A = new NodeData(2);
        NodeData A2 = new NodeData(1);
        NodeData A3 = new NodeData(4);
        A.setNextNode(A2);
        A2.setNextNode(A3);
        A3.setNextNode(new NodeData(3));
        System.out.println(A.toStingData(A));
        NodeData B = new NodeData(1);
        NodeData B2 = new NodeData(9);
        NodeData B3 = new NodeData(4);
        B.setNextNode(B2);
        B2.setNextNode(B3);
//        B3.setNextNode(B);// 首尾相连，循环
        System.out.println(B.toStingData(B));
        System.out.println("该链表是为否带环链表"+isLoop(B));
        System.out.println("相交节点数据为："+getIntersection2(A,B));

    }





















}
