package activityexample.mex.ae;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Test extends Fragment {
    private Button _btn;
    private Crime _crime;
    private EditText _tv;
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
        _btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _crime = new Crime(_tv.getText().toString(), new Date());
                _btn.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(_crime.get_date()));
                _btn.setEnabled(false);
            }
        });
        return v;
    }
}
