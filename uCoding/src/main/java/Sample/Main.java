//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.channels.FileChannel;
//import java.nio.file.Files;
//import java.nio.file.StandardOpenOption;
//
//public class json {
//    // ... other code
//
//    public void createRecordInRcdm(String tableName, DataTable data) {
//        Map<String, String> keyValues = data.asMap(String.class, String.class);
//        String requestUrl = "https://rchn.deb.ghc.02.com";
//        String payloadPath = "MainService";
//        Object payloadObject = null;
//        JSONParser jsonparser = new JSONParser();
//        JSONObject jsonObject;
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        try {
//            // Check if the file exists and delete it if it does
//            if (Files.exists(createTableJson)) {
//                Files.delete(createTableJson);
//            }
//
//            Files.createFile(createTableJson); // Create the file
//
//            try (FileChannel fileChannel = FileChannel.open(createTableJson, StandardOpenOption.WRITE)) {
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
//                fileChannel.write(ByteBuffer.wrap(jsonString.getBytes()));
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
//                fileChannel.truncate(0);
//                fileChannel.write(ByteBuffer.wrap(jsonString.getBytes()));
//
//                if (!response.jsonPath().get("message").equals("Record Created")) {
//                    throw new IllegalStateException("failed");
//                }
//            }
//        } catch (IOException e) {
//            logger.error("IOException occurred: {}", e.getMessage());
//        } catch (ParseException e) {
//            logger.error("ParseException occurred: {}", e.getMessage());
//        }
//    }
//}
