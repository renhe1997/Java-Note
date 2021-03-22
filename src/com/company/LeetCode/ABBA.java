package com.company.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: RenHe
 * @Date: 2020/11/23 13:36
 */
public class ABBA {
    public static void main(String[] args) {
        List<Map<String,Object>> beforeMoveList = new ArrayList<>();

        for (int i=0;i<10;i++){
            Map map = new HashMap();
            map.put("ORGAN1",1*i);
            map.put("ORGAN2",2*i);
            beforeMoveList.add(map);
        }
        for (int i=0;i<10;i++){
            Map map = new HashMap();
            map.put("ORGAN1",2*i);
            map.put("ORGAN2",1*i);
            beforeMoveList.add(map);
        }
        System.out.print(beforeMoveList);
        List<Map<String,Object>> afterRemoveList = new ArrayList(beforeMoveList);
        if(beforeMoveList != null){
            for (int i=0;i<beforeMoveList.size();i++){
                String organ1 = String.valueOf(beforeMoveList.get(i).get("ORGAN1"));
                String organ2 = String.valueOf(beforeMoveList.get(i).get("ORGAN2"));
                for(int j= i;j<beforeMoveList.size();j++){
                    String otherOrgan1 = String.valueOf(beforeMoveList.get(j).get("ORGAN1"));
                    String otherOrgan2 = String.valueOf(beforeMoveList.get(j).get("ORGAN2"));
                    if (organ1.equals(otherOrgan2)&&organ2.equals((otherOrgan1))){
                        StringBuffer logStr = new StringBuffer();
                        logStr.append(organ1+","+organ2+"��ͬ"+otherOrgan1+","+otherOrgan2);
                        //before���ڶԱ�,after�����޸�
                        logStr.append("ɾ����"+j+"������"+beforeMoveList.get(j).get("ORGAN1")+beforeMoveList.get(j).get("ORGAN2"));
                        afterRemoveList.remove(beforeMoveList.get(j));
                        logStr.append("ɾ����ʣ"+afterRemoveList.size()+"��");
                        System.out.println(logStr);
                        //�������ͬ�ģ�ȥ������Ҫ������ѭ��
                        break;
                    }
                }
            }
        }
        System.out.println(afterRemoveList);
    }
}
