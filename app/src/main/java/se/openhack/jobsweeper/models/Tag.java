package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class Tag extends Model {

    private String name;
    private int counter;

    public Tag(String json) {
        super(json);
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.name = object.optString("name");
            this.counter = object.optInt("counter");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
