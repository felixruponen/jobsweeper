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

    public List<Contact> getContacts() {
        return contacts;
    }

    public String getLogotypeUrl() {
        return logotypeUrl;
    }

    public String getVisitingAddress() {
        return visitingAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCountry() {
        return postalCountry;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    private String logotypeUrl;

    private List<Contact> contacts;



    public Workspace(String json) {
        super(json);


    }

    @Override
    protected void parseModel(String json) {

        try {
            JSONObject object = new JSONObject(json);
            this.name = object.optString("arbetsplatsnamn");
            this.zipCode = object.optString("postnummer");
            this.address = object.optString("postadress");
            this.city = object.optString("postort");
            this.postalCountry = object.optString("postland");
            this.country = object.optString("land");
            this.visitingAddress = object.optString("besoksadress");
            this.logotypeUrl = object.optString("logotypurl");

            JSONObject obj = object.optJSONObject("kontaktpersonlista");

            if(obj != null){
                JSONArray contacts = obj.getJSONArray("kontaktpersondata");

                this.contacts = new ArrayList<>();
                for(int i = 0; i < contacts.length(); i++){
                    JSONObject contactJson = contacts.getJSONObject(i);
                    this.contacts.add(new Contact(contactJson.toString()));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
