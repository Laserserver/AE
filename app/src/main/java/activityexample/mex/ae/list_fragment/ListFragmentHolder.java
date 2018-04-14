package activityexample.mex.ae.list_fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.concurrent.Callable;

import activityexample.mex.ae.R;
import activityexample.mex.ae.crimes.Crime;
import activityexample.mex.ae.details.DetailActivity;

/**
 * Created by Mex on 04.04.2018.
 */

public class ListFragmentHolder extends RecyclerView.ViewHolder {
    // Родительский элемент для списка?
    public static final String LFH_INDEX_CONST = "Sos";
    public static final String LFH_FUNC_CONST = "Sas";
    private TextView _date, _title;
    private CheckBox _cb;
    private Context _cont;
    private int _index;


    ListFragmentHolder(View itemView) {
        super(itemView);
        _cb = itemView.findViewById(R.id.frag_list_checkbox);
        _date = itemView.findViewById(R.id.frag_list_date_text);
        _title = itemView.findViewById(R.id.frag_list_title_text);
        _cont = itemView.getContext();
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ints = DetailActivity.newIntent(_cont);
                ints.putExtra(LFH_INDEX_CONST, _index);
                _cont.startActivity(ints);
            }
        });

        // itemView.find 2 textView + checkbox
    }

    public void bindTo(Crime crime, int index){
        // взять данные из crime во вьюшки
        _index = index;
        _date.setText(crime.get_date());
        _title.setText(crime.get_title());
        _cb.setChecked(crime.is_solved());
    }
}
