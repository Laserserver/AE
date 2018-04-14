package activityexample.mex.ae.list_fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

import activityexample.mex.ae.R;
import activityexample.mex.ae.crimes.CrimeList;

/**
 * Created by Mex on 04.04.2018.
 */

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentHolder> {
    private LayoutInflater li;
    private CrimeList crimeList = CrimeList.GetInstance();
    public static Consumer<Integer> func;

    public ListFragmentAdapter(Context context){
        li = LayoutInflater.from(context);
        func = new Consumer<Integer>() {
            @Override
            public void accept(Integer index) {
                notifyItemChanged(index);
            }
        };
    }

    @Override
    public ListFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.fragment_list_item, parent, false);
        return new ListFragmentHolder(view);
    }

    // При первом выводе на экран или когда в список добавлен элмент
    @Override
    public void onBindViewHolder(ListFragmentHolder holder, int position) {
        holder.bindTo(crimeList.GetCrime(position), position);
    }

    @Override
    public int getItemCount() {
        return crimeList.GetCount();
    }
}
