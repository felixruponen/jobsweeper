package se.openhack.jobsweeper.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(HomeFragment.newInstance(), "", false);
    }


    public void setFragment(Fragment fragment, String tag, boolean addToBackstack) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        fragment.setRetainInstance(true);
        transaction.replace(R.id.fragment_container, fragment, tag);

        if(addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commitAllowingStateLoss();
    }

}
