package com.company.LeetCode.BaseData;

/**
 * 单链表节点，内部链表方法不适用于循环链表，否则内存溢出
 * @Author: RenHe
 * @Date: 2021/3/22 14:30
 */
public class NodeData {
    private int data;
    private NodeData nextNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeData getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeData nextNode) {
        this.nextNode = nextNode;
    }

    public NodeData(int data){
        this.data = data;
    }

    public NodeData(){}

    /**
     * 获取下标为point的节点
     * @param point
     * @param node
     * @return
     */
    public int getNodeByNum(int point,NodeData node){
        int i = 0;
        for(i= 0;i<point;i++){
            if (null!=node.getNextNode()){
                node = node.getNextNode();
            }else{
                break;
            }
        }
        return i;
    }

    /**
     * 将链表数据转为字符串
     * @param node
     * @return
     */
    public String toStingData(NodeData node){
        StringBuffer sb = new StringBuffer();
        while (null != node){
            sb.append(node.getData()).append(",");
            node = node.getNextNode();
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    public int length(){
        int length = 1;
        NodeData node = new NodeData();
        while (null != this.getNextNode()){
            length++;
           node = this.getNextNode();
        }
        return length;
    }
}

