package codingproblem;

import java.util.*;

public class SortArrayWithoutDirectMethod {
    public static void main(String[] args) {
//        int[] array = {67, 10, 5, 76};
//        int[] sorted = sortArray(array);
//        for (int value : sorted) {
//            System.out.print(value + " ");
//        }
        Map<Integer,String> map = new HashMap<>();
        map.put(456,"Pulse");
        map.put(35,"Sugar");
        map.put(500,"Amla");
        sortByPrice(map);
    }

    public static int[] sortArray(int[] arr) {
        int length = arr.length;
        int temp;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void sortByPrice(Map<Integer,String> map){

        List<Integer> list = new ArrayList<>();
        for(int key:map.keySet()){
            list.add(key);
        }
       List<Integer> lists = list.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println(lists);
        //[456,100,53]
       // [Banana{key}=100{value},"Apple{key}456{value}","orange{key}35{value}"]


        for(int val:lists){
            System.out.println(map.get(val)+":"+val);
        }






    }
}
