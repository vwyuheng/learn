package common;

import java.util.LinkedHashMap;

/**
 * sqyu
 */
public class WeightServerMap {

    public static LinkedHashMap getMap() {
        LinkedHashMap<String, Integer> serverWeightMap = new LinkedHashMap();

        serverWeightMap.put("10.18.0.21", 1);
        serverWeightMap.put("192.168.0.22", 2);
        serverWeightMap.put("192.168.0.23", 1);
        serverWeightMap.put("172.168.0.24", 3);
        serverWeightMap.put("192.168.0.25", 4);
        serverWeightMap.put("192.168.0.26", 5);
        return serverWeightMap;

    }
}
