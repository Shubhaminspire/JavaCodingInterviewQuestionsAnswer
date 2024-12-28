package codingproblem;

public class Palindrome {
    public static String name = "aniina";

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(name));
        System.out.println(palindrome.isPalindromme(name));

    }

    public boolean isPalindrome(String name) {
        int length = name.length();
        String val = "";
        for (int i = length - 1; i >= 0; i--) {
            val = val + name.charAt(i);
        }
        return name.equals(val);
    }

    public boolean isPalindromme(String name) {
        int i = 0;
        int j = name.length() - 1;
        while (i < j) {
            if (name.charAt(i) != name.charAt(j)) {
                return false;

            }
            i++;
            j--;
        }
        return true;

    }
}
