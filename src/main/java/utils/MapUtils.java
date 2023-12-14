package utils;

import java.util.*;

public class MapUtils {
    // Map에서 최소 value 출력
    public static <K, V extends Comparable<? super V>> V getMinValue(Map<K, V> map) {
        return Collections.min(map.values());
    }

    // Map에서 특정 value에 해당하는 키들 출력
    public static <K, V> List<K> getKeysForValue(Map<K, V> map, V value) {
        List<K> keys = new ArrayList<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static int getTotalNumber(LinkedHashMap<String, Integer> nameNumber) {
        int totalNumber = 0;

        for (int value : nameNumber.values()) {
            totalNumber += value;
        }

        return totalNumber;
    }
}
