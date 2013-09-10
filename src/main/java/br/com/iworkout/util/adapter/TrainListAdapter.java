package br.com.iworkout.util.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Treino;

/**
 * Created by Jorge Peres on 10/09/13.
 */
public class TrainListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Treino> data;

    public TrainListAdapter(Activity activity, List<Treino> data) {
        activity = activity;
        data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.train_row, null);
        }

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView subTitle = (TextView)vi.findViewById(R.id.subTitle); // subTitle

        Treino treino = data.get(i);

        // Setting all values in listview
        title.setText(treino.getNome());
        subTitle.setText(treino.getValQtd());
        return vi;
    }
}
