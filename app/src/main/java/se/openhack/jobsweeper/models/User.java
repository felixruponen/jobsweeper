package se.openhack.jobsweeper.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class User extends Model {

    int id;
    String name;
    String image;
    private List<Tag> tags;

    public User(String json) {
        super(json);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.id = object.optInt("id");
            this.name = object.optString("name");
            this.image = object.optString("image");

            JSONArray tags = object.optJSONArray("tags");

            this.tags = new ArrayList<>();

            for(int i = 0; i < tags.length(); i++){
                JSONObject tag = tags.optJSONObject(i);
                this.tags.add(new Tag(tag.toString()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
