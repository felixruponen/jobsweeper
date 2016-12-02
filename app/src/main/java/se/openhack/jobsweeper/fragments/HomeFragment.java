package se.openhack.jobsweeper.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.openhack.jobsweeper.OnResponse;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.http.HttpGet;
import se.openhack.jobsweeper.models.JobAdvert;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        HttpGet getjobs = new HttpGet("/jobs", new OnResponse<String>() {
            @Override
            public void onResponse(String res) {

                List<JobAdvert> jobAdverts = new ArrayList<>();

                try {
                    JSONArray adverts = new JSONArray(res);
                    for(int i = 0; i < adverts.length(); i++){
                        jobAdverts.add(new JobAdvert(adverts.getJSONObject(i).toString()));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JobAdvert jobAdvert = new JobAdvert(res);
            }
        });

        getjobs.execute();


        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
