package activityexample.mex.ae.list_fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activityexample.mex.ae.R;
import activityexample.mex.ae.main_activity.MainActivityFragmentHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragmentItem extends Fragment {
    public ListFragmentItem() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_item, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
