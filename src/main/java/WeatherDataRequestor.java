import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;



public class WeatherDataRequestor {

    /**
     * Public constructor.
     */
    public WeatherDataRequestor() {}

    // WeatherDataRequestor attributes
    private static final String NWS_API_URL = "https://api.weather.gov";
    private static final String USER_AGENT = "(KOWD-Precipitation-Requests, jesullivan222@gmail.com";



    public String requestStationObservations(String stationID) throws IOException, InterruptedException {

        String endpointString = NWS_API_URL + "/stations/" + stationID + "/observations";
        URL endpointURL = new URL(endpointString);
        //ttpURLConnection con = endpointURL.openConnection();

        // Build HttpClient
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(endpointString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();


    }
}
