package automationProblems;

import java.util.*;

public class SortMap {
    private static Map<String, Integer> maps = new LinkedHashMap<>() ;

    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("Shubham", 874);
        maps.put("Anish", 564);
        maps.put("Rahul", 765);
        maps.put("Ayesha", 678);

        sortByKey(maps);

        Map<String, Integer> sortedmap = maps.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
//        System.out.println(sortedmap);

//        Map<String, Integer> newMap = new TreeMap<>(maps);
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        List<Integer> addvalues = new ArrayList<>();
        for (String values : maps.keySet()) {
            addvalues.add(maps.get(values));
        }

        List<Integer> sortListdesc = addvalues.stream().sorted(Comparator.reverseOrder()).toList();
        for (int n : sortListdesc) {
            for (String keys : maps.keySet()) {
                if (n == maps.get(keys)) {
                    sortMap.put(keys, maps.get(keys));
                    break;
                }
            }
        }
        System.out.println("The map sorted by Values in ascending order: "+sortMap);
    }

    public static void sortByKey(Map<String,Integer> map) {
        List<String> keys = new ArrayList<>();
        for(String key: map.keySet()){
            keys.add(key);
        }
        List<String> sortedList = keys.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedList);
        Map<String,Integer> maps = new LinkedHashMap<>();

        for(String list: sortedList){
            for(String key: map.keySet()){
                if(list.equals(key)){
                    int value = map.get(key);
                    maps.put(key,value);
                    break;
                }
            }
        }
        System.out.println("The map sorted by Keys is ascending order: "+ maps);
    }
}


