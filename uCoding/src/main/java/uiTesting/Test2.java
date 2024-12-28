//package uiTesting;
//
//// 9,1,2,4,5
//// 1 = 1,2,4,5,9
//// 2 = 9,1,2,4,5
//
//// length-1 = 0;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Test2 {
//    public static void main(String[] args) {
//        int[] array = {2, 4, 5, 9, 1};
//        int k = 2;
//        WebDriverManager.chromedriver().driverVersion("").setup();
//
//        List<Integer> list1 = new ArrayList<>(List.of(2,4,5,7,7));
//        list1.stream().filter(x-> x%2==0).forEach(x -> System.out.println(x));
//
//    }
//
//    public static void rotateArray(int[] arr, int k) {
//
//        int leng = arr.length;
//        int [] newArray = new int[leng];
//        int newleng = leng;
//        for(int i = 0; i<leng;i++){
//            int j = 0;
//            while(j<k){
//                int temp = arr[newleng-1];
//                newArray[i] = temp;
//                j++;
//            }
//        }
//
//    }
//
//
//}
//
//// Scenario: To validate login functionlity
//Given When user on Login Page
//        When user enter userName and Password
//        |username|<name>|
//
//
//
//tags ={"@SmokeTest"}
//
//
//        Examples:
//        |name|
//        |shuhha|
//        ||
//||
//
//ChromeDriver driver = new ChromeDriver();
//.
//
//public void stepDef(DataTable data){
//    Map<String,String> map = data.asMap(String.class, String.class);
//
//    for(map.get)
//}
//
//// Response response = RestAssured.given().headers().when().get("endpoint");
//
//// assert.assertEquals(response.getStatusCode(), 200,"Failed");
//
//
//// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//
