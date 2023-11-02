package ch09.e09;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class E09 {
    public static void run() {
        try {
            String userName = "httpwatch";
            String password = "f";
            String basicAuthenticationValue = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
            URL url = new URL("https://www.httpwatch.com/httpgallery/authentication/authenticatedimage/default.aspx"); // The response is a gif image.
            HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + basicAuthenticationValue);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.US_ASCII))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
