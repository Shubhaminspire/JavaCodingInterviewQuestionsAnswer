package automationProblems;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>(List.of("eat","tea","tan","ate","nat","bat"));
        GroupAnagram groupAnagram = new GroupAnagram();
//        System.out.println(groupAnagram.groupAnagram(values));
        System.out.println(groupAnagram.groupAnagrams(values));

    }

    public List<List<String>> groupAnagram(List<String> list) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String string : list) {
            char[] ch = string.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (!maps.containsKey(str)) {
                maps.put(str,new ArrayList<>());
            }
            maps.get(str).add(string);
        }

        List<List<String>> list1 = new ArrayList<>(maps.values());
        return list1;

    }

    public List<List<String>> groupAnagrams(List<String> list) {
        Map<String, List<String>> maps = new HashMap<>();
        List<String> sortedList = new ArrayList<>();

        for(String val: list){
            char[] ch = val.toCharArray();
            Arrays.sort(ch);
            String sortedString = String.valueOf(ch);
            sortedList.add(sortedString);
            if(!maps.containsKey(sortedString)){
                maps.put(sortedString,new ArrayList<>());
            }
            maps.get(sortedString).add(val);
        }
        List<List<String>> groups = new ArrayList<>(maps.values());
        return groups;


    }

}
