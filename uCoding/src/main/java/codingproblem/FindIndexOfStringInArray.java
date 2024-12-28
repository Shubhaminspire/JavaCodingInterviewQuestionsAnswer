package codingproblem;

import java.util.*;

public class FindIndexOfStringInArray {
    static String[] names = {"Shubham", "Sharma", "Anish", "Raghav", "Raghav"};
    static List<String> list1 = new ArrayList<>(List.of("Shubham", "Sharma", "Anish", "Raghav", "Raghav"));
    static List<String> list2 = new ArrayList<>(List.of( "Kiran","Sharma"));

    public static void main(String[] args) {
        String name = "Raghav";
//        System.out.println("The name " + name + " found on the index: " + returnIndexOfString(names, name));
//        returnIndexOfString("Raghav", names);
        FindIndexOfStringInArray findIndexOfStringInArray = new FindIndexOfStringInArray();
        findIndexOfStringInArray.printMatchValueFromTwoArray(list1,list2,name);
    }

    private static int returnIndexOfString(String[] names, String name) {
        int index = -1;
        Set<String> set = new LinkedHashSet<>(Arrays.asList(names));
        List<String> list = set.stream().toList();
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                index = list.indexOf(name);
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException("The String " + name + " is not found in the given array");
        }
        return index;
    }

    // Print all the index of the given Match String, if the array contain duplicates value
    public static void returnIndexOfString(String name, String[] names) {
        int index = -1;
        List<String> list = new ArrayList<>(Arrays.asList(names));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)) {
                index = i;
                System.out.println("The index of name " + name + " is: " + index);
            }
        }
        if (index == -1) {
            throw new RuntimeException("The String " + name + " is not found in the given array");
        }

    }

    // Write a Program to print the matches Value from 2 arrays
    public void printMatchValueFromTwoArray(List<String> list1, List<String> list2, String valueToMatch) {
        int sizeList1 = list1.size();
        int sizeList2 = list2.size();
        boolean isMatch = false;
        for (int i = 0; i < sizeList1; i++) {
            for (int j = 0; j < sizeList2; j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    System.out.println("The Match Value from both array is: " + list1.get(i));
                    System.out.println("Index from List1 is: " + i + " .Index from List2 is: " + j);
                    isMatch = true;
                }
            }
        }
        if (!isMatch) {
            System.out.println("Not Matched any String");
        }
    }
}
