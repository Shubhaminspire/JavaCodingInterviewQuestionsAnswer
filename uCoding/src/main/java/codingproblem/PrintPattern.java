package codingproblem;

import com.github.dockerjava.api.model.Link;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintPattern {
    // shubhamhnj
    //output: s$ub$$am$$$nj
    public static void main(String[] args) {
        System.out.println(returnPattenString("shubhamhnj", 'h', "$"));
        Map<String, Integer> map = new HashMap<>();
        map.put("pulse",45);
        map.put("sugar",56);
        map.put("ginger",34);


        System.out.println(returnSortedMapReverse(map));
    }

    public static String returnChar(int count, String replaceChar) {
        String ch = "";
        int i = 0;
        while (i < count) {
            ch += replaceChar;
            i++;
        }

        return ch;

    }

    //publics sapient
    public static String returnPattenString(String name, char charToReplace, String replaceChar) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = name.length();
        int count = 1;
        for (int i = 0; i < size; i++) {
            char currentChar = name.charAt(i);
            if (currentChar == charToReplace) {
                stringBuilder.append(returnChar(count, replaceChar));
                count++;
            } else {
                stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString();
    }

    public static Map<String,Integer> returnSortedMapReverse(Map<String,Integer> map){
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(LinkedHashMap::new,(maps,entry)->maps.put(entry.getKey(),entry.getValue()),LinkedHashMap::putAll);
    }

}



