package wikiwhat.bulotsantini.dev.wikiwhat.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 12/03/2017.
 */

public class JsonRequest {
    public static String getFromUrl(String url_string) throws IOException {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        URL url = new URL(url_string);
        connection = (HttpURLConnection) url.openConnection();
        connection.connect();


        InputStream stream = connection.getInputStream();

        reader = new BufferedReader(new InputStreamReader(stream));

        StringBuilder buffer = new StringBuilder();
        String line = "";

        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");

        }

        connection.disconnect();
        reader.close();

        return buffer.toString();
    }
}
