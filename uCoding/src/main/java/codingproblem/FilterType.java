package codingproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterType {
    public static void main(String[] args) {
        System.out.println(returnCharAndNumber("Shu8j9l89k7n4"));
//        returnValue("Shu8j9l89k7n4");

    }

    public static void returnValue(String value){
        List<Integer> numbers = new ArrayList<>();
        List<String> val = new ArrayList<>();
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while(matcher.find()){
            numbers.add(Integer.valueOf(matcher.group()));
        }
        Matcher matcher1 = Pattern.compile("[A-Za-z]+").matcher(value);

        while (matcher1.find()) {
            val.add(matcher1.group());
        }


        System.out.println(numbers);
        System.out.println(val);



    }

    public static List<Integer> returnCharAndNumber(String value){
        List<Integer> number = new ArrayList<>();
        char[] ch = value.toCharArray();
        for(int i =0;i<ch.length;i++){
            if(Character.isDigit(value.charAt(i))){
                number.add(Integer.parseInt(String.valueOf(value.charAt(i))));
            }

        }
        return  number;
    }
}
