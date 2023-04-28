package brokers.coyote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Coyote {
    public static String[] getLatLng(String location) throws Exception {
        String[] latLng = new String[2];
        String encodedLocation = URLEncoder.encode(location, "UTF-8");
        URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + encodedLocation + "&format=json&addressdetails=1&limit=1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
        int latIndex = response.indexOf("\"lat\":");
        int lonIndex = response.indexOf("\"lon\":");
        int endIndex = response.indexOf(",", lonIndex);
        latLng[0] = response.substring(latIndex + 6, latIndex + 16);
        latLng[1] = response.substring(lonIndex + 6, endIndex);
        return latLng;
    }


    //URL: https://nominatim.org/release-docs/develop/api/Search/

    public static void main(String[] args) throws Exception {

        String location = "elmwood park il";
        String[] latLng = getLatLng(location);
        System.out.println("Lat: " + latLng[0]);
        System.out.println("Lon: " + latLng[1]);

    }
}