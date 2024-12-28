package codingproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FindSecondMaxElement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(55, 45, 58, 87,89,87)); //afer sort(45,)
        // first case with 2 elements = [55,45] after sorting [45,55] = list.get(list.size()-1)(2-1)(1)
        // second case with 3 elements = [55,45,58] after sorting [45,55,58] = list.get(list.size()-2) (3-2)(1)
        // second case with 4 elements = [55,45,58,87] after sorting [45,55,58,87] = list.get(list.size()-1)()
        System.out.println(returnSecondMaxElement(List.of(55, 45, 33, 67, 32, 33)));
        System.out.println(returnSecondLargestNumber(list));
    }

    public static int returnSecondMaxElement(List<Integer> list) {
        int largestNumber = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        System.out.println(largestNumber);
        for (int value : list) {
            if (value > largestNumber) {
                secondLargest = largestNumber;
                largestNumber = value;
            } else if (value > secondLargest && value != largestNumber) {
                secondLargest = value;

            }
        }
        return secondLargest;
    }

    public static int returnSecondLargestNumber(List<Integer> list) {

//        System.out.println("Sorted List: "+list);
//        Collections.reverse(list);
//        System.out.println("Reverse List: "+list);
//        Set<Integer> set = new LinkedHashSet<>(list);
//        System.out.println("Sorted Set: "+set);
//        List<Integer> list1 = null;
//        int secondLargest = 0;
//        if (set.size() >= 2) {
//            list1 = new ArrayList<>(set);
//            System.out.println("Sorted List after converting from set: "+list1);
//            secondLargest = list1.get(1);
//        }else{
//            throw new RuntimeException("Does not contain enough elements to find second largest element. Keep minimum 2 elements. But getting actual list size as "+set.size());
//        }
        LinkedHashSet<Integer> linkedHashSet = null;
        if (list.size() >= 2) {
            linkedHashSet = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        } else {
            throw new RuntimeException("Invalid size for the list. should be equal or greater than 2. But actual size is: " + list.size());
        }
        return linkedHashSet.stream().toList().get(1);
    }
}
