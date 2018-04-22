package activityexample.mex.ae.list_fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import activityexample.mex.ae.R;
import activityexample.mex.ae.main_activity.MainActivityFragmentHolder;


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
