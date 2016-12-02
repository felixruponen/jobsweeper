package se.openhack.jobsweeper.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import se.openhack.jobsweeper.OnResponse;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public abstract class Http extends AsyncTask<Void, Void, Void> {
    protected String uri;
    protected OnResponse<String> onResponse;

    protected static final String BASE_URL = "http://192.168.8.101:8888";

    public Http(String uri, OnResponse<String> onResponse) {
        this.uri = uri;
        this.onResponse = onResponse;
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
