package activityexample.mex.ae;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Test extends Fragment {
    private Button _btn;
    private Crime _crime;
    private EditText _tv;
    private CheckBox _cb;
    private String _txt;
    private RecyclerView _rw;
    private boolean _checked;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test, container, false);
        _btn = v.findViewById(R.id.button_sas);
        _tv = v.findViewById(R.id.crime_text_box);
        _cb = v.findViewById(R.id.checkbox);
        _rw = v.findViewById(R.id.recycler);
        _rw.setLayoutManager(new LinearLayoutManager(getActivity()));
        _rw.setAdapter(new myAdapter(getContext()));
        // Сделать синглтон с ленивой инициализацией
        // Сделай просто какую-нибудь херь внутри списка
        // Со списком стартовую, при клике на элт вывести тост или сделать активити с детализацией

        _tv.addTextChangedListener(new TextWatcher() {
            @Override
            //
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                _txt = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        _cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                _checked = b;
            }
        });
        _btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _crime = new Crime(_tv.getText().toString());
                _btn.setText(_crime.get_date());
                _btn.setEnabled(false);
            }
        });
        return v;
    }
}
