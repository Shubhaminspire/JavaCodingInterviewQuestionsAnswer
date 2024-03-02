public class OccurenceOfChar {
    public static void main(String[] args) {
        OccurenceOfChar oc = new OccurenceOfChar();

        System.out.println("The Occurrence of char is: " + oc.getOccurrenceChar("aabbcdaav"));
    }

    //aabbcdaav = 9
    //value.length() - 1 = 9-1 = 8
    public String getOccurrenceChar(String value) {
        StringBuilder builder = new StringBuilder();
        if (value.length() > 0) {

            for (int i = 0; i < value.length(); i++) {
                // 2 <= 8 =>
                // 4 <= 8
                //5 <=8
                //6 <=8
                //8<=8
                char currentChar = value.charAt(i); // 2nd - b  //3rd - c  //4th  - d , //5th = a //6th = v

                int count = 1;
                while (i < value.length() - 1 && currentChar == value.charAt(i + 1)) { // b == b , // c != d  , //d != a , //a == a
                    count++; // 2
                    i++; // 3, //7

                }
                builder.append(currentChar).append(count);
                //a2b2c1d1a2

//            for (int j = i - 1; j >= 0; j--) {
//                if (currentChar == value.charAt(j)) {
//                    count++;
//                }
//            }
//            builder.append(currentChar).append(count);
            }
        }

        return builder.toString();
    }
}
