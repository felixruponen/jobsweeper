package se.openhack.jobsweeper.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import se.openhack.jobsweeper.Helper;
import se.openhack.jobsweeper.OnResponse;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.RoundedCornersTransform;
import se.openhack.jobsweeper.activities.MainActivity;
import se.openhack.jobsweeper.flingswipe.SwipeFlingAdapterView;
import se.openhack.jobsweeper.http.HttpGet;
import se.openhack.jobsweeper.http.HttpPost;
import se.openhack.jobsweeper.models.JobAdvert;

public class JobSwipeFragment extends Fragment {

    JobSwipeAdapter swipeAdapter;
    ArrayList<JobAdvert> jobAdverts = new ArrayList<>();
    ProgressBar spinner;

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
        spinner.setVisibility(View.VISIBLE);
        int userId = ((MainActivity)getActivity()).getIntKey("userId");
        String ip = ((MainActivity)getActivity()).getStringKey("ip");
        HttpGet getjobs = new HttpGet(ip, "/jobs", userId, new OnResponse<String>() {
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

                spinner.setVisibility(View.GONE);
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_swipe, container, false);
        //add the view via xml or programmatically
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.swipe);
        spinner = (ProgressBar) view.findViewById(R.id.spinner);

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

                    String ip = ((MainActivity)getActivity()).getStringKey("ip");
                    HttpPost post = new HttpPost(ip, "/jobs", userId, new OnResponse<String>() {
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
            public void onMoveCenter(View convertView) {
                ((LinearLayout) convertView.findViewById(R.id.swipeIndicator)).setVisibility(View.GONE);
            }

            @Override
            public void onMoveBeyondLeftBorder(View convertView) {
                ((LinearLayout) convertView.findViewById(R.id.swipeIndicator)).setVisibility(View.VISIBLE);
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setText("Inte intresserad");
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorRed));
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.swipe_indicator_decline) );
            }

            @Override
            public void onMoveBeyondRightBorder(View convertView) {
                ((LinearLayout) convertView.findViewById(R.id.swipeIndicator)).setVisibility(View.VISIBLE);
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setText("Intresserad");
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setTextColor(ContextCompat.getColor(getContext(), R.color.colorGreen));
                ((TextView) convertView.findViewById(R.id.swipeIndicatorText)).setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.swipe_indicator_accept) );
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                JobAdvert advert = (JobAdvert)dataObject;
                postDelta(advert, -1);
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                JobAdvert advert = (JobAdvert)dataObject;
                postDelta(advert, 1);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                collectJobs();
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
            private TextView jobDescription;
            private TextView advertId;
            private TextView previousExperience;
            private TextView benamning;
            private Button btnSeeMore;
            private Button btnWorkingHours;
            private TextView place;
            private ImageView jobLogo;
            private TextView swipeIndicator;
        }

        public JobSwipeAdapter(Context context, ArrayList<JobAdvert> items) {
            super(context, R.layout.card_job, items);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.card_job, parent, false);

                viewHolder = new ViewHolder();
                viewHolder.jobTitle = (TextView) convertView.findViewById(R.id.txt_jobTitle);
                viewHolder.jobDescription = (TextView) convertView.findViewById(R.id.txt_jobDescription);
                viewHolder.advertId = (TextView) convertView.findViewById(R.id.txt_advertId);
                //viewHolder.previousExperience = (TextView) convertView.findViewById(R.id.txt);
                viewHolder.benamning = (TextView) convertView.findViewById(R.id.txt_benamning);
                viewHolder.btnSeeMore = (Button) convertView.findViewById(R.id.btn_readMore);
                viewHolder.place = (TextView) convertView.findViewById(R.id.txt_place);
                viewHolder.btnWorkingHours = (Button) convertView.findViewById(R.id.btn_workHours);
                viewHolder.jobLogo = (ImageView) convertView.findViewById(R.id.jobLogo);
                viewHolder.swipeIndicator = (TextView) convertView.findViewById(R.id.swipeIndicatorText);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final JobAdvert jobAdvert = getItem(position);
            if (jobAdvert != null) {
                // My layout has only one TextView
                // do whatever you want with your string and long
                viewHolder.jobTitle.setText(jobAdvert.getAdvert().getTitle());

                String viewText = jobAdvert.getAdvert().getText();

                //Concat the title
                if(viewText.length() > 350){
                    viewText = viewText.substring(0, 350).replace("\n", "") + "...";

                }
                viewHolder.jobDescription.setText(viewText);
                viewHolder.place.setText(jobAdvert.getAdvert().getKommunName());
                if(jobAdvert.getRequirements().getWorkingTimes() != null && jobAdvert.getRequirements().getWorkingTimes().length() > 0){
                    viewHolder.btnWorkingHours.setText(jobAdvert.getRequirements().getWorkingTimes());
                }else{
                    viewHolder.btnWorkingHours.setVisibility(View.GONE);
                }


                if(jobAdvert.getWorkspace() != null && jobAdvert.getWorkspace().getLogotypeUrl() != null && !"".equals(jobAdvert.getWorkspace().getLogotypeUrl())) {
                    viewHolder.jobLogo.setVisibility(View.VISIBLE);
                    Picasso.with(getContext())
                            .load(jobAdvert.getWorkspace().getLogotypeUrl())
                            //.transform(new RoundedCornersTransform())
                            .into(viewHolder.jobLogo);
                }

                viewHolder.benamning.setText(jobAdvert.getAdvert().getJobTitle());
                viewHolder.advertId.setText("Annonsid: " + jobAdvert.getAdvert().getId());

                viewHolder.btnSeeMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        JobDetailFragment fr = new JobDetailFragment();
                        fr.setJobAdvert(jobAdvert);

                        ((MainActivity)getActivity()).setFragment(fr, "", true);
                    }
                });

            }

            return convertView;
        }
    }
}
