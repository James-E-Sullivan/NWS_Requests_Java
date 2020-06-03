import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.http.HttpResponse;


/**
 * Main Class through which the project is run.
 *
 * @author James Sullivan
 *     Created 2020.06.03
 */
public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main m = new Main();

        logger.info("Testing Log4j");
        m.exampleWeatherRequest();
    }

    private String exampleWeatherRequest() {
        WeatherDataRequestor w = new WeatherDataRequestor();

        try {
            String responseString = w.requestStationObservations("KOWD");

            return responseString;
        }
        catch(IOException ioException){
            logger.info("IOException Encountered");
        }
        catch(InterruptedException ie) {
            logger.info("InterruptedException Encountered");
        }

        return "No response received due to exception";

    }


}
