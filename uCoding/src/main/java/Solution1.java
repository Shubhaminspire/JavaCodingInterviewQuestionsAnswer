import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(containsDistinct(List.of(23, 22, 7, 8, 7, 22, 50, 22)));
         getNoOfOccurence(List.of("Shubham", "Sharma", "Anish", "Sharma", "shubham"));
        getNoOfOccurence("Shubhham");
    }

    public static List<Integer> containsDistinct(List<Integer> list) {
        List<Integer> distinctList = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        for (int value : list) {
            if (!distinctList.contains(value)) {
                distinctList.add(value);
            } else {
                if(!duplicateList.contains(value))
                duplicateList.add(value);
            }
        }

        return duplicateList;
    }

    // [2,5,6,8,8,5]
    // i = 0 ; size 6
    // 23, 22, 7, 8, 7, 22, 50 = size = 7
    public static void getNoOfOccurence(List<String> list) {
        int size = list.size();

        for (int i = 0; i < size; i++) {
            int count = 1; // Initialize count for each new element
            for (int j = i + 1; j < size; j++) { // Fix the bounds of the inner loop
                if (list.get(i).equalsIgnoreCase(list.get(j))) { // Use equals() for object comparison
                    count++;
                }
            }
            if (count > 1) {
                System.out.println("The element is: " + list.get(i) + " with count: " + count);
            }
//            else if (count == 1) { // Print count even if it's 1
//                System.out.println("The element is: " + list.get(i) + " with count: " + count);
//            }
        }
    }

    //shubham
    //7
    public static void getNoOfOccurence(String value) {
        int size = value.length();

        // Create an array to keep track of characters that have been counted
        boolean[] counted = new boolean[256]; // Assuming ASCII characters

        for (int i = 0; i < size; i++) {
            char charValue = value.charAt(i);
            // Check if the character has been counted already
            if (!counted[charValue]) {
                int count = 1;
                // Inner loop to count occurrences of the current character
                for (int j = i + 1; j < size; j++) {
                    if (charValue == value.charAt(j)) {
                        count++;
                    }
                }
                // Mark the character as counted
                counted[charValue] = true;
                // Print the count of the character
                System.out.println(charValue + ":" + count);

            }
        }
    }

}



