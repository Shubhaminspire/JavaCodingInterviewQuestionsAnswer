package codingproblem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sortBasedOnCondition {
    public static void main(String[] args) {
        List<String> lists = List.of("Shubham","Anish","Kits","Shubham","Akash","Kits","Shubham");
//        System.out.println(new sortBasedOnCondition().returnSortedList();
//new sortBasedOnCondition().returnSortedList(List.of("Shubham","Anish","Kits","Shubham","Akash","Kits","Shubham"));
        Map<String, Long> frequencyList = lists.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(lists.stream().sorted(Comparator.comparingLong(frequencyList::get).reversed()).toList());



//      List<String> sortedString =  values.stream().distinct().sorted(Comparator.comparingLong(frequencyList::get).thenComparingInt(String::length).thenComparing(Function.identity())).collect(Collectors.toList());
//        System.out.println(sortedList);
        Comparator<String> customComparator = Comparator.<String>comparingLong(frequencyList::get).reversed().thenComparingInt(String::length).thenComparing(Comparator.naturalOrder());
        List<String> sortedString = lists.stream().distinct().sorted(customComparator).toList();
        System.out.println(sortedString);

    }
}
