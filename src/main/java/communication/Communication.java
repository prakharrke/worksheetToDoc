package communication;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Communication {

    public WorksheetResponse getWorksheetHTMLString(long worksheetId, WorksheetUrl worksheetUrl) {

        try {
            URL obj = new URL(worksheetUrl.displayName() + worksheetId);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result

                String responseString = response.toString();
                WorksheetResponse worksheetResponse = new Gson().fromJson(responseString, WorksheetResponse.class);

                return worksheetResponse;
            } else {
                throw new RuntimeException("Could not fetch worksheet with id " + worksheetId);
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static class WorksheetResponse {

        String skuName;
        String html;

        public WorksheetResponse(String skuName, String html) {
            this.skuName = skuName;
            this.html = html;
        }

        public WorksheetResponse() {
        }

        public String getSkuName() {
            return skuName;
        }

        public String getHtml() {
            return html;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }

        public void setHtml(String html) {
            this.html = html;
        }
    }

}
