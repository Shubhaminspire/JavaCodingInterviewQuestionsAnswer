package coding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Automation {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Shubham", 512);
        map.put("Anish", 614);
        map.put("Rony", 896);
        map.put("Nancy", 544);
        map.put("Kittu", 954);
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(LinkedHashMap::new, (maps, entry) -> maps.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
        System.out.println(sortedMap);
    }
}
