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

    public String getOther() {
        return other;
    }

    public String getLastApplicationDate() {
        return lastApplicationDate;
    }

    public String getWebUri() {
        return webUri;
    }

    public String getReference() {
        return reference;
    }

    private String other;


    public Application(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.reference = object.optString("referens");
            this.webUri = object.optString("webbplats");
            this.lastApplicationDate = object.optString("sista_ansokningsdag");
            this.other = object.optString("ovrigt_om_ansokan");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
