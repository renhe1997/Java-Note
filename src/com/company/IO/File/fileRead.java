package com.company.IO.File;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class fileRead {
    public static void main(String args[]){
        File file = new File("F:\\ѧϰ\\��Ŀ\\���ݽṹʵ��\\src\\com\\company\\IO\\File\\readTest.txt");
        if (file.exists()){
            System.out.println("��ȡ�ɹ�");
            //�ļ���д����
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int seq = 0;
                while (true){
                    seq++;
                    String line = reader.readLine();
                    if (line!=null){
                        Map dataMap = new HashMap();
                        System.out.println("483536******8027:"+line.indexOf("483536******8027"));
                        String queryId= line.substring(87,109).trim();//��ѯ��ˮ��
                        String orderId= line.substring(112,145).trim();//�̻�������
                        String txnAmt = line.substring(66,79).trim();//���׽��
                        String txnTime = line.substring(35,46).trim();
                        String acc = line.substring(46,65).trim();
                        String tradeTime = "";
                        if(null!=txnTime&&!"".equals(txnTime)){
                            tradeTime = txnTime.substring(4,10).trim().replace(":", "");
                        }
                        String txnType = line.substring(215, 217);//��������
                        dataMap.put("queryId",queryId);
                        dataMap.put("orderId",orderId);
                        dataMap.put("txnAmt",txnAmt);
                        dataMap.put("txnTime",txnTime);
                        dataMap.put("tradeTime",tradeTime);
                        dataMap.put("txnType",txnType);
                        dataMap.put("acc",acc);
                        System.out.println(dataMap);
                    }else if(line==null){
                        //���line��null��˵���ļ��Ѿ������ˣ������û�ж��꣬�����Ƴ�ѭ��
                        break;
                    }
                }
                System.out.println("��ѭ��"+seq+"��");
            } catch (FileNotFoundException e) {
                System.out.println("�ļ���Ѱʧ��");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("�ļ���ȡʧ��");
                e.printStackTrace();
            }
        }
    }
}
