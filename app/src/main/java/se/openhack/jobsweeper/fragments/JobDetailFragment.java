package se.openhack.jobsweeper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.openhack.jobsweeper.R;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class JobDetailFragment extends Fragment {

    public JobDetailFragment(){}

    public static JobDetailFragment newInstance() {
        JobDetailFragment fragment = new JobDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_job_detail, container, false);


        return v;
    }
}
