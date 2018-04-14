package activityexample.mex.ae.list_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import activityexample.mex.ae.R;
import activityexample.mex.ae.crimes.Crime;

/**
 * Created by Mex on 04.04.2018.
 */

public class myHolder extends RecyclerView.ViewHolder {
    // Родительский элемент для списка?
    private TextView _date, _title;
    private CheckBox _cb;
    myHolder(View itemView) {
        super(itemView);
        _cb = itemView.findViewById(R.id.frag_list_checkbox);
        _date = itemView.findViewById(R.id.frag_list_date_text);
        _title = itemView.findViewById(R.id.frag_list_title_text);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _cb.setChecked(true);
            }
        });

        // itemView.find 2 textView + checkbox
    }

    public void bindTo(Crime crime){
        // взять данные из crime во вьюшки
        _date.setText(crime.get_date());
        _title.setText(crime.get_text());
        _cb.setChecked(crime.is_solved());
    }
}
