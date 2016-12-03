package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Advert extends Model {

    private int id;
    private String url;
    private String title;
    private String text;
    private String jobTitle;
    private int workId;
    private String publishDate;
    private int numberOfSlots;
    private String kommunName;
    private int kommunId;
    private int numberOfSlotsShow;

    public String getEmploymentType() {
        return employmentType;
    }

    public int getNumberOfSlotsShow() {
        return numberOfSlotsShow;
    }

    public int getKommunId() {
        return kommunId;
    }

    public String getKommunName() {
        return kommunName;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getWorkId() {
        return workId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    private String employmentType;


    public Advert(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.id = object.optInt("annonsid");
            this.url = object.optString("platsannonsUrl");
            this.title = object.optString("annonsrubrik");
            this.text = object.optString("annonstext");
            this.jobTitle = object.optString("yrkesbenamning");
            this.workId = object.optInt("yrkesid");
            this.publishDate = object.optString("publiceraddatum");
            this.numberOfSlots = object.optInt("antal_platser");
            this.kommunName = object.optString("kommunnamn");
            this.kommunId = object.optInt("kommunkod");
            this.numberOfSlotsShow = object.optInt("antalplatserVisa");
            this.employmentType = object.optString("anstallningstyp");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
