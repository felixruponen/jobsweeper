package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Requirements extends Model {

    private String duration;
    private String workingTimes;
    private String workingTimesDuration;
    private String salaryType;
    private String salaryForm;


    public Requirements(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.duration = object.getString("varaktighet");
            this.workingTimes = object.getString("arbetstid");
            this.workingTimesDuration = object.getString("arbetstidvaraktighet");
            this.salaryType = object.getString("lonetyp");
            this.salaryForm = object.getString("loneform");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
