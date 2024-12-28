package codingproblem;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {
    public static void main(String[] args) {
        String number = "1634";
        checkArmstrongNumber(number);
    }

    public static void checkArmstrongNumber(String number) {
        char[] arr = number.toCharArray();
        int results = 0;
        List<Integer> list = new ArrayList<>();
        if (!number.matches("\\d+")) {
            throw new RuntimeException("Provide only number in String Value");
        } else {
            for (char c : arr) {
                 int val = (int) c - '0';
                // Adding the char of Integer into their original value. If we type the char c to int then it convert that single char value into ASCII Char val
                // which is 2 = 50, 3 = 51 for Example.
               // list.add(Character.getNumericValue(c));
                list.add(val);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            results += Math.pow(list.get(i), list.size());
        }
        System.out.println("The List after adding the number of String value is : " + list);
        if (Integer.parseInt(number) == results) {
            System.out.println("The Number " + number + " is the armstrong number");
        } else {
            System.out.println("The Number " + number + " is not the armstrong number");
        }
    }
}
