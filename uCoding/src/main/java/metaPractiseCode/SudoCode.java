package metaPractiseCode;

import java.util.ArrayList;
import java.util.List;

public class SudoCode {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(12, 24, 56));
        List<Integer> b = new ArrayList<>(List.of(10, 24, 54));
        System.out.println(compareTriplets(a, b));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aPoint = 0;
        int bPoint = 0;
        List<Integer> newList = new ArrayList<>();

        if (a.size() == b.size()) {
            int i = 0;
            while (i < a.size()) {
                if (a.get(i) > b.get(i)) {
                    aPoint++;
                    i++;
                } else if (a.get(i) < b.get(i)) {
                    bPoint++;
                    i++;
                } else {
                    i++;
                }

            }
        }
        newList.add(aPoint);
        newList.add(bPoint);
        return newList;

    }

}
