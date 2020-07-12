package weightRoundrobin;

import common.WeightServerMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RoundRoubin {

    static Integer pos = 0;

    public static String testRoundRobin() {

        LinkedHashMap<String,Integer> serverWeithtMap = WeightServerMap.getMap();

        Map<String,Integer> copyLocalThreadMap = new LinkedHashMap();
        copyLocalThreadMap.putAll(serverWeithtMap);

        Set<String> stringSet = copyLocalThreadMap.keySet();

        Iterator iterator = stringSet.iterator();

        List<String> listAddr = new ArrayList<>();

        while (iterator.hasNext()) {
            String ipAddr = (String) iterator.next();
            int weightVal = copyLocalThreadMap.get(ipAddr);
            /**
             * 根据权重放对应的ip
             * list允许重复
             */
            for (int i=0;i<weightVal;i++) {
                listAddr.add(ipAddr);
            }
        }


        /**
         * strategy 实现
         */


        String serverIpAddr = "";

        synchronized (pos) {
            if (pos>=listAddr.size()) {
                pos=0;
            }
            serverIpAddr = listAddr.get(pos);
            //必须在list get下面
            pos++;
        }

        int weightVal = copyLocalThreadMap.get(serverIpAddr);
      return serverIpAddr+",weigth:"+weightVal;

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(RoundRoubin.testRoundRobin());
            }
        };

        for (int i=0;i<100;i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            }
        }


}
