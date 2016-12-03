package se.openhack.jobsweeper.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import se.openhack.jobsweeper.CircleTransform;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.fragments.UserPreferenceFragment;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Main");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        Picasso.with(this)
                .load(R.drawable.profile_placeholder)
                .transform(new CircleTransform())
                .into((ImageView) findViewById(R.id.userAvatar));

        UserProfilePagerAdapter userProfilePagerAdapter = new UserProfilePagerAdapter(getSupportFragmentManager());

        ViewPager profilePager = (ViewPager) findViewById(R.id.profilePager);
        profilePager.setAdapter(userProfilePagerAdapter);

    }


    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class UserProfilePagerAdapter extends FragmentStatePagerAdapter {
        public UserProfilePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return UserPreferenceFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + position;
        }
    }
}
