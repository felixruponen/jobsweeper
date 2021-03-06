package se.openhack.jobsweeper.http;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import se.openhack.jobsweeper.OnResponse;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class HttpGet extends Http {

    String response;

    public HttpGet(String ip, String uri, int userId, OnResponse<String> onResponse) {
        super(ip, uri, userId, onResponse);
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            Log.i("HTTP-GET", BASE_URL + uri);
            url = new URL(BASE_URL + uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection = setHeaders(urlConnection);

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                response = readStream(urlConnection.getInputStream());
            }else{
                Log.e("HTTP", responseCode + "");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        onResponse.onResponse(response);
    }
}
