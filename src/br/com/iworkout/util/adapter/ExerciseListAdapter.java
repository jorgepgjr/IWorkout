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
import br.com.iworkout.db.entity.Exercicio;

/**
 * Created by Jorge Peres on 10/09/13.
 */
public class ExerciseListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Exercicio> data;

    public ExerciseListAdapter(Activity activity, List<Exercicio> data) {
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
            vi = inflater.inflate(R.layout.exercicse_row, null);
        }

        TextView textView = (TextView)vi.findViewById(R.id.textView);
        textView.setText(data.get(i).getNome());
        return vi;
    }
}
