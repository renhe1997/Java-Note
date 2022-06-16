package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * 19.删除链表的倒数第N个节点
 * @Author: RenHe
 * @Date: 2021/5/31 15:32
 */
public class RemoveNthFromEnd {
    static class Nodes{
        private Nodes nextNode;
        private int data;
        public int getData() {
            return data;
        }
        public Nodes getNextNode() {
            return nextNode;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setNextNode(Nodes nextNode) {
            this.nextNode = nextNode;
        }
        public Nodes(){};
        public Nodes(int data,Nodes nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }


    }
    static Nodes head = new Nodes();
    static Nodes current = new Nodes();
    static void add(int data){
        if (null==head.getNextNode()){
            head.setData(data);
            head.setNextNode(new Nodes());
            current = head;
        }else{
            current.setNextNode(new Nodes(data,null));
            current = current.getNextNode();
        }
    }
    public static String toStingData(Nodes node){
        StringBuffer sb = new StringBuffer();
        while (null != node){
            sb.append(node.getData()).append(",");
            node = node.getNextNode();
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            add(i);
        }
        System.out.println(toStingData(removeNthFromEnd(3)));
    }

    /**
     * 这个问题的关键在于，怎么找到倒数第N个节点
     * 用双指针，快的先走N步，此时快慢指针相聚N个距离，之后快慢一起一步步走，直到快的到达终点
     * 这时候慢的距离终点为N
     * @param n
     * @return
     */
    public static Nodes removeNthFromEnd(int n){
        Nodes dummyNode = new Nodes(-1,head);
        Nodes fastNode = dummyNode;
        Nodes slowNode = dummyNode;
        for (int i = 0; i < n+1; i++) {
            fastNode = fastNode.getNextNode();
        }
        Nodes priNode = null;
        while (fastNode.getNextNode()!=null){
            priNode = slowNode;
            fastNode = fastNode.getNextNode();
            slowNode = slowNode.getNextNode();
        }
        priNode.setNextNode(slowNode.getNextNode());
        return dummyNode.getNextNode();
    }








    public static Nodes removeNthFromEnd2(int n){
        Nodes dummyNode = new Nodes(-1,head);
        Nodes fastNode  = dummyNode;
        Nodes slowNode  = dummyNode;

        for (int i = 0; i < n+1; i++) {
            if (null != fastNode.getNextNode()) {
                fastNode = fastNode.getNextNode();
            }else{
                System.out.println("请输入正确的n");
                break;
            }
        }
        Nodes priNode = null;
        while (null!=fastNode){
            priNode = slowNode;
            fastNode = fastNode.getNextNode();
            slowNode = slowNode.getNextNode();
        }
        priNode.setNextNode(slowNode.getNextNode());
        return dummyNode.getNextNode();
    }



}























