package metaPractiseCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintNumber {
    public static void main(String[] args) {
        String value = "hegdg218v@dh";
        String number = "";
        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()){
            number += matcher.group();
        }
        System.out.println(number);
    }
}
