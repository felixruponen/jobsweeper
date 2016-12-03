package se.openhack.jobsweeper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.models.JobAdvert;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class JobDetailFragment extends Fragment {

    private JobAdvert jobAdvert;

    public JobDetailFragment(){}

    public static JobDetailFragment newInstance(int jobId) {
        JobDetailFragment fragment = new JobDetailFragment();
        Bundle args = new Bundle();
        args.putInt("id", jobId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_job_detail, container, false);


        TextView txtTitle = (TextView)v.findViewById(R.id.txt_title);
        txtTitle.setText(jobAdvert.getAdvert().getTitle());

        TextView txtText = (TextView)v.findViewById(R.id.txt_text);
        txtText.setText(jobAdvert.getAdvert().getText());

        return v;
    }

    public void setJobAdvert(JobAdvert jobAdvert) {
        this.jobAdvert = jobAdvert;
    }
}
