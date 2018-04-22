package activityexample.mex.ae.list_fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

import activityexample.mex.ae.R;
import activityexample.mex.ae.ViewPagerActivity;
import activityexample.mex.ae.crimes.CrimeList;
import activityexample.mex.ae.details.DetailActivity;


/**
 * Created by Mex on 04.04.2018.
 */

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentHolder> {
    private LayoutInflater li;
    private CrimeList crimeList = CrimeList.GetInstance();
    private static final String LFA_INDEX_CONST = "Sos";
    private Context _cont;
    public static OnNotifyNeed _onn;

    public ListFragmentAdapter(Context context){
        li = LayoutInflater.from(context);
        _cont = context;

        _onn = new OnNotifyNeed() {
            public void Notify(int index) {
                if(index > -1)
                    notifyItemChanged(index);
            }
        };
    }


    public interface OnNotifyNeed{
        void Notify(int index);
    }

    public interface OnClickHandler{
        void OnClick(int position);
    }

    @Override
    public ListFragmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.fragment_list_item, parent, false);
        return new ListFragmentHolder(view, new OnClickHandler() {
            @Override
            public void OnClick(int position) {
                //Intent ints = DetailActivity.newIntent(_cont);
                Intent ints = ViewPagerActivity.newIntent(_cont);
                //ints.putExtra(LFA_INDEX_CONST, position);
                ints.putExtra(ViewPagerActivity.VPA_EXTRA_POS, position);
                _cont.startActivity(ints);
            }
        });
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
