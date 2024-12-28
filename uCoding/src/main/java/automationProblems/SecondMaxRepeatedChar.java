package automationProblems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondMaxRepeatedChar {

   static Map<Character, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        String str = "program execution";
        String newString = str.replaceAll("\\s+","");
        System.out.println(newString);
        List<Character> list = new ArrayList<>();

        for(char c: newString.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c: map.keySet()){
            if(map.get(c) >1){
               list.add(c);
            }
        }
        System.out.println(list.get(1));
        multipleNoByThree("defects found 9 and fixed 5 and deffered 2 inprogress 2");
    }


    // The below code will filtered out number from string and multiply each number by 3 and print result;
    //String str="defects found 9 and fixed 5 and deffered 2 inprogress 2"
    // here we have 4 numbers in this string - 9,5,2,2
    //output after multiply by 3
    // 9* 3 = 27
    // 5*3 = 15
    // 2*3 = 6
    //2*3 = 6
    public static void multipleNoByThree(String val){
        String regex = "[0-9]+";
        List<Integer> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(val);
        while(matcher.find()){
            list.add(Integer.parseInt(matcher.group()));
        }

        for(int num:list){
            System.out.println(num*3);
        }
    }


}
