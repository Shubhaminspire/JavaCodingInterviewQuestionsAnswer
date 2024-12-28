package automationProblems;

import java.util.HashMap;
import java.util.Map;

public class CountMaxCharInString {
    public static void main(String[] args) {
        String value = "This is the best time   to deal with every customer";
        countMaxCharAndCount(value);
        countMaxChar(value);
    }

    public static void countMaxCharAndCount(String value) {
        String regex = "[\\s+]";
        String newString = "";
        newString = value.replaceAll(regex, "");
        String maxOccurenceChar = "";
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : newString.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> maps : map.entrySet()) {
            if (maps.getValue() > count) {
                maxOccurenceChar = String.valueOf(maps.getKey());
                count = maps.getValue();
            }
        }
        System.out.println(maxOccurenceChar + ":" + count);
    }

    public static void countMaxChar(String value) {
        String newString = value.replaceAll("[\\s+]", "");
        boolean[] charCount = new boolean[256];
        int maxCount = 0;
        char ch = '\0';
        for (int i = 0; i < newString.length(); i++) {
            char currentChar = newString.charAt(i);

            if (!charCount[currentChar]) {
                int count = 1;
                for (int j = i + 1; j < newString.length(); j++) {
                    if (currentChar == newString.charAt(j)) {
                        count++;
                    }
                }
                charCount[currentChar] = true;
                System.out.print(currentChar+":"+count+" ");
                if (count > maxCount){
                    maxCount = count;
                    ch = currentChar;
                }
            }
        }
        System.out.println();
        System.out.println(ch+":"+ maxCount);
    }

}
