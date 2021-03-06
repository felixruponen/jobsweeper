package se.openhack.jobsweeper.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;

import se.openhack.jobsweeper.OnResponse;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public abstract class Http extends AsyncTask<Void, Void, Void> {
    protected String uri;
    protected OnResponse<String> onResponse;
    protected int userId;
    //protected static final String BASE_URL = "http://192.168.0.3:8888";
    protected String BASE_URL;


    public Http(String ip, String uri, int userId, OnResponse<String> onResponse) {
        this.uri = uri;
        this.onResponse = onResponse;
        this.userId = userId;
        this.BASE_URL = ip;
    }

    protected HttpURLConnection setHeaders(HttpURLConnection urlConnection){
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setRequestProperty("js-userid", userId + "");

        return urlConnection;
    }

    protected String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return response.toString();
    }

}
