package se.openhack.jobsweeper.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import se.openhack.jobsweeper.R;

public class UserPreferenceFragment extends Fragment {



    List<String> competences = new ArrayList<String>();

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
        View view = inflater.inflate(R.layout.fragment_user_preference, container, false);

        competences.add("Java");
        competences.add("Java");
        competences.add("Java");
        competences.add("Java");


        for(String competence : competences) {
            LinearLayout incrementLayout = (LinearLayout) getLayoutInflater(savedInstanceState).inflate(R.layout.competence_increment, null);
            TextView incrementCompetence = (TextView) incrementLayout.findViewById(R.id.incrementCompetence);
            incrementCompetence.setText(competence);

            ((LinearLayout) view).addView(incrementLayout);
        }

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
