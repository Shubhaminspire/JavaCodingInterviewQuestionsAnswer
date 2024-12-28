package codingproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseListOfString {
    public static void main(String[] args) {
        List<String> list = List.of("Shubham", "Anish", "Anushhka", "Raghu");
        System.out.println("The List before Reverse: " + list);
        ReverseListOfString reverseListOfString = new ReverseListOfString();
        System.out.println("The List after Reverse: " + reverseListOfString.reverseListString(list));
        System.out.println(reverseListOfString.reverseString("Shubham"));

        System.out.println("The List1 after Reverse : " + reverseListOfString.reverseString1(list));
        System.out.println(reverseListOfString.reverseString3(list));
    }

    // using Stream with StringBuilder Inbuilt method
    //using stream streamBuilder
    public List<String> reverseListString(List<String> list) {
        return list.stream().map(x -> new StringBuilder(x).reverse().toString()).collect(Collectors.toList());
    }

    //using stream with specific method
    public List<String> reverseString1(List<String> list) {
        return list.parallelStream().map(x -> new ReverseListOfString().reverseString(x)).toList();
    }

    public String reverseString(String name) {

        String reverseString = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverseString += name.charAt(i);
        }
        return reverseString;
    }

    public List<String> reverseString3(List<String> list) {
        List<String> newList = new ArrayList<>();
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            newList.add(reverseString(list.get(i)));
        }
        return newList;
    }

}
