package automationProblems;

public class PrintAllZeroInBeginning {
    public static void main(String[] args) {
        String numbers = "32400108021200";
        String newString = returnValue(countChar(numbers, '0'), '0') + numbers.replaceAll("0", "");
        System.out.println(newString);
    }

    //32400121200
    public static int countChar(String value, char charToCount) {
        int i = 0;
        int count = 0;
        while (i < value.length()) {
            if (value.charAt(i) == charToCount) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static String returnValue(int times, char ch) {
        int i = 0;
        String newString = "";
        while (i < times) {
            newString += ch;
            i++;
        }
        return newString;

    }
}
