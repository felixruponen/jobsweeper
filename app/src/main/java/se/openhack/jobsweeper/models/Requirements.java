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

    public String getSalaryForm() {
        return salaryForm;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public String getWorkingTimesDuration() {
        return workingTimesDuration;
    }

    public String getWorkingTimes() {
        return workingTimes;
    }

    public String getDuration() {
        return duration;
    }

    private String salaryForm;


    public Requirements(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            this.duration = object.optString("varaktighet");
            this.workingTimes = object.optString("arbetstid");
            this.workingTimesDuration = object.optString("arbetstidvaraktighet");
            this.salaryType = object.optString("lonetyp");
            this.salaryForm = object.optString("loneform");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
