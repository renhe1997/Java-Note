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
                        logStr.append(organ1+","+organ2+"相同"+otherOrgan1+","+otherOrgan2);
                        //before用于对比,after用于修改
                        logStr.append("删除第"+j+"行数据"+beforeMoveList.get(j).get("ORGAN1")+beforeMoveList.get(j).get("ORGAN2"));
                        afterRemoveList.remove(beforeMoveList.get(j));
                        logStr.append("删除后还剩"+afterRemoveList.size()+"行");
                        System.out.println(logStr);
                        //如果有相同的，去除后不需要再向下循环
                        break;
                    }
                }
            }
        }
        System.out.println(afterRemoveList);
    }
}
