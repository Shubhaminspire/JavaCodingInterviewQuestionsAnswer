//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import io.cucumber.datatable.DataTable;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Random;
//
//public class json {
//    private Response response;
//    private FileReader fileReader;
//    private FileWriter fileWriter;
//
//    public void createRecordInRcdm(String tableName, DataTable data) {
//        Map<String, String> keyValues = data.asMap(String.class, String.class);
//        String requestUrl = "https://rchn.deb.ghc.02.com";
//        String payloadPath = "MainService";
//        Objects payloadObject = null;
//        JSONParser jsonparser = new JSONParser();
//        JSONObject jsonObject;
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        // Generate a unique filename based on the table name and a random number
//        String uniqueFileName = tableName + "_" + generateRandomNumber() + ".json";
//        File jsonFile = new File("src/file/" + uniqueFileName);
//
//        try {
//            fileWriter = new FileWriter(jsonFile);
//
//            switch (tableName) {
//                case "Table1" -> {
//                    payloadPath = payloadPath + "Table1.json";
//                    requestUrl = requestUrl + "/Table1";
//                }
//                case "Table2" -> {
//                    payloadPath = payloadPath + "Table2.json";
//                    requestUrl = requestUrl + "/Table2";
//                }
//                default -> {
//                    System.out.println("Invalid TableName");
//                    throw new IllegalStateException("Invalid TableName");
//                }
//            }
//
//            payloadObject = common.requestJsonReader(payloadPath, Object.class);
//            String jsonString = gson.toJson(payloadObject);
//            fileWriter.write(jsonString);
//
//            jsonObject = (JSONObject) jsonparser.parse(new FileReader(jsonFile));
//
//            for (String keys : keyValues.keySet()) {
//                String value = keyValues.get(keys);
//                jsonObject.put(keys, value);
//            }
//
//            jsonString = gson.toJson(jsonObject);
//            fileWriter.write(jsonString);
//
//            if (!response.jsonPath().get("message").equals("Record Created")) {
//                throw new IllegalStateException("Failed to create record");
//            }
//
//            // Open the file for reading after writing
//            fileReader = new FileReader(jsonFile);
//
//            // Now you can use fileReader to read the file if needed
//
//        } catch (IOException e) {
//            logger.error("IOException occurred: {}", e.getMessage());
//        } catch (ParseException e) {
//            logger.error("ParseException occurred: {}", e.getMessage());
//        } finally {
//            // Close the FileReader and FileWriter, and delete the JSON file when it's no longer needed
//            try {
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//                if (fileWriter != null) {
//                    fileWriter.close();
//                }
//            } catch (IOException e) {
//                logger.error("IOException occurred while closing FileReader/FileWriter: {}", e.getMessage());
//            }
//
//            if (jsonFile.exists()) {
//                jsonFile.delete();
//            }
//        }
//    }
//
//    // Generate a random number for creating unique filenames
//    private int generateRandomNumber() {
//        Random rand = new Random();
//        return rand.nextInt(10000); // Change the upper bound as needed
//    }
//}
