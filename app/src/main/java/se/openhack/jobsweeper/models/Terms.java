package se.openhack.jobsweeper.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Terms extends Model {

    private boolean haveCar;

    public Terms(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.haveCar = object.getBoolean("egenbil");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
