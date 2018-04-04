package activityexample.mex.ae;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mex on 04.04.2018.
 */

public class myAdapter extends RecyclerView.Adapter<myHolder> {
    LayoutInflater li;

    public myAdapter(Context context){
        li = LayoutInflater.from(context);
    }

    @Override
    public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.fragment_list, parent, false);
        return new myHolder(view);
    }

    // При первом выводе на экран или когда в список добавлен элмент
    @Override
    public void onBindViewHolder(myHolder holder, int position) {
        // лист(элемент)
        holder.bindTo(null);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
