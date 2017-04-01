package se.openhack.jobsweeper.http;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import se.openhack.jobsweeper.OnResponse;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class HttpPost extends Http {

    String payload;
    String response;

    public HttpPost(String ip, String uri, int userId, OnResponse<String> onResponse, String payload) {
        super(ip, uri, userId, onResponse);
        this.payload = payload;
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL url;
        try {
            url = new URL(BASE_URL + uri);

            Log.i("HTTP-POST", BASE_URL + uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection = setHeaders(urlConnection);


            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(payload);

            writer.flush();
            writer.close();
            os.close();

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                response = readStream(urlConnection.getInputStream());
            }else{
                Log.e("HTTP", responseCode + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        onResponse.onResponse(response);
    }
}