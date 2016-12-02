package se.openhack.jobsweeper.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class JobAdvert extends Model {

    private Advert advert;
    private Terms terms;
    private Application application;
    private Workspace workspace;
    private Requirements requirements;


    public JobAdvert(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {


        try {
            JSONObject o = new JSONObject(json);
            JSONObject jobAdvert = o.getJSONObject("platsannons");
            JSONObject advert = jobAdvert.getJSONObject("annons");
            JSONObject terms = jobAdvert.getJSONObject("krav");
            JSONObject application = jobAdvert.getJSONObject("ansokan");
            JSONObject workspace = jobAdvert.getJSONObject("arbetsplats");
            JSONObject requirements = jobAdvert.getJSONObject("villkor");

            this.advert = new Advert(advert.toString());
            this.terms = new Terms(terms.toString());
            this.application = new Application(application.toString());
            this.workspace = new Workspace(workspace.toString());
            this.requirements = new Requirements(requirements.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
