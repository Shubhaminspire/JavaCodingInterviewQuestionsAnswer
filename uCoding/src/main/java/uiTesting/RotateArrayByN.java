package uiTesting;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArrayByN {
    public static void main(String[] args) {
        int[] array = {2, 4, 5, 9, 1};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no of times you want to rotate array: ");
        int noOfTimes = scanner.nextInt();
        System.out.println();
        rotate(array,noOfTimes);
        System.out.println(Arrays.toString(array));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] arr, int k) {
        int leng = arr.length;

        k = k % leng;

        reverse(arr,0,leng-1);
        reverse(arr,0,k-1);
        reverse(arr,k,leng-1);
    }


}
