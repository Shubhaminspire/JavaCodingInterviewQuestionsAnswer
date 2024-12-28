package metaPractiseCode;

import java.util.*;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] newArray = {-5, 1, -2, 3, -1, 2};
        List<Integer> ag = new ArrayList<>(List.of(4,6,7,89,5));

      // convert List to array
      int[] newArrays = ag.stream().mapToInt(Integer::intValue).toArray();
      // convert from array to list
        List<Integer> newL = Arrays.stream(arr).boxed().toList();
        int number = maxSubArraySum(arr);
        System.out.println("Maximum sum of subarray: " + number);

        int val = findMaxLength(newArray);
        System.out.println("Max length subarray gives sum 0: " + val);
    }

    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                System.out.println(arr[i]);
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        if (maxSoFar < 0) {
            return 0;
        } else {
            return maxSoFar;
        }
    }

    //-5, 1, -2, 3, -1, 2

    public static int findMaxLength(int[] array) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new LinkedHashMap<>();
        sumMap.put(0, -1); // initialize with 0 sum at index -1

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (sumMap.containsKey(currentSum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum));
            } else {
                sumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
}
