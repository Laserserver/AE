package activityexample.mex.ae.main_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activityexample.mex.ae.R;
import activityexample.mex.ae.list_fragment.ListFragmentAdapter;


public class MainActivityFragmentHolder extends Fragment {

    private static RecyclerView _rw;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_holder, container, false);
        _rw = v.findViewById(R.id.recycler);
        _rw.setLayoutManager(new LinearLayoutManager(getActivity()));
        _rw.setAdapter(new ListFragmentAdapter(getContext()));
        return v;
    }
}
