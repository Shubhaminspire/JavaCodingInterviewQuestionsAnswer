package codingproblem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coding {
    static {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Coding coding = new Coding();
//        System.out.println(coding.removeSpecialCharacter("This is shubham @ shar%k ) and@"));
        System.out.println(coding.printRemovedSpecialCharacter("This is shubham @ shar%k ) and@"));
    }

    // Method to remove any special character
    public String removeSpecialCharacter(String value) {
        String result = null;
        String regex = "[^\\w\\s]";
        if (Pattern.compile(regex).matcher(value).find()) {
            System.out.println("The value " + value + " contains special characters");
            result = value.replaceAll(regex, "");
        } else {
            System.out.println("The value " + value + " does not contain any special characters");
        }
        return result;
    }

    public String printRemovedSpecialCharacter(String value) {

        String regex = "[^a-zA-Z0-9\\s]";
        String result = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
            result = value.replaceAll(regex, "");
        }
        System.out.println(result);
        return stringBuilder.toString();

    }
}

