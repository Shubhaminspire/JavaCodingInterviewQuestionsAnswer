package codingproblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IBMCode {
    public static void main(String[] args) {
        System.out.println(returnMaxOccurence("This is the main culprit of is this game and is union. is this is good"));
        System.out.println(returnMaxCountChars("shubbham"));
//        System.out.println(generateRandomString(6));
        generateRandomStrings(6);
        System.out.println(generateRandom(25));
        findLongSubstring("shubham");
    }


    // This is the main culprit of is this game and is union. is this is good
    // find the string with maximum occurence
    public static String returnMaxOccurence(String string) {
        List<String> list = new ArrayList<>();
        String newStr = string.replaceAll("[.]", "").trim();
        System.out.println("The newStr is: " + newStr);
        String[] val = newStr.split(" ");
        for (String value : val) {
            list.add(value);

        }
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        String newString = "";
        long count = 0;
        for (Map.Entry<String, Long> maps : map.entrySet()) {
            if (maps.getValue() > count) {
                newString = maps.getKey();
                count = maps.getValue();
            }
        }
        return newString + " " + count;
    }

    public static String returnMaxCountChars(String name) {
        char[] ch = name.toCharArray();
        StringBuilder str = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char chs : ch) {
            map.put(chs, map.getOrDefault(chs, 0) + 1);
        }

        for (char chars : map.keySet()) {
            if (map.get(chars) > 1) {
                str.append(chars);
            }
        }
        return str.toString();
    }

    public static String generateRandomString(int size) {
        String str = "[a-z]";
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(str);
        Random random = new Random();
        while (stringBuilder.length() <= size) {
            char ch = (char) random.nextInt((127 - 32) + 32);

            Matcher matcher = pattern.matcher(String.valueOf(ch));
            if (matcher.matches()) {
                stringBuilder.append(matcher.group());
            }

        }
        return stringBuilder.toString();

    }

    public static void generateRandomStrings(int size) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String name = "";
//        StringBuilder stringBuilder = new StringBuilder();
//        char[] charArray = str.toCharArray();
//        Random random = new Random();
//        while(name.length() < size) {
//            int randomNumber = random.nextInt(size);
//            char currentChar = str.charAt(randomNumber);
//            name+=String.valueOf(currentChar);
//        }
        List<Character> list = new ArrayList<>();
        List<Character> newList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        Random random = new Random();
        Set<Character> characters = new HashSet<>();
        while (characters.size() != size) {
            int number = random.nextInt(str.length());
            char currChar = str.charAt(number);
            characters.add(currChar);
        }
        List<Character> chars = characters.stream().toList();
        for (char c : chars) {
            name += c;
        }
        System.out.println(name);
    }

    public static String generateRandom(int size) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        String newStr = "";
        Random random = new Random();
        while (newStr.length() < size) {
            int randomNumber = random.nextInt(str.length());
            if (newStr.length() == 0) {
                newStr += str.charAt(randomNumber);
            }
            if (newStr.length() != size) {
                char currentChar = str.charAt(randomNumber);
                if (currentChar != newStr.charAt(newStr.length() - 1)) {
                    newStr += currentChar;
                }
            }
        }
        return newStr;
    }


    // sjionhtry
    // 0 < 1 && j != s
    // 2
    public static void findLongSubstring(String string) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, i);
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                end = i;
            }

        }
        String maxSubString = string.substring(start, end + 1);

        System.out.println("Max length of substring with non-repetitive characters: " + maxLength);
        System.out.println("Substring: " + maxSubString);


    }

}
