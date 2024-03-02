package codingproblem;

import java.util.ArrayList;
import java.util.List;

public class SwapTwoNumberUsingThirdVariable {
    static List<Integer> list = new ArrayList<>(List.of(12, 56));
    static int[] arr = {12, 56};

    public static void main(String[] args) {
        swapTwoNumbers(list);
        swapTwoNumbers(arr);
        SwapTwoNumberUsingThirdVariable swapNumbersWithoutTempVariable = new SwapTwoNumberUsingThirdVariable();
        swapNumbersWithoutTempVariable.swapNumbersWithoutTempVariable(45,56);
    }


    // Swap two numbers using third temp variable
    public static void swapTwoNumbers(int[] numbers) {
        // 32,34  = temp = 32, value[0] = 34, value[1] = 32
        int temp;
        int i = 0;
        System.out.println("The value before swap are: " + numbers[i] + " " + numbers[i + 1]);
        if (numbers.length != 2) {
            throw new RuntimeException("Length exactly be two only");
        } else {
            temp = numbers[i];
            numbers[i] = numbers[i + 1];
            numbers[i + 1] = temp;

        }
        System.out.println("The value after swap are: " + numbers[i] + " " + numbers[i + 1]);
    }

    public static void swapTwoNumbers(List<Integer> numbers) {
        // 32,34  = temp = 32, value[0] = 34, value[1] = 32
        // 3,2 {x,y} - x = x+y = 3+2 = 5
        // y = x - y = 5 - 2 = 3
        // x = x - y = 5 - 3 = 2
        int temp;
        int i = 0;
        System.out.println("The value before swap are: " + numbers);
        if (numbers.size() != 2) {
            throw new RuntimeException("Length exactly be two only");
        } else {
            temp = numbers.get(i);
            numbers.set(i, numbers.get(i + 1));
            numbers.set(i + 1, temp);

        }
        System.out.println("The value after swap are: " + numbers);
    }

    // Swap two numbers without using temp variable
    public void swapNumbersWithoutTempVariable(int x, int y) {
        System.out.println("The numbers before swap are: " + x + " and " + y);
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("The numbers after swap are: " + x + " and " + y);
    }

}
