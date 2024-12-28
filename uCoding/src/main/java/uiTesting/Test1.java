package uiTesting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        String name = "Shubham Sharma";
        String newString = name.replace(" ","").trim().toLowerCase();
        System.out.println(newString);

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(char c: newString.toCharArray()){
            Pattern pattern = Pattern.compile(String.valueOf(c));
            Matcher matcher = pattern.matcher(newString);
            int count = 0;
            while(matcher.find()){
                count++;
            }

            map.put(c,count);
        }
    List<Character> list = new ArrayList<>();
        for(char ch:map.keySet()){
            int value = map.get(ch);
            if(value > 1){
                System.out.print(ch+" ");
            }else{
              throw new IllegalStateException("Not Allowed");
            }


        }
        System.out.println();
        System.out.println(list);
    }


}
