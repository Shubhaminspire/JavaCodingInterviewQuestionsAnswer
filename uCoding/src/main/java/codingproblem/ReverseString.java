package codingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseString {
    public static String value = "shubham";

    public static void main(String[] args) {
        System.out.println("The reverse string without inbuilt method is: " + reverseString(value));
        System.out.println("The reverse string with inbuilt method is: " + reverseValueWithInbuiltMethod(value));
        System.out.println("The reverse string using charArray: " + reverseWithCharArray(value));

        System.out.println(reverseWithList(value));

    }

    // Using without reverse inbuilt Method
    private static String reverseString(String value) {
        String reverseValue = "";
        int length = value.length();
        if (value.length() == 1) {
            reverseValue = value;
        } else if (value.length() > 1) {
            for (int i = length - 1; i >= 0; i--) {
                reverseValue = reverseValue + value.charAt(i);
            }
        } else {
            throw new RuntimeException("Value can not be empty");
        }
        return reverseValue;
    }

    // Using with reverse inbuilt Method

    private static String reverseValueWithInbuiltMethod(String value) {
        StringBuilder stringBuilder = new StringBuilder(value);
        return stringBuilder.reverse().toString();
    }

    // Reverse using toCharArray
    private static String reverseWithCharArray(String value) {
        String reverseValue = "";
        char[] ch = value.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            reverseValue += ch[i];
        }
        return reverseValue;

    }

    private static String reverseWithList(String value) {
        char[] ch = value.toCharArray();
        int length = ch.length;
        String reverseValue = "";
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            characterList.add(ch[i]);
        }
        Collections.reverse(characterList);
        String newString = characterList.toString().replaceAll("[^\\w]","");
        return newString;

    }
}
