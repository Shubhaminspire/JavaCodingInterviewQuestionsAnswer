package uiTesting;

import java.util.*;

public class SortWordBasedOnLength {
    public static Map<String, List<Integer>> map = new LinkedHashMap<>();
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String val = "Tomorrow is holiday since it is Sunday";
        String[] word = val.trim().split(" ");
        for (String w : word) {
            int size = w.length();
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(size);
        }

//        for (String key : map.keySet()) {
//            System.out.println(key + ":" + map.get(key));
//        }
        List<Map.Entry<String, List<Integer>>> entries = new ArrayList<>(map.entrySet());

        entries.sort(Comparator.comparingInt(e -> e.getValue().get(0)));

        for (Map.Entry<String, List<Integer>> entry : entries) {
            for (Integer i : entry.getValue()) {
                System.out.print(entry.getKey()+" ");

            }
        }
    }


}
