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
                       // ...
                       // 文件解析
                       // ...
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
