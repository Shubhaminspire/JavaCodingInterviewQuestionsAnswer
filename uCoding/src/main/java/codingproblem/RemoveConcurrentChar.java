package codingproblem;

public class RemoveConcurrentChar {
    public static void main(String[] args) {
        System.out.println(removeRepetativeChar("aaabat"));
    }

//    012345
    //aaabat = 6
    //bat
    // initialchar = a
    // 2<6
    //3 position

    public static String removeRepetativeChar(String value) {
//        return value.replaceAll("(.)\\1+","");
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;

        while (index < value.length()) {
            char currentChar = value.charAt(index);
            int count = 1;
            while (index + 1 < value.length() && value.charAt(index) == value.charAt(index + 1)) {
                index++;
                count++;
            }
            if(count == 1){
                stringBuilder.append(currentChar);
            }
            index++;
        }
        return stringBuilder.toString();

    }

}
