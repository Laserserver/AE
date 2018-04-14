package activityexample.mex.ae.details;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import activityexample.mex.ae.R;
import activityexample.mex.ae.list_fragment.ListFragmentHolder;

public class DetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.detail_act_fragment);

        Bundle b = new Bundle();
        int index = getIntent().getIntExtra(ListFragmentHolder.LFH_INDEX_CONST, -1);
        if(index != -1){
            b.putInt(ListFragmentHolder.LFH_INDEX_CONST, index);
        }

        if(fragment == null){
            fragment = new DetailFragment();
            fragment.setArguments(b);
            fm.beginTransaction()
                    .add(R.id.detail_act_fragment, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context packageContext){
        Intent i = new Intent(packageContext, DetailActivity.class);
        //i.putExtra(EXTRA_ANSWER, answer);
        return i;
    }
}
