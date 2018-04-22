package activityexample.mex.ae.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import activityexample.mex.ae.R;
import activityexample.mex.ae.ViewPagerActivity;
import activityexample.mex.ae.crimes.Crime;
import activityexample.mex.ae.crimes.CrimeList;
import activityexample.mex.ae.list_fragment.ListFragmentHolder;

import static activityexample.mex.ae.ViewPagerActivity.VPA_EXTRA_POS;
import static activityexample.mex.ae.details.DetailActivity.DET_ACT_CONST;


public class DetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Crime _crime;

    private EditText _title, _text;
    private TextView _date;
    private CheckBox _cb;
    //private DetailActivity.OnDataChange _signalise;
    private ViewPagerActivity.OnDataChange _signalise;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            //_crime = CrimeList.GetInstance().GetCrime(getArguments().getInt(ListFragmentHolder.LFH_INDEX_CONST));
            _crime = CrimeList.GetInstance().GetCrime(getArguments().getInt(VPA_EXTRA_POS));
            _signalise = getArguments().getParcelable(ViewPagerActivity.VPA_EXTRA_FUNC);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_item, container, false);
        _title = v.findViewById(R.id.frag_det_title);
        _date = v.findViewById(R.id.frag_det_date);
        _text = v.findViewById(R.id.frag_det_text);
        _cb = v.findViewById(R.id.frag_det_checkbox);
        SetListeners();
        FillData();
        return v;
    }

    private void SetListeners(){

        _cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                _crime.set_solved(isChecked);
                _signalise.Signalize();
                //ListFragmentAdapter.func.accept(_index);
            }
        });

        _title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                _crime.set_title(s.toString());
                _signalise.Signalize();
                //ListFragmentAdapter.func.accept(_index);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        _text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                _crime.set_text(s.toString());
                _signalise.Signalize();
                //ListFragmentAdapter.func.accept(_index);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void FillData(){
        _title.setText(_crime.get_title());
        _date.setText(_crime.get_date());
        _text.setText(_crime.get_text());
        _cb.setChecked(_crime.is_solved());
    }
}
