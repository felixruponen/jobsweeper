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

import java.util.ArrayList;

import se.openhack.jobsweeper.R;

public class JobSwipeFragment extends Fragment {

    public JobSwipeFragment() {
        // Required empty public constructor
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

        final ArrayList<String> al = new ArrayList<>();
        al.add("Business analyst");
        al.add("Brogrammer");
        al.add("Policeman");
        al.add("Fireman");

        //choose your favorite adapter
        final JobSwipeAdapter arrayAdapter = new JobSwipeAdapter(getContext(), al);

        //set the listener and the adapter
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(getContext(), "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(getContext(), "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                al.add("XML ".concat(String.valueOf(itemsInAdapter)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                itemsInAdapter++;
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



    public class JobSwipeAdapter extends ArrayAdapter<String> {

        public class ViewHolder {
            private TextView jobTitle;
        }

        public JobSwipeAdapter(Context context, ArrayList<String> items) {
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

            String item = getItem(position);
            if (item!= null) {
                // My layout has only one TextView
                // do whatever you want with your string and long
                viewHolder.jobTitle.setText(item);
            }

            return convertView;
        }
    }
}
