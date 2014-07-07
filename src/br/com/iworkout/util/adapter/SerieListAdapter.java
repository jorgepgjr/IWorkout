package br.com.iworkout.util.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.j256.ormlite.dao.ForeignCollection;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Serie;

/**
 * Created by Jorge Peres on 10/09/13.
 */
public class SerieListAdapter extends BaseAdapter {
    private Activity activity;
    private ForeignCollection<Serie> data;

    public SerieListAdapter(Activity activity, ForeignCollection<Serie> data) {
        this.activity = activity;
        this.data = data;
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

        Serie[] seriesArray = (Serie[]) data.toArray();
        final Serie serie = seriesArray[i];
        final Exercicio exercicio = serie.getExercicio();

        // Setting all values in listview
        title.setText(exercicio.getNome());
//        subTitle.setText(exercicio.getMusculos().get(0).getNome());
        return vi;
    }
}
