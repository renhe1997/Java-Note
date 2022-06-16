package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * ������ת
 * @Author: RenHe
 * @Date: 2021/3/23 14:41
 */
public class Inversion {
    /**
     * ȡtargetNode��1�ڵ㣬ȡ2�ڵ����ڣ���ת��21����headNode����headNode��¡��tempNode����ȡ3��ƴװ321�ŵ�headNode��ѭ����
     * @param targetNode
     * @return
     */
    public static NodeData getInversion(NodeData targetNode){
        NodeData headNode = new NodeData();
        NodeData nextNode = new NodeData();
        if (null!=targetNode&&targetNode.length(targetNode)>1){
            // ȡ 1
            headNode.setData(targetNode.getData());
        }
        while(null!=targetNode){
            //  ȡ1,�����=��ֻ�Ǹ�ֵ����������nodeָ��ͬһ����ַ���ں���ִ��setNextNode��ʱ��ͻ����ѭ����bug
            NodeData tempNode = headNode.clone();
//            nextNode = tempNode;
            if(null!=targetNode.getNextNode()){
                // ����2
                headNode = targetNode.getNextNode().clone();
                // ƴװ21
                headNode.setNextNode(tempNode);
                // �ƽ�ѭ��һ��targetNodeָ��3��
                targetNode = targetNode.getNextNode();
            }else{
                break;
            }
        }
        return headNode;
    }

    /**
     * ȡ
     * @param targetNode
     * @return
     */
    public static NodeData getInversion2(NodeData targetNode) {
        // ȡ 234
        NodeData current = targetNode.getNextNode();
        // ȡ 1
        targetNode.setNextNode(null);
        while(current != null) {
            // ȡ 34 ȡ4 ȡnull
            NodeData currentNext = current.getNextNode();
            // ƴװ 21 ƴװ321 ƴװ4321
            current.setNextNode(targetNode);
            // ��21��target ��321��target ��4321��target
            targetNode = current;
            // ��34��current ��4��current ��null��current
            current = currentNext;
        }
        return targetNode;
    }

    /**
     * �ݹ�ķ�������������
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
