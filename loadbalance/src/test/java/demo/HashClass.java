package demo;
 
import java.io.*;
/**
 * @description    大文件拆分小文件
 * 将文件中的信息当成我们文本中的每行文件，然后两个文件中分别是100条信息，然后进行读取  hash(url) %5
 **/
public class HashClass {
    public static void main(String[] args) throws IOException {
        //读取第一个文件     ooxx
        BufferedReader obr = new BufferedReader(new FileReader("/data/home/ooxx.txt"));
        BufferedWriter obw1 = new BufferedWriter(new FileWriter("/data/home/ooxx1.txt",true));
        BufferedWriter obw2 = new BufferedWriter(new FileWriter("/data/home/ooxx2.txt",true));
        BufferedWriter obw3 = new BufferedWriter(new FileWriter("/data/home/ooxx3.txt",true));
        BufferedWriter obw4 = new BufferedWriter(new FileWriter("/data/home/ooxx4.txt",true));
        BufferedWriter obw5 = new BufferedWriter(new FileWriter("/data/home/ooxx5.txt",true));
 
        String oline = "";
        while((oline = obr.readLine()) != null){
//            System.out.println(toHash(line));
//            System.out.println(oline);
            int x = toHash(oline);
            System.out.println(x);
            if (x == 0){
                obw1.write(oline);
                obw1.write("\r\n");
            }else if(x == -1){
                obw2.write(oline);
                obw2.write("\r\n");
            }else if(x == -2){
                obw3.write(oline);
                obw3.write("\r\n");
            }else if(x == -3){
                obw4.write(oline);
                obw4.write("\r\n");
            }else{
                obw5.write(oline);
                obw5.write("\r\n");
            }
        }
        obw1.close();
        obw2.close();
        obw3.close();
        obw4.close();
        obw5.close();
        obr.close();
 
        //读取第二个文件   xxoo
        BufferedReader xbr = new BufferedReader(new FileReader("/data/home/xxoo.txt"));
        BufferedWriter xbr1 = new BufferedWriter(new FileWriter("/data/home/xxoo1.txt",true));
        BufferedWriter xbr2 = new BufferedWriter(new FileWriter("/data/home/xxoo2.txt",true));
        BufferedWriter xbr3 = new BufferedWriter(new FileWriter("/data/home/xxoo3.txt",true));
        BufferedWriter xbr4 = new BufferedWriter(new FileWriter("/data/home/xxoo4.txt",true));
        BufferedWriter xbr5 = new BufferedWriter(new FileWriter("/data/home/xxoo5.txt",true));
 
        String xline = "";
        while((xline = xbr.readLine()) != null){
//            System.out.println(toHash(xline));
            int x = toHash(xline);
            if (x == 0){
                xbr1.write(xline);
                xbr1.write("\r\n");
            }else if(x == -1){
                xbr2.write(xline);
                xbr2.write("\r\n");
            }else if(x == -2){
                xbr3.write(xline);
                xbr3.write("\r\n");
            }else if(x == -3){
                xbr4.write(xline);
                xbr4.write("\r\n");
            }else{
                xbr5.write(xline);
                xbr5.write("\r\n");
            }
        }
 
        xbr1.close();
        xbr2.close();
        xbr3.close();
        xbr4.close();
        xbr5.close();
        xbr.close();
 
    }
 
    // 将字符串转成hash值
    public static int toHash(String key) {
        int arraySize = 5; // 数组大小一般取质数
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
            int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
            // 就代表a的值，同理b=2；
            hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
        }
        return hashCode;
    }
}