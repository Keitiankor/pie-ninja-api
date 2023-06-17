package poeninja.api.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class ApiRequest {

    public static String get(String... strings) {
        String urlStr = "https://poe.ninja/api/data/" + strings[0] + "overview?league=Crucible&type=" + strings[1];
        String line = null;
        StringBuilder sb = null;
        HttpsURLConnection conn;
        InputStream is = null;
        BufferedReader br = null;

        try {
            URL url = new URL(urlStr);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(1000);
            conn.setRequestMethod("GET");

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            conn.setSSLSocketFactory(context.getSocketFactory());
            conn.connect();

            if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                is = conn.getInputStream();
            } else {
                is = conn.getErrorStream();
            }
            br = new BufferedReader(new InputStreamReader(is));
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
