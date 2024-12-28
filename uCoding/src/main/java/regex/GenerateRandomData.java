package regex;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateRandomData {
    public static void main(String[] args) {
        String regexAlphabet = "[a-zA-Z]";
        String numericData = "\\d+";
        int length = 8;
        String alphanumeric = "[a-zA-Z0-9@%^&()?/}{,!$*]+";
//        String regex = "^()$";
//        for (int i = 0; i < 1; i++) {
            System.out.println("The alphanumeric data with length " + length +" is: "+ generateRandomData(alphanumeric, length));
            System.out.println("The numeric data with length " + length +" is: "+ generateRandomData(numericData, length));
            System.out.println("The alphabet data with length " + length +" is: "+ generateRandomData(regexAlphabet, length));
//            System.out.println("The value is: "+generateRandomData(regex,length));
//        }


    }

    public static String generateRandomData(String regex, int size) {
        Pattern pattern = Pattern.compile(regex);
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < size) {
            char ch = (char) random.nextInt((127 - 32) + 32);
            Matcher matcher = pattern.matcher(String.valueOf(ch));
            if (matcher.matches()) {
                stringBuilder.append(ch);
            }

            if (stringBuilder.length() > size) {
                stringBuilder.setLength(size);
            }
        }
        return stringBuilder.toString();
    }
}
