package automationProblems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterviewQuestion1 {
    public static void main(String[] args) {
        String value = "Hello";
        String value1 = "Hello World";
        //s1 is a part of s2 or not
//        isContain(value, value1);
        wordsNumberSC("123@#abc$%");
        countChar("Goodmorning");
        int[] number = new int[]{12, 43, 56, 78, 4, 45};

        for (int n : reverseArray(number)) {
            System.out.print(n + " ");
        }

        List<Integer> l1 = new ArrayList<>(List.of(23, 4, 5, 8, 34));
        List<Integer> l2 = new ArrayList<>(List.of(23, 5, 0, 4));
//        findUniqueFromTwoList(l1, l2);
//        findTheUnique(l1, l2);
        System.out.println();
        findUnique(l1, l2);
    }

    public static void isContain(String s1, String s2) {
        String regex = "(.*" + s1 + ".*)";

        if (s2.matches(regex)) {
            System.out.println(s1 + " is a part of " + s2 + ": " + true);
        } else {
            System.out.println(s1 + " is a part of " + s2 + ": " + false);
        }

    }

    public static void wordsNumberSC(String s) {
        String words = "[A-Za-z]";
        String number = "[0-9]";
        String specialChar = "[^A-Za-z0-9]";
        StringBuilder newWords = new StringBuilder();
        String newNumber = "";
        String specialChars = "";
//        Pattern pattern = Pattern.compile(words);
        Matcher matcher = Pattern.compile(words).matcher(s);
//        Pattern pattern1 = Pattern.compile(number);
        Matcher matcher1 = Pattern.compile(number).matcher(s);
//        Pattern pattern3 = Pattern.compile(specialChar);
        Matcher matcher2 = Pattern.compile(specialChar).matcher(s);
        while (matcher.find()) {
            newWords.append(matcher.group());
        }
        while (matcher1.find()) {
            newNumber += matcher1.group();
        }
        while (matcher2.find()) {
            specialChars += matcher2.group();
        }
        System.out.println(newWords);
        System.out.println(newNumber);
        System.out.println(specialChars);
    }

    public static void countChar(String value) {
        char[] ch = value.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char chs : ch) {
            map.put(chs, map.getOrDefault(chs, 0) + 1);
        }
        for (Map.Entry<Character, Integer> maps : map.entrySet()) {
            if (maps.getKey() == 'G' || maps.getKey() == 'o' || maps.getKey() == 'm') {
                System.out.println(maps.getKey() + ":" + maps.getValue());
            }

        }

    }

    public static int[] reverseArray(int[] array) {
        int[] newArray = new int[array.length];
        int index = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[index] = array[i];
            index++;
        }

        return newArray;
    }


    // 4,6,89,45,3
    // 6, 5,43, 67
    // 4,6,89,45,3,6, 5,43, 67
    //4

    // distinct [4,89,45,3]
    public static void findUniqueFromTwoList(List<Integer> list, List<Integer> list1) {
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = 0; j < list1.size(); j++) {
                if (list.get(i) == list1.get(j)) {
                    count++;
                }
            }
            if (count == 1) {
                l.add(list.get(i));
            }
        }
        for (Integer integer : list1) {
            int count = 1;
            for (Integer value : list) {
                if (integer == value) {
                    count++;
                }
            }
            if (count == 1) {
                l.add(integer);
            }
        }
        System.out.println();
        System.out.println(l);

    }

    public static void findTheUnique(List<Integer> list, List<Integer> list1) {
        Set<Integer> set = new HashSet<>();
        List<Integer> combineList = new ArrayList<>();
        List<Integer> uniqueList = new ArrayList<>();


        combineList.addAll(list);
        combineList.addAll(list1);

        for (int num : combineList) {
            if (Collections.frequency(combineList, num) == 1) {
                uniqueList.add(num);
            }
        }
        System.out.println();
        System.out.println(combineList);
        System.out.println(combineList.stream().distinct().toList());
        System.out.println(uniqueList);
    }

    public static void findUnique(List<Integer> list, List<Integer> list1) {
        List<Integer> combineList = new ArrayList<>();
        combineList.addAll(list);
        combineList.addAll(list1);
        List<Integer> uniqueList = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int key : combineList) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int keys : map.keySet()) {
            int value = map.get(keys);
            if (value == 1) {
                uniqueList.add(keys);
            }
        }
        System.out.println(uniqueList.stream().sorted(Collections.reverseOrder()).toList());

    }
}
