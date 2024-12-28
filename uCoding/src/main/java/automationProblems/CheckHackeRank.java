package automationProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckHackeRank {
    public static void main(String[] args) {
        System.out.println(fizzBuzz());

    }

    public static int fizzBuzz() {
        // Write your code here
        // array 1 = {4,2,1,3,5}
        // array 2= {5,2,1}
        //output = 3
        // Find small no in array that not present in arrat 2


        int[] array1 = {4, 2, 1, 3, 5};
        int[] array2 = {5, 2, 1};

        Arrays.sort(array1);
        Set<Integer> set = new HashSet<>();
        for (int a : array2) {
            set.add(a);

        }

        for(int number :array1){
            if(!set.contains(number)){
                return number;
            }
        }
        return -1;
    }

}

