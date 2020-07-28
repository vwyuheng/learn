package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
 
/**
 * @description   进行比较
 **/
public class HashClassEnd {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = null;
        HashSet<String> set = new HashSet<String>();
        String line = "";
 
        for (int j = 1; j < 6; j++) {
            String oPath = "d://ooxx" + j + ".txt";
            String xPath = "d://xxoo" + j + ".txt";
            br = new BufferedReader(new FileReader(oPath));
            while ((line = br.readLine()) != null){
                set.add(line);
            }
            br = new BufferedReader(new FileReader(xPath));
            while((line = br.readLine())  != null){
                if (set.contains(line)){
                    System.out.println(line);
                }
            }
        }
        br.close();
    }
}