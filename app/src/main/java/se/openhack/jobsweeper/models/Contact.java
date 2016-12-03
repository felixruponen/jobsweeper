package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Contact extends Model {

    private String name;
    private String number;

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    private String email;

    public Contact(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.name = object.optString("namn");
            this.number = object.optString("telefonnummer");
            this.email = object.optString("epostadress");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
