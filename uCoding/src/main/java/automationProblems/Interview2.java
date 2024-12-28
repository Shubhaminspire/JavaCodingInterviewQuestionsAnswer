package automationProblems;

public class Interview2 {
    public static void main(String[] args) {
        System.out.println(isComingInMiddle("World hello"));
//        returnString("aaabat");
        returnOutput("aaabat");
    }

    public static void returnString(String value) {
        String regex = "(.)\\1+";
        String newValue = "";
        newValue = value.replaceAll(regex, "");
        System.out.println(newValue);
    }

    //abhhjk
    // oldchar = a currentChar = b -> a != b true = a . oldchar = b
    // oldchar  = b currentchar = h .>  b!= h = ab  oldchar = h
    // oldchar = h currentchar = h  h != h false
    // pldchar = h currentchar = j h != j
    public static void returnOutput(String value) {
        StringBuilder sb = new StringBuilder();
        if (value == null || value.isEmpty()) {
            System.out.println(value);

        }
        // 0 == 1 = a == a = count = 2 i = 1
        // 1 == 2 = a == a count = 3 i 2
        //
        for(int i = 0; i < value.length();i++){
            int count = 1;
            while(i < value.length()-1 && value.charAt(i) == value.charAt(i+1)){
                count++;
                i++;
            }
//            sb.append(value.charAt(i)).append(count);
            if(count == 1){
                sb.append(value.charAt(i));
            }
        }

        System.out.println(sb);
    }


    // matches mathod of string perform the full match of a particular regex
    // as below i want to check that from string value . value matches the string regex start with hello or Hello
    //regex to match start with particular char or word
    //suppose word = hello
    // we want to match that a string start with hello word ignoring case insensitive
    // regex is = "(^hello.*)";
    // as ^ is use for start of regex if wa want to check someething coming at beginning
    // .* is used as matches match entire string pattern as our original string from which we want to match regex contains more letter despite hello
    // .* - followed by other words but ^(start) with hello (^hello)
    //(?i) - is used to ignore case insensitive

    // if want to match something in the end
    // use - (.*hello$) - as $ used for end, it's the end boundry of any string
    // same if wants to check that a particular value is coming anywhere in string , we use
    //(.*hello.*)
    public static boolean isComingInMiddle(String value) {
        String regex = "(?i)^hello.*";
        String regex1 = "(?i)(.*Hello$)";
        if (value.matches(regex1)) {
            return true;
        } else {
            return false;
        }
    }

}
