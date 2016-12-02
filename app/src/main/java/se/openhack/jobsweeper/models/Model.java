package se.openhack.jobsweeper.models;

/**
 * Created by victoraxelsson on 2016-12-02.
 */

public abstract class Model  {

    private String jsonData;

    public Model(String json){
        jsonData = json;
        parseModel(jsonData);
    }

    protected abstract void parseModel(String json);

}
