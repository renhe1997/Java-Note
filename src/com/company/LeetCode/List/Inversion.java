package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * 单链表反转
 * @Author: RenHe
 * @Date: 2021/3/23 14:41
 */
public class Inversion {
    /**
     * 取targetNode的1节点，取2节点置于，反转成21置于headNode，将headNode克隆给tempNode，再取3，拼装321放到headNode，循环。
     * @param targetNode
     * @return
     */
    public static NodeData getInversion(NodeData targetNode){
        NodeData headNode = new NodeData();
        NodeData nextNode = new NodeData();
        if (null!=targetNode&&targetNode.length(targetNode)>1){
            // 取 1
            headNode.setData(targetNode.getData());
        }
        while(null!=targetNode){
            //  取1,这里的=不只是赋值，会让两个node指向同一个地址，在后面执行setNextNode的时候就会出现循环的bug
            NodeData tempNode = headNode.clone();
//            nextNode = tempNode;
            if(null!=targetNode.getNextNode()){
                // 落下2
                headNode = targetNode.getNextNode().clone();
                // 拼装21
                headNode.setNextNode(tempNode);
                // 推进循环一格，targetNode指向3？
                targetNode = targetNode.getNextNode();
            }else{
                break;
            }
        }
        return headNode;
    }

    /**
     * 取
     * @param targetNode
     * @return
     */
    public static NodeData getInversion2(NodeData targetNode) {
        // 取 234
        NodeData current = targetNode.getNextNode();
        // 取 1
        targetNode.setNextNode(null);
        while(current != null) {
            // 取 34 取4 取null
            NodeData currentNext = current.getNextNode();
            // 拼装 21 拼装321 拼装4321
            current.setNextNode(targetNode);
            // 放21到target 放321到target 放4321到target
            targetNode = current;
            // 放34到current 放4到current 放null到current
            current = currentNext;
        }
        return targetNode;
    }

    /**
     * 递归的方法解决这个问题
     * @param targetData
     * @return
     */
    public static NodeData getInversion3(NodeData targetData){
        if (null==targetData.getNextNode()){
            return targetData;
        }else{
            NodeData nextNode = targetData.getNextNode();
            targetData.setNextNode(null);
            NodeData result =  getInversion3(nextNode);
            nextNode.setNextNode(targetData);
            return result;
        }
    }

    public static void main(String[] args) {
        NodeData A = new NodeData(1);
        NodeData A2 = new NodeData(2);
        NodeData A3 = new NodeData(3);
        A.setNextNode(A2);
        A2.setNextNode(A3);
        A3.setNextNode(new NodeData(4));
        System.out.println(A.toStingData(A));
//        NodeData inversion = getInversion(A);
//        NodeData inversion = getInversion2(A);
        NodeData inversion = getInversion3(A);
        System.out.println(inversion.toStingData(inversion));
    }
}
