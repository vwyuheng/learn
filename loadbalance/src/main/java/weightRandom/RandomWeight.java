package weightRandom;

import common.WeightServerMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomWeight {

    public static String testWeightRandom() {

        LinkedHashMap<String,Integer> serverWeithtMap = WeightServerMap.getMap();

        /**
         * 复制到本地线程栈
         */
        Map<String,Integer> serverMap = new LinkedHashMap<>();
        serverMap.putAll(serverWeithtMap);

        Set<String> keySets = serverMap.keySet();
        Iterator<String> iterator = keySets.iterator();

        /**
         * 按权重值数保存对应server的ip addr
         * 可重复
         */
        List<String> weightServerIpAddrLists = new ArrayList<>();

        while (iterator.hasNext()) {
            String serverIpAddr = iterator.next();
            Integer weight = serverMap.get(serverIpAddr);
            for (int i=0;i< weight;i++) {
                weightServerIpAddrLists.add(serverIpAddr);
            }

        }

        Random random = new Random();
        int randomPos = random.nextInt(weightServerIpAddrLists.size());
        String server = weightServerIpAddrLists.get(randomPos);

        int weight = serverMap.get(server);
        return server+" ,weight:"+weight;
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(RandomWeight.testWeightRandom());
            }
        };

       for (int i=0;i<100;i++) {
           Thread thread = new Thread(runnable);
           thread.start();
       }

    }
}
