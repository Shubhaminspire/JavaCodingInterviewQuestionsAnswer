package codingproblem;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) throws Exception {
        char[] chars = {'d', 'r', 'h', 'j'};

        System.out.println(sortString("shubham".toCharArray()));
//        System.out.println(so);
        System.out.println(isAnagram("shubham", "bhahmus"));
        Map<String, Integer> map = new HashMap<>();
        map.put("Shubham", 1);
        map.put("Akash", 56);
        map.put("Rahul", 34);
//        sortMap(map);
        sortMaps(map).forEach((key,value)->{
            System.out.println(key+" "+value);
        });
    }

    public static String sortString(char[] chars) {


        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }

    public static boolean isAnagram(String first, String second) throws Exception {
        char[] char1 = first.toCharArray();
        char[] char2 = second.toCharArray();
        boolean isAnagram = false;
        String firstValue = sortString(char1).toLowerCase();
        String secondValue = sortString(char2).toLowerCase();
        if (firstValue.length() == secondValue.length()) {
            if (firstValue.equals(secondValue)) {
                return true;
            }
        } else {
            throw new Exception("Length is not match");
        }
        System.out.println(firstValue + ":" + secondValue);
        return isAnagram;

    }

    public static void sortMap(Map<String, Long> map) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Long> maps : map.entrySet()) {
            list.add(maps.getKey());
        }

        System.out.println(list.stream().sorted(Comparator.comparing(map::get)).toList());


    }

    public static Map<String, Integer> sortMaps(Map<String, Integer> map) {
      return  map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(LinkedHashMap::new,(maps,entry)->
                maps.put(entry.getKey(),entry.getValue()),LinkedHashMap::putAll);







    }
}
