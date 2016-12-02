package se.openhack.jobsweeper.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public class Workspace extends Model {

    private String name;
    private String zipCode;
    private String address;
    private String city;
    private String postalCountry;
    private String country;
    private String visitingAddress;
    private String logotypeUrl;

    private List<Contact> contacts;



    public Workspace(String json) {
        super(json);


    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.name = object.getString("arbetsplatsnamn");
            this.zipCode = object.getString("postnummer");
            this.address = object.getString("postadress");
            this.city = object.getString("postort");
            this.postalCountry = object.getString("postland");
            this.country = object.getString("land");
            this.visitingAddress = object.getString("besoksadress");
            this.logotypeUrl = object.getString("logotypurl");

            JSONObject obj = object.getJSONObject("kontaktpersonlista");
            JSONArray contacts = obj.getJSONArray("kontaktpersondata");

            this.contacts = new ArrayList<>();
            for(int i = 0; i < contacts.length(); i++){
                JSONObject contactJson = contacts.getJSONObject(i);
                this.contacts.add(new Contact(contactJson.toString()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
