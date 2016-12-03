package se.openhack.jobsweeper.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import se.openhack.jobsweeper.Helper;
import se.openhack.jobsweeper.OnResponse;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.activities.MainActivity;
import se.openhack.jobsweeper.http.HttpGet;
import se.openhack.jobsweeper.http.HttpPost;
import se.openhack.jobsweeper.models.JobAdvert;

public class JobSwipeFragment extends Fragment {

    JobSwipeAdapter swipeAdapter;
    ArrayList<JobAdvert> jobAdverts = new ArrayList<>();

    public JobSwipeFragment() {
        // Required empty public constructor
    }

    private void notifyNewData(String res) throws JSONException{
        JSONArray adverts = null;
        adverts = new JSONArray(res);
        for(int i = 0; i < adverts.length(); i++){
            jobAdverts.add(new JobAdvert(adverts.getJSONObject(i).toString()));
        }

        swipeAdapter.notifyDataSetChanged();
    }

    private void collectJobs(){
        int userId = ((MainActivity)getActivity()).getIntKey("userId");
        HttpGet getjobs = new HttpGet("/jobs", userId, new OnResponse<String>() {
            @Override
            public void onResponse(String res) {
                try {
                    if(res == null){
                        Toast.makeText(getContext(), "Mocking data", Toast.LENGTH_LONG).show();
                        notifyNewData(Helper.getMockResponse());
                    }else{
                        notifyNewData(res);
                    }

                } catch (JSONException e) {
                    try {
                        Toast.makeText(getContext(), "Mocking data", Toast.LENGTH_LONG).show();
                        notifyNewData(Helper.getMockResponse());
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        });

        getjobs.execute();
    }

    public static JobSwipeFragment newInstance() {
        JobSwipeFragment fragment = new JobSwipeFragment();
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
        View view = inflater.inflate(R.layout.fragment_job_swipe, container, false);
        //add the view via xml or programmatically
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.swipe);

        //choose your favorite adapter
        swipeAdapter = new JobSwipeAdapter(getContext(), jobAdverts);

        //set the listener and the adapter
        flingContainer.setAdapter(swipeAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                jobAdverts.remove(0);
                swipeAdapter.notifyDataSetChanged();
            }


            private void postDelta(JobAdvert jobAdvert, int delta){

                int userId = ((MainActivity)getActivity()).getIntKey("userId");

                JSONObject object = new JSONObject();
                try {
                    object.put("jobid", jobAdvert.getAdvert().getId());

                    JSONArray tags = new JSONArray();
                    for(int i = 0; i < jobAdvert.getTags().size(); i++){
                        JSONObject tag = new JSONObject();
                        tag.put("name", jobAdvert.getTags().get(i));
                        tag.put("delta", delta);
                        tags.put(tag);
                    }
                    object.put("tags", tags);


                    HttpPost post = new HttpPost("/jobs", userId, new OnResponse<String>() {
                        @Override
                        public void onResponse(String res) {
                            System.out.println(res);
                        }
                    }, object.toString());
                    post.execute();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                JobAdvert advert = (JobAdvert)dataObject;
                postDelta(advert, -1);

                Toast.makeText(getContext(), "Left!", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onRightCardExit(Object dataObject) {

                JobAdvert advert = (JobAdvert)dataObject;
                postDelta(advert, 1);

                Toast.makeText(getContext(), "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
            }

            @Override
            public void onScroll(float v) {

            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

            }
        });

        collectJobs();

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



    public class JobSwipeAdapter extends ArrayAdapter<JobAdvert> {

        public class ViewHolder {
            private TextView jobTitle;
        }

        public JobSwipeAdapter(Context context, ArrayList<JobAdvert> items) {
            super(context, R.layout.card_job, items);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.getContext())
                        .inflate(R.layout.card_job, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.jobTitle = (TextView) convertView.findViewById(R.id.jobTitle);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            JobAdvert jobAdvert = getItem(position);
            if (jobAdvert != null) {
                // My layout has only one TextView
                // do whatever you want with your string and long
                viewHolder.jobTitle.setText(jobAdvert.getAdvert().getJobTitle());
            }

            return convertView;
        }
    }
}
