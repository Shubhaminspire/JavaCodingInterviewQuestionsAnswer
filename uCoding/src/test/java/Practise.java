public class Practise {
    static String gateway = "SCT";
    static String newDate;

    public static void main(String[] args) throws Exception {

        String anDate;
        String da = "2022-11-X";

        for (int i = 1; i <= 31; i++) {
            newDate = da.replaceAll("X", String.valueOf(i));
            StringBuilder buffer = new StringBuilder(newDate);

            if (newDate.length() < 10) {

                anDate = buffer.insert(newDate.length() - 1, '0').toString();
                System.out.println(anDate);
            } else {
                System.out.println(newDate);
            }

            //System.out.println(newDate);
        }










/*int size = values.length;
int i =0;
while(i< size){
    if(!(values[i].equalsIgnoreCase("SCT")) && !values[i].equalsIgnoreCase("CTS")
            && !values[i].equalsIgnoreCase("SMH"))
        throw new Exception("Not Valid");
    System.out.println("Hi");

    i++;

}*/
        getGateway();
    }

    public static void getGateway() {
        if (!(gateway.equalsIgnoreCase("SCT") || gateway.equalsIgnoreCase("CTS") || gateway.equalsIgnoreCase("SMH"))) {
            throw new IllegalStateException("Provide valid Gateway as " + gateway + " is not a valid gateway. Only SCT, CTS & SMH Gatways allowed");
        }
        System.out.println(gateway + " is the correct gateway");
    }

}

