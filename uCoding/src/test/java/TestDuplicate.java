import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDistinct(List.of(23,22,7,8,7,22,50)));
    }

    public static List<Integer> containsDistinct(List<Integer> list){
        List<Integer> distinctList = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        for(int value:list){
            if(!distinctList.contains(value)){
                distinctList.add(value);
            } else{
                duplicateList.add(value);
            }
        }

        return  duplicateList;
    }

}
