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
    private String employmentType;


    public Advert(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.id = object.getInt("annonsid");
            this.url = object.getString("platsannonsUrl");
            this.title = object.getString("annonsrubrik");
            this.text = object.getString("annonstext");
            this.jobTitle = object.getString("yrkesbenamning");
            this.workId = object.getInt("yrkesid");
            this.publishDate = object.getString("publiceraddatum");
            this.numberOfSlots = object.getInt("antal_platser");
            this.kommunName = object.getString("kommunnamn");
            this.kommunId = object.getInt("kommunkod");
            this.numberOfSlotsShow = object.getInt("antalplatserVisa");
            this.employmentType = object.getString("anstallningstyp");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
