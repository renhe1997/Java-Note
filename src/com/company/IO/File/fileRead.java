package com.company.IO.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class fileRead {
    public static void main(String args[]){
        File file = new File("F:\\学习\\项目\\数据结构实例\\src\\com\\company\\IO\\File\\readTest.txt");
        if (file.exists()){
            System.out.println("读取成功");
            //文件读写对象
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int seq = 0;
                while (true){
                    seq++;
                    String line = reader.readLine();
                    if (line!=null){
                        Map dataMap = new HashMap();
                        System.out.println("483536******8027:"+line.indexOf("483536******8027"));
                        String queryId= line.substring(87,109).trim();//查询流水号
                        String orderId= line.substring(112,145).trim();//商户订单号
                        String txnAmt = line.substring(66,79).trim();//交易金额
                        String txnTime = line.substring(35,46).trim();
                        String acc = line.substring(46,65).trim();
                        String tradeTime = "";
                        if(null!=txnTime&&!"".equals(txnTime)){
                            tradeTime = txnTime.substring(4,10).trim().replace(":", "");
                        }
                        String txnType = line.substring(215, 217);//交易类型
                        dataMap.put("queryId",queryId);
                        dataMap.put("orderId",orderId);
                        dataMap.put("txnAmt",txnAmt);
                        dataMap.put("txnTime",txnTime);
                        dataMap.put("tradeTime",tradeTime);
                        dataMap.put("txnType",txnType);
                        dataMap.put("acc",acc);
                        System.out.println(dataMap);
                    }else if(line==null){
                        //如果line是null则说明文件已经读完了，否则就没有读完，所以推出循环
                        break;
                    }
                }
                System.out.println("共循环"+seq+"次");
            } catch (FileNotFoundException e) {
                System.out.println("文件找寻失败");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("文件读取失败");
                e.printStackTrace();
            }
        }
    }
}
