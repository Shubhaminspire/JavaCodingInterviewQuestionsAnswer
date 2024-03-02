public class Number {

    public static void main(String[] args) {
        String date = "2022-01-";

        for(int day =1;day<=31;day++) {
            String newDate;
            if(day <10){
                newDate = "0"+day;
            }else{
                newDate = String.valueOf(day);
            }

            String updateDate = date+newDate;
            System.out.println(updateDate);
        }
    }

}
