package se.openhack.jobsweeper.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.openhack.jobsweeper.OnResponse;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.activities.MainActivity;
import se.openhack.jobsweeper.activities.UserProfileActivity;
import se.openhack.jobsweeper.http.HttpGet;
import se.openhack.jobsweeper.http.HttpPost;
import se.openhack.jobsweeper.models.Tag;
import se.openhack.jobsweeper.models.User;

public class UserPreferenceFragment extends Fragment {

    User user;
    View view;
    ProgressBar spinner;

    public UserPreferenceFragment() {
        // Required empty public constructor
    }

    public static UserPreferenceFragment newInstance() {
        UserPreferenceFragment fragment = new UserPreferenceFragment();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_user_preference, container, false);
        spinner = (ProgressBar)view.findViewById(R.id.spinner_userSettings);


        collectUserTags();

        return view;
    }


    private void postTagChange(Tag tag, int delta){

        JSONObject wrapper = new JSONObject();
        JSONObject jsonTag = new JSONObject();
        JSONArray payload = new JSONArray();
        try {
            jsonTag.put("name", tag.getName());
            jsonTag.put("delta", delta);
            payload.put(jsonTag);

            wrapper.put("tags", payload);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int userid = ((UserProfileActivity) getActivity()).getIntKey("userId");

        spinner.setVisibility(View.VISIBLE);
        HttpPost editTag = new HttpPost("/update-tags", userid, new OnResponse<String>() {
            @Override
            public void onResponse(String res) {
                collectUserTags();
            }
        }, wrapper.toString());

        editTag.execute();
    }

    private void decreaseTag(Tag tag){
        postTagChange(tag, -1);
    }

    private void increaseTag(Tag tag){
        postTagChange(tag, 1);
    }

    private void refreshAdapter(){

        if(user != null){
            LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_userPreference);
            ll.removeAllViews();
            for(final Tag tag : user.getTags()) {

                LinearLayout incrementLayout = (LinearLayout) getLayoutInflater(null).inflate(R.layout.competence_increment, null);

                TextView incrementCompetence = (TextView) incrementLayout.findViewById(R.id.incrementCompetence);
                incrementCompetence.setText(tag.getName() + " -> " + tag.getCounter());

                Button btnDecrease = (Button) incrementLayout.findViewById(R.id.btnDecrease);
                btnDecrease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        decreaseTag(tag);
                    }
                });

                Button btnIncrease = (Button) incrementLayout.findViewById(R.id.btnIncrease);
                btnIncrease.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        increaseTag(tag);
                    }
                });

                ll.addView(incrementLayout);
            }
        }
    }

    private void collectUserTags() {

        int userId = ((UserProfileActivity)getActivity()).getIntKey("userId");
        spinner.setVisibility(View.VISIBLE);
        HttpGet getUser = new HttpGet("/user", userId, new OnResponse<String>() {
            @Override
            public void onResponse(String res) {
                user = new User(res);
                spinner.setVisibility(View.GONE);
                refreshAdapter();
            }
        });

        getUser.execute();
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
