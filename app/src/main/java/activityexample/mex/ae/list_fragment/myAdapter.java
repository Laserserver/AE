package activityexample.mex.ae.list_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activityexample.mex.ae.R;
import activityexample.mex.ae.crimes.CrimeList;

/**
 * Created by Mex on 04.04.2018.
 */

public class myAdapter extends RecyclerView.Adapter<myHolder> {
    private LayoutInflater li;
    private CrimeList crimeList = CrimeList.GetInstance();

    public myAdapter(Context context){
        li = LayoutInflater.from(context);
    }

    @Override
    public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.fragment_list_item, parent, false);
        return new myHolder(view);
    }

    // При первом выводе на экран или когда в список добавлен элмент
    @Override
    public void onBindViewHolder(myHolder holder, int position) {
        // лист(элемент)
        holder.bindTo(crimeList.GetCrime(position));
    }

    @Override
    public int getItemCount() {
        return crimeList.GetCount();
    }
}
