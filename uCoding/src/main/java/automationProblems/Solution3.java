package automationProblems;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String word = sc.next();
        StringBuilder stringBuilder = new StringBuilder(word);
        System.out.println("Enter the letter to be replaced: ");
        String letter = sc.next();
        int letterCount = 0;
        for(int i =0 ; i <stringBuilder.length();i++){
            String ch = Character.toString(stringBuilder.charAt(i));
            if(ch.equals(letter)){
                letterCount++;
                String replacedLetter = "";
                for(int j =0; j<letterCount;j++){
                    replacedLetter = replacedLetter+"$";
                }
                stringBuilder = stringBuilder.replace(i,i+1,replacedLetter);
            }
        }
        System.out.println(stringBuilder);
    }
}
