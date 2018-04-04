package activityexample.mex.ae;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Mex on 04.04.2018.
 */

public class myHolder extends RecyclerView.ViewHolder {
    // Родительский элемент для списка?
    TextView _date, _title;
    CheckBox _cb;
    public myHolder(View itemView) {
        super(itemView);
        _cb = itemView.findViewById(R.id.check_list_frag);
        _date = itemView.findViewById(R.id.date_list_frag);
        _title = itemView.findViewById(R.id.title_list_frag);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
