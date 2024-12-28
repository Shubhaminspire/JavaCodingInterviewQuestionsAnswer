package regex;

import java.util.List;

public class MatchThePatternInBetweenString {
    //This program match any string that has shu coming in between the string from index 1 to index length()-1
    public static void main(String[] args) {
        String pattern = "shub";
        String regex = "(?<!^.*)(?=\\b" + pattern + "\\b)(?!.*$)";
        List<String> list = List.of("anshub", "anshu", "anishubd", "shub");
        // System.out.println(returnFilteredList(regex, list));
        returnFilteredList("Shubham","hu");
    }

    public static void returnFilteredList(String name, String valueToMatch) {
        // Shubshu //shu
        //substring(7-3,7)

        int indexValue = name.length() - valueToMatch.length();
        int nameLength = name.length();
        String beginString = name.substring(0, valueToMatch.length());
        String endString = name.substring(indexValue,nameLength);
        if(valueToMatch.length() >= nameLength){
            throw new RuntimeException("The length of 2nd argument should be less tha 1st argument");
        }

        if(!beginString.equalsIgnoreCase(valueToMatch) && !endString.equalsIgnoreCase(valueToMatch)){
            if(name.contains(valueToMatch)){
                System.out.println(name);
            }else{
                System.out.println("Name "+name+" does not contain "+valueToMatch+" in between the actual string value");
            }
        } else{
            System.out.println("The "+valueToMatch+" coming either in the beginning or the end of name "+name);
        }


//        Random rand = new Random();
//        while (true) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < 10; i++) {
//                char ch = (char) rand.nextInt((26) + 'a');
//                stringBuilder.append(ch);
//            }
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(stringBuilder.toString());
//            if (matcher.matches()) {
//                System.out.println(stringBuilder.toString());
//            }
//            stringBuilder.setLength(0);
//        }
    }
}
