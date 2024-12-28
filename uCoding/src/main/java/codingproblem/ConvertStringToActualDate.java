package codingproblem;

public class ConvertStringToActualDate {
    public static void main(String[] args) {
        String newDate = "";
        String date = "08-04-2022";
        String[] da = date.split("-");
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (da.length != 3) {
            throw new IllegalArgumentException("Invalid Date size");
        } else {
            String day = da[0];
            String year = da[2];
            if (day.length() == 1) {
                day = "0" + day;
            }
            int mon = Integer.parseInt(da[1]);
            newDate = newDate + day + "-" + months[mon] + "-" + year;
        }
        System.out.println(newDate);
    }


}
