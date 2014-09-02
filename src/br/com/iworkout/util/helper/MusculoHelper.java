package br.com.iworkout.util.helper;

import br.com.iworkout.R;

public class MusculoHelper {

    public static int getMusculoIconById(int id){
        switch (id){
            case 1:
                return R.drawable.musculo_abdominal;
            case 2:
                return R.drawable.musculo_aerobico;
            case 3:
                return R.drawable.musculo_biceps;
            case 4:
                return R.drawable.musculo_costas;
            case 5:
                return R.drawable.musculo_ombro;
            case 6:
                return R.drawable.musculo_peitoral;
            case 7:
                return R.drawable.musculo_pernas;
            case 8:
                return R.drawable.musculo_triceps;
        }
        return 1;
    }
}