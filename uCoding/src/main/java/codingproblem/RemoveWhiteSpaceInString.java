package codingproblem;

public class RemoveWhiteSpaceInString {
    public static void main(String[] args) {

        System.out.println(removeWhiteSpace("Hi Shubham   I am   here   "));
    }

    public static String removeWhiteSpace(String val){
        return val.replaceAll("\\s","");
    }
}
