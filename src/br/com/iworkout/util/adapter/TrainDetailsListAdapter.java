package br.com.iworkout.util.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.dao.ForeignCollection;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.util.helper.MusculoHelper;

/**
 * Created by Jorge Peres on 10/09/13.
 */
public class TrainDetailsListAdapter extends BaseAdapter {
    private Activity activity;
    private ForeignCollection<Serie> data;

    public TrainDetailsListAdapter(Activity activity, ForeignCollection<Serie> data) {
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
            vi = inflater.inflate(R.layout.detais_train_row, null);
        }

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView subTitle = (TextView)vi.findViewById(R.id.subTitle); // subTitle
        TextView exercicio = (TextView)vi.findViewById(R.id.exercicio); // exercicio 1:
        ImageView musculoImgBt = (ImageView) vi.findViewById(R.id.detaisTrainRowListImage);

        final Serie serie = (Serie) data.toArray()[i];

        musculoImgBt.setBackgroundResource(MusculoHelper.getMusculoIconById(serie.getExercicio().getMusculo().getId().intValue()));
        subTitle.setText(serie.getExercicio().getNome());
        title.setText(serie.getExercicio().getMusculo().getNome());
        int index = i + 1;
        exercicio.setText("Exercício " + index + ":");

        return vi;
    }
}
