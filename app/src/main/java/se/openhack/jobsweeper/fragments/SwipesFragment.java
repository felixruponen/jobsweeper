package se.openhack.jobsweeper.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import se.openhack.jobsweeper.Helper;
import se.openhack.jobsweeper.OnResponse;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.activities.MainActivity;
import se.openhack.jobsweeper.activities.UserProfileActivity;
import se.openhack.jobsweeper.http.HttpGet;
import se.openhack.jobsweeper.models.JobAdvert;

/**
 * Created by victoraxelsson on 2016-12-03.
 */

public class SwipesFragment extends Fragment {

    List<JobAdvert> swipes;
    LinearLayout ll;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static SwipesFragment newInstance(String url) {
        SwipesFragment fragment = new SwipesFragment();
        Bundle args = new Bundle();
        // /user-tags-swiped/positive
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_positive_swipes, container, false);

        String url = getArguments().getString("url");

        int userId = ((UserProfileActivity)getActivity()).getIntKey("userId");
        swipes = new ArrayList<>();
        String ip = ((UserProfileActivity)getActivity()).getStringKey("ip");
        HttpGet getSwipes = new HttpGet(ip, url, userId, new OnResponse<String>() {
            @Override
            public void onResponse(String res) {
                try {

                    if(res == null){
                        res = Helper.getSwipesMock();
                    }

                    JSONArray jsonSwipes = new JSONArray(res);
                    swipes.clear();
                    for(int i = 0; i < jsonSwipes.length(); i++){
                        JSONObject jsonAdvert = jsonSwipes.getJSONObject(i);
                        swipes.add(new JobAdvert(jsonAdvert.toString()));
                    }

                    refreshAdapter();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        getSwipes.execute();



        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);


        return v;
    }

    private void refreshAdapter(){
        mAdapter.notifyDataSetChanged();
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {



        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txtTitle;

            public ViewHolder(View itemView) {
                super(itemView);
                txtTitle = (TextView)itemView.findViewById(R.id.txt_title);
            }
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_advert, parent, false);

            ViewHolder vh = new ViewHolder(v);

            return vh;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            JobAdvert advert = swipes.get(position);
            holder.txtTitle.setText(advert.getAdvert().getTitle());
        }


        @Override
        public int getItemCount() {
            return swipes.size();
        }
    }

}
