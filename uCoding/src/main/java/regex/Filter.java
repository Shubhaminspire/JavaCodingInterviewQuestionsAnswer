package regex;

import java.util.*;

public class Filter {
    public static Grocerries grocerries1 = new Grocerries("Orange", 45);
    public static Grocerries grocerries2 = new Grocerries("Apple", 43);
    public static Grocerries getGrocerries3 = new Grocerries("Grapes", 100);

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(grocerries1.getPrice(), grocerries1.getName());
        map.put(grocerries2.getPrice(), grocerries2.getName());
        map.put(getGrocerries3.getPrice(), getGrocerries3.getName());

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(key);

        }
      List<Integer> newList =  list.stream().sorted(Collections.reverseOrder()).toList();

        for(int index: newList){
            System.out.println(map.get(index)+":"+index);
        }
    }


}
