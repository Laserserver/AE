package activityexample.mex.ae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import activityexample.mex.ae.crimes.CrimeList;
import activityexample.mex.ae.details.DetailFragment;

public class ViewPagerActivity extends FragmentActivity {
    private ViewPager viewPager;
    public final String VPA_EXTRA = "Sas";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.activity__view_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment f = new DetailFragment();
                Bundle b = new Bundle();
                b.putInt(VPA_EXTRA, position);
                f.setArguments(b);
                return f;
            }

            @Override
            public int getCount() {
                return CrimeList.GetInstance().GetCount();
            }
        });
        viewPager.setCurrentItem(getIntent().getIntExtra(VPA_EXTRA, -1));
    }

    public static Intent newIntent(Context packageContext){
        Intent i = new Intent(packageContext, ViewPagerActivity.class);
        //i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }
}
