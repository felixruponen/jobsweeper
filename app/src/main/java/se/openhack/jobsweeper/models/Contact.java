package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Contact extends Model {

    private String name;
    private String number;
    private String email;

    public Contact(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.name = object.getString("namn");
            this.number = object.getString("telefonnummer");
            this.email = object.getString("epostadress");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
