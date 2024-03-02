public class Practise2 {
    public void printGateway(String gateway){
        if(!(gateway.equalsIgnoreCase("SCT") || gateway.equalsIgnoreCase("CTS")
                || gateway.equalsIgnoreCase("SMH"))){
            throw new IllegalStateException("Provided gateway "+gateway+" is not correct, Please provide either SCT/CTS/SMH");
        }else {
            System.out.println("The Gateway value is: "+gateway);

        }

    }

    public static void main(String[] args) {
        Practise2 practise2 = new Practise2();
        practise2.printGateway("smk");
    }
}
