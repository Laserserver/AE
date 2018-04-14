package activityexample.mex.ae;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activityexample.mex.ae.list_fragment.myAdapter;


public class Test extends Fragment {

    private RecyclerView _rw;
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
        _rw.setAdapter(new myAdapter(getContext()));
        // Сделать синглтон с ленивой инициализацией
        // Сделай просто какую-нибудь херь внутри списка
        // Со списком стартовую, при клике на элт вывести тост или сделать активити с детализацией
        return v;
    }
}
