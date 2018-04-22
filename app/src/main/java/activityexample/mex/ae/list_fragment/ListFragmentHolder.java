package activityexample.mex.ae.list_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import activityexample.mex.ae.R;
import activityexample.mex.ae.crimes.Crime;

public class ListFragmentHolder extends RecyclerView.ViewHolder {
    // Родительский элемент для списка?
    public static final String LFH_INDEX_CONST = "Sos";
    private TextView _date, _title;
    private CheckBox _cb;
    private int _index;
    private ListFragmentAdapter.OnClickHandler _clicker;

    ListFragmentHolder(View itemView, ListFragmentAdapter.OnClickHandler clicker) {
        super(itemView);
        _clicker = clicker;
        _cb = itemView.findViewById(R.id.frag_list_checkbox);
        _date = itemView.findViewById(R.id.frag_list_date_text);
        _title = itemView.findViewById(R.id.frag_list_title_text);
    }

    public void bindTo(Crime crime, int index){
        _index = index;
        _date.setText(crime.get_date());
        _title.setText(crime.get_title());
        _cb.setChecked(crime.is_solved());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _clicker.OnClick(_index);
            }
        });
    }
}
