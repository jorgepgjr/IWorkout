package br.com.iworkout.util.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
    // boolean array for storing
    //the state of each CheckBox
    private boolean[] checkBoxState;

    public TrainDetailsListAdapter(Activity activity, ForeignCollection<Serie> data) {
        this.activity = activity;
        this.data = data;
        checkBoxState=new boolean[data.size()];
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View vi = view;
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.detais_train_row, null);
        }

        TextView title = (TextView)vi.findViewById(R.id.title); // Rosca Direta
        TextView exercicio = (TextView)vi.findViewById(R.id.exercicio); // Exercicio 1:
        ImageView musculoImgBt = (ImageView) vi.findViewById(R.id.detaisTrainRowListImage); //Imagem do Biceps
        CheckBox checkBox = (CheckBox) vi.findViewById(R.id.checkBox);

        checkBox.setChecked(checkBoxState[i]);
        checkBox.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(((CheckBox)v).isChecked())
                    checkBoxState[i]=true;
                else
                    checkBoxState[i]=false;

            }
        });

        final Serie serie = (Serie) data.toArray()[i];

        musculoImgBt.setBackgroundResource(MusculoHelper.getMusculoIconById(serie.getExercicio().getMusculo().getId().intValue()));
        title.setText(serie.getExercicio().getNome());
        title.append(" " + serie.getQtd() + " x " + serie.getRepiticoes());
        int index = i + 1;
        exercicio.setText("Exercício " + index + ":");

        return vi;
    }

    public boolean arAllSelected(){
        for(boolean count : checkBoxState){
            if (!count){
                return false;
            }
        }

        return true;
    }
}
