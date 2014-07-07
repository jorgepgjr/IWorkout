package br.com.iworkout.util.helper;

import br.com.iworkout.R;

public class MusculoHelper {

    public static int getMusculoIconById(int id){
        switch (id){
            case 1:
                return R.drawable.musculo_abdominal;
            case 2:
                return R.drawable.musculo_biceps;
        }
        return 1;
    }
}