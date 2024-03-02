//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonParser;
//import io.cucumber.datatable.DataTable;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.Map;
//import java.util.Objects;
//import java.util.concurrent.TimeUnit;
//
//public class json {
//    Path createTableJson = Paths.get("src/file/table.json");
//    Response response;
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
//        int retryCount = 0;
//        boolean fileOperationSuccessful = false;
//
//        while (!fileOperationSuccessful && retryCount < 3) {
//            try {
//                // Check if the file exists and delete it if it does
//                if (Files.exists(createTableJson)) {
//                    Files.delete(createTableJson);
//                }
//
//                Files.createFile(createTableJson);
//                switch (tableName) {
//                    case "Table1" -> {
//                        payloadPath = payloadPath + "Table1.json";
//                        requestUrl = requestUrl + "/Table1";
//                    }
//                    case "Table2" -> {
//                        payloadPath = payloadPath + "Table2.json";
//                        requestUrl = requestUrl + "/Table2";
//                    }
//                    default -> {
//                        System.out.println("Invalid TableName");
//                        throw new IllegalStateException("Invalid TableName");
//                    }
//                }
//
//                payloadObject = common.requestJsonReader(payloadPath, Object.class);
//                String jsonString = gson.toJson(payloadObject);
//                Files.write(createTableJson, jsonString.getBytes());
//
//                FileReader fileReader = new FileReader(createTableJson.toFile());
//                jsonObject = (JSONObject) jsonparser.parse(fileReader);
//
//                for (String keys : keyValues.keySet()) {
//                    String value = keyValues.get(keys);
//                    jsonObject.put(keys, value);
//                }
//
//                jsonString = gson.toJson(jsonObject);
//                Files.write(createTableJson, jsonString.getBytes());
//                fileReader = new FileReader(createTableJson.toFile());
//                payloadObject = gson.fromJson(fileReader, Objects.class);
//                fileReader.close();
//
//                if (!response.jsonPath().get("message").equals("Record Created")) {
//                    throw new IllegalStateException("Failed to create record");
//                }
//
//                fileOperationSuccessful = true; // File operation succeeded
//            } catch (FileAlreadyExistsException e) {
//                // The file was created by another process, let's retry
//                retryCount++;
//                try {
//                    TimeUnit.SECONDS.sleep(1); // Wait for a short time before retrying
//                } catch (InterruptedException ex) {
//                    Thread.currentThread().interrupt();
//                }
//            } catch (IOException e) {
//                logger.error("IOException occurred: {}", e.getMessage());
//            } catch (ParseException e) {
//                logger.error("ParseException occurred: {}", e.getMessage());
//            }
//        }
//
//        if (!fileOperationSuccessful) {
//            throw new IllegalStateException("Failed after multiple retries");
//        }
//    }
//}
