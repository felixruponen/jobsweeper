package se.openhack.jobsweeper.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class JobAdvert extends Model {

    private Advert advert;
    private Terms terms;
    private Application application;
    private Workspace workspace;
    private List<String> tags;
    private Requirements requirements;

    public Requirements getRequirements() {
        return requirements;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public Application getApplication() {
        return application;
    }

    public Terms getTerms() {
        return terms;
    }

    public Advert getAdvert() {
        return advert;
    }

    public List<String> getTags() {
        return tags;
    }

    public JobAdvert(String json) {
        super(json);
    }

    @Override
    protected void parseModel(String json) {

        tags = new ArrayList<>();

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

            JSONArray tags = jobAdvert.getJSONArray("tags");

            for(int i = 0; i < tags.length(); i++){
                this.tags.add(tags.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
