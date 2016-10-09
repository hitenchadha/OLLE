package com.infotech.olle.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

// import org.codehaus.jettison.json.JSONException;
// import org.codehaus.jettison.json.JSONObject;
public class ConsumeJSON implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(ConsumeJSON.class.getName());
    public String result;

    public ConsumeJSON(String strURL, String strQuery, boolean blnSSL) throws IOException {

        try {
            String uri = SessionBean.getRequest()
                    .getScheme() + "://"
                    + SessionBean.getRequest().getServerName() + ":"
                    + SessionBean.getRequest().getServerPort()
                    + SessionBean.getRequest().getContextPath() + strURL + strQuery
                    + "/" + SessionBean.getRequest().getRemoteAddr();
            if (blnSSL) {
                InputStream is = trustHTTPS(uri);
                // String IPAddress = request.getRemoteAddr();
                result = getJSONString(is);
            } else {
                result = trustHTTP(uri);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "ConsumeJSON() Exception: {0}", e.getMessage());
        }
    }

    private String trustHTTP(String uri) {
        String strJSONString = "";

        try {
            StringBuilder builder = new StringBuilder();
            String inputLine;
            

            URL url = new URL(uri.replaceAll("\\s", ""));

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream()))) {
                while ((inputLine = in.readLine()) != null) {
                    builder.append(inputLine);
                }

                // JSONObject jObj = new JSONObject(builder.toString());
                // strJSONString = jObj.toString();
                strJSONString = builder.toString();
                log.log(Level.INFO, "JSON String: {0}", strJSONString);
            }

        } catch (Exception e) {
            log.log(Level.SEVERE, "trustHTTP() Exception: {0}", e.getMessage());
        }
        return strJSONString;

    }

    private InputStream trustHTTPS(String uri) {
        InputStream is = null;
        try {
            URL url = new URL(uri);
            HttpsURLConnection httpsCon = (HttpsURLConnection) url
                    .openConnection();
            httpsCon.setHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            httpsCon.connect();
            is = httpsCon.getInputStream();

        } catch (Exception e) {
            log.log(Level.SEVERE, "trustHTTPS() Exception: {0}", e.getMessage());
        }
        return is;
    }

    private static String getJSONString(InputStream is) {
        String strResult = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is,
                    Charset.forName("UTF-8")));
            // String jsonText = readAll(rd);
            //JSONObject json = new JSONObject(jsonText);
            // strResult = json.toString();
            strResult = readAll(rd);
        } catch (Exception e) {
            log.log(Level.SEVERE, "getJSONString() Exception: {0}", e.getMessage());
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                log.log(Level.SEVERE, "getJSONString() Close Exception: {0}", e.getMessage());
            }
        }

        return strResult;

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public String getResult() {
        return result;

    }

}
