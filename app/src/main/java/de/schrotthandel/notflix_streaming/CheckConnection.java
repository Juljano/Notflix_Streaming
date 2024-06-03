package de.schrotthandel.notflix_streaming;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckConnection {

    boolean checkConnection() {

        try {
            URL url = new URL("https://www.google.de/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return false;
    }
}
