package activityexample.mex.ae;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.main_act_fragment);

        if(fragment == null){
            fragment = new Test();
            fm.beginTransaction()
                    .add(R.id.main_act_fragment, fragment)
                    .commit();
        }
    }
}
