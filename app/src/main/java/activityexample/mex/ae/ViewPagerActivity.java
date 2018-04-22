package activityexample.mex.ae;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import activityexample.mex.ae.crimes.CrimeList;
import activityexample.mex.ae.details.DetailFragment;
import activityexample.mex.ae.list_fragment.ListFragmentHolder;

import static activityexample.mex.ae.details.DetailActivity.DET_ACT_CONST;

import static activityexample.mex.ae.list_fragment.ListFragmentAdapter._onn;

public class ViewPagerActivity extends FragmentActivity {
    public static final String VPA_EXTRA_POS = "Sas";
    public static final String VPA_EXTRA_FUNC = "Sos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager viewPager = findViewById(R.id.activity__view_pager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                Fragment f = new DetailFragment();
                Bundle b = new Bundle();
                b.putInt(VPA_EXTRA_POS, position);
                b.putParcelable(VPA_EXTRA_FUNC, new OnDataChange() {
                    @Override
                    public void Signalize() {
                        if(_onn != null)
                            _onn.Notify(position);
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {

                    }
                });
                f.setArguments(b);
                return f;
            }

            @Override
            public int getCount() {
                return CrimeList.GetInstance().GetCount();
            }
        });
        viewPager.setCurrentItem(getIntent().getIntExtra(VPA_EXTRA_POS, -1));
    }

    public interface OnDataChange extends Parcelable {
        void Signalize();
    }

    @Override
    public void onBackPressed() {
        //if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        //} else {
            // Otherwise, select the previous step.
        //    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        //}
    }

    public static Intent newIntent(Context packageContext){
        //i.putExtra(EXTRA_ANSWER, answer);
        return new Intent(packageContext, ViewPagerActivity.class);
    }
}
