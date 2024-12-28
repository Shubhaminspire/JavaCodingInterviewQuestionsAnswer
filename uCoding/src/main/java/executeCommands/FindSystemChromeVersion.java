package executeCommands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class FindSystemChromeVersion {
    public static void main(String[] args) {
        try {
            // Url to hit endpoints that has collection of different chromerDriver, driver, headless-driver ersions in json response
            String driverJsonUrl = "https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone-with-downloads.json";
            // Escape spaces in the path using \\
            String chromeVersion = "";
            String chromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
            ProcessBuilder processBuilder = new ProcessBuilder(chromePath, "--version");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                chromeVersion = line.split(" ")[2];
            }

            int exitValue = process.waitFor();
            System.out.println("The chrome version is: " + chromeVersion);

            String browserChromeVersion = chromeVersion.split("\\.")[0];

            if (exitValue == 0) {
                System.out.println("Command executed successfully: ");
            } else {
                System.out.println("Command execution failed with exit value: " + exitValue);
            }

            String fetchResponse = fetchJsonResponse(driverJsonUrl);
            String driverDownloadUrl = getChromeDriverUrlForVersion(fetchResponse, Integer.parseInt(browserChromeVersion), "win64");

            if(driverDownloadUrl != null){
                System.out.println("The URL to download chromedriver (win64) version "+browserChromeVersion+" is: "+driverDownloadUrl);
            } else{
                throw new IllegalArgumentException("ChromeDriver url not found for version: "+browserChromeVersion);
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String fetchJsonResponse(String url) throws IOException {
        URL urls = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) urls.openConnection();
        urlConnection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();

    }

    private static String getChromeDriverUrlForVersion(String jsonResponse, int version, String windowVersion) throws JsonProcessingException {
        JsonNode milestoneNode = getJsonNode(jsonResponse, version);
        // Now, find the chromedriver URL for "win64" platform
        JsonNode chromeDriverNode = milestoneNode.path("downloads").path("chromedriver");

        Iterator<JsonNode> chromedriverIterator = chromeDriverNode.elements();

        while (chromedriverIterator.hasNext()) {
            JsonNode driver = chromedriverIterator.next();
            String platform = driver.path("platform").asText();

            if (windowVersion.equals(platform)) {
                return driver.path("url").asText();
            }
        }
        return null;
    }

    private static JsonNode getJsonNode(String jsonResponse, int version) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        // Navigate to "milestones" node in the JSON structure
        JsonNode milestonesNode = rootNode.path("milestones");

        // To check if the given version milestone Exist
        JsonNode milestoneNode = milestonesNode.path(String.valueOf(version));

        if (milestoneNode.isMissingNode()) {
            // Version not found in the milestones
            throw new IllegalArgumentException("No driver found for the version: "+ version);
        }
        return milestoneNode;
    }
}