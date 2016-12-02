package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Application extends Model {

    private String reference;
    private String webUri;
    private String lastApplicationDate;
    private String other;


    public Application(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.reference = object.getString("referens");
            this.webUri = object.getString("webbplats");
            this.lastApplicationDate = object.getString("sista_ansokningsdag");
            this.other = object.getString("ovrigt_om_ansokan");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
