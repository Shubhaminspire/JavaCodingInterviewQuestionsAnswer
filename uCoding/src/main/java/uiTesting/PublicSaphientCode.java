package uiTesting;

import java.util.*;
import java.util.stream.Collectors;

public class PublicSaphientCode {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> maps = new HashMap<>() {{
            put(1, "Shubham");
            put(2, "Anish");
            put(3, "Kiru");
            put(4, "Raj");
        }};
        List<Integer> list = new ArrayList<>(List.of(45, 76, 89, 54, 65, 54));

        String[] names = {"Shubham", "Anish", "Jenny", "Shubham", "Jay", "Sharma", "Anish"};
        List<String> list1 = new ArrayList<>(Arrays.asList(names));
//        commonArrayBetweenTwoArrayList(List.of("Shubham", "Akash", "Neha"), List.of("Anish", "Rahul", "Akiriti", "Neha", "Shubham"));
//        fetchValueUsingKey(maps, 3);
//        printHighestAndSecondHighest(List.of(45, 76, 89, 54, 65, 54));
//        countOccurenceOfElements(names);
//        countOccurenceOfElements(List.of("Shubham", "Akash", "Neha", "Neha", "Akash", "Neha"));
//        countOccurenceOfElement(List.of("Shubham", "Akash", "Neha", "Neha", "Akash", "Neha"));
//        sortEvenNumberOnlys(list);
//        sortEvenNumberOnl(list);

//        System.out.println(isSorted(list));
        System.out.println(isSort(list));
        isStringListSorted(list1);
    }

    public static void commonArrayBetweenTwoArrayList(List<String> list1, List<String> list2) {
        int size1 = list1.size();
        int size2 = list2.size();

        for (int i = 0; i < size1; i++) {
            int count = 1;
            for (int j = 0; j < size2; j++) {
                if (list1.get(i).equalsIgnoreCase(list2.get(j))) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println(list1.get(i) + ":" + count);
            }
        }

    }

    public static void fetchValueUsingKey(Map<Integer, String> map, int key) throws Exception {

        if (map.containsKey(key)) {
            System.out.println("Key is: " + key + ". Value is: " + map.get(key));
        } else {
            throw new Exception("The Key " + key + " is not present in map.");
        }

    }

    public static void printHighestAndSecondHighest(List<Integer> list) {
        int firstHighestNumber = Integer.MIN_VALUE;
        int secondHighestNumber = Integer.MIN_VALUE;
        for (int value : list) {
            if (value > firstHighestNumber) {
                secondHighestNumber = firstHighestNumber;
                firstHighestNumber = value;
            }
            if (value > secondHighestNumber && value != firstHighestNumber) {
                secondHighestNumber = value;
            }
        }
        System.out.println(secondHighestNumber);
    }

    public static void countOccurenceOfElements(String[] element) {
        int size = element.length;
        int[] counts = new int[element.length];
        boolean[] counted = new boolean[element.length];
        for (int i = 0; i < size - 1; i++) {
            if (counted[i]) {
                continue;
            }
            String currenValue = element[i];
            int count = 1;
            for (int j = i + 1; j < size; j++) {
                if (currenValue.equalsIgnoreCase(element[j])) {
                    count++;
                    counted[j] = true;
                }
            }
            counts[i] = count;
        }
        for (int i = 0; i < size; i++) {
            if (!counted[i]) {
                System.out.println(element[i] + ":" + counts[i]);
            }
        }
    }

    public static void countOccurenceOfElements(List<String> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

    }

    public static void countOccurenceOfElement(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : list) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        System.out.println(map);
    }

    public static void sortEvenNumberOnly(List<Integer> list) {
        List<Integer> lists = list.stream().filter(x -> x % 2 == 0).sorted().toList();
        System.out.println(lists);


    }

    public static void sortEvenNumberOnlys(List<Integer> list) {

        List<Integer> evenNumber = new ArrayList<>();
        for (int number : list) {
            if (number % 2 == 0) {
                evenNumber.add(number);
            }
        }
        Collections.sort(evenNumber);
        System.out.println("Even Number Size:" + evenNumber.size());
        int evenIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, evenNumber.get(evenIndex));
                evenIndex++;
            }
        }
        System.out.println("Actual List Size:" + list.size());
        int difference = list.size() - evenNumber.size();
        System.out.println("Difference in Size: " + difference);
        System.out.println(list);
    }

    public static void sortEvenNumberOnl(List<Integer> list) {
        int listSize = list.size();
        List<Integer> evenNumber = new ArrayList<>();
        List<Integer> oddNumber = new ArrayList<>();
        for (int number : list) {
            if (number % 2 == 0) {
                evenNumber.add(number);

            } else {
                oddNumber.add(number);
            }
        }

        Collections.sort(evenNumber);
        Collections.sort(oddNumber);

        evenNumber.addAll(oddNumber);
        System.out.println(evenNumber);


    }

    // Program to check the sorted list

    public static boolean isSorted(List<Integer> list) {
        List<Integer> lists = new ArrayList<>();
        lists.addAll(list);
        Collections.sort(list);
        System.out.println("Original list:" + lists);
        System.out.println("Sorted List: " + list);

        if (lists.equals(list)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isSort(List<Integer> list) throws Exception {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        Collections.sort(newList);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
        System.out.println(newList);
        System.out.println(list);
        boolean isSorted = true;
        if (list.size() == newList.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != newList.get(i)) {
                    isSorted = false;
                    break;
                }

            }
        } else {
            throw new Exception("Invalid Size");
        }

        return isSorted;


//        if (newList.toString().equals(list.toString())) {
//            return true;
//        } else {
//            return false;
//        }

    }

    public static void isStringListSorted(List<String> list) {
        List<String> list1 = new ArrayList<>(list);
        //sort original List using for loop

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }

        }
        System.out.println("The original String List is: "+list1);
        System.out.println("The Sorted List String is: "+list);
    }

}




