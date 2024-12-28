package automationProblems;

public class FilterNumberandSumInString {
    public static void main(String[] args) {

        String val = "ab12cd3e4f";
        String newString = "";
        int sum = 0;
        for (char c : val.toCharArray()) {
            if (Character.isDigit(c)) {
                newString += c;
            }
        }
        String[] vals = newString.split("");
        int[] value = new int[vals.length];
        int i = 0;
        for (String str : vals) {
            value[i] = Integer.parseInt(str);
            i++;
        }
        for (int j : value) {
            sum += j;
        }
        System.out.println(sum);
    }
}

