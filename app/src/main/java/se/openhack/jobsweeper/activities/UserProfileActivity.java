package se.openhack.jobsweeper.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import se.openhack.jobsweeper.CircleTransform;
import se.openhack.jobsweeper.R;
import se.openhack.jobsweeper.fragments.SwipesFragment;
import se.openhack.jobsweeper.fragments.UserPreferenceFragment;

public class UserProfileActivity extends AppCompatActivity {

    List<Fragment> pages;
    String[] titles;
    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Main");
        setSupportActionBar(toolbar);

        pages = new ArrayList<>();
        pages.add(UserPreferenceFragment.newInstance());
        pages.add(SwipesFragment.newInstance("/user-tags-swiped/positive"));
        pages.add(SwipesFragment.newInstance("/user-tags-swiped/negative"));


        titles = new String[3];
        titles[0] = "Taggar";
        titles[1] = "Intresserad";
        titles[2] = "Inte intresserad";
        txtUsername = (TextView)findViewById(R.id.userName);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        Picasso.with(this)
                .load(R.drawable.profile_placeholder)
                .transform(new CircleTransform())
                .into((ImageView) findViewById(R.id.userAvatar));

        UserProfilePagerAdapter userProfilePagerAdapter = new UserProfilePagerAdapter(getSupportFragmentManager());

        ViewPager profilePager = (ViewPager) findViewById(R.id.profilePager);
        profilePager.setAdapter(userProfilePagerAdapter);
    }

    public String getStringKey(String key){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getString(key, null);
    }


    public void setProfileImage(String url){
        if(url != null && url.length() > 0){
            Picasso.with(this)
                    .load(url)
                    .transform(new CircleTransform())
                    .into((ImageView) findViewById(R.id.userAvatar));
        }
    }

    public void setProfileName(String name){
        txtUsername.setText(name);
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
            return pages.get(position);
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    public int getIntKey(String key){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        return preferences.getInt(key, -1);
    }

}
