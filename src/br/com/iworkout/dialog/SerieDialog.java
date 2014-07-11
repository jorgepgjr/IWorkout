/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.iworkout.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.iworkout.R;

public class SerieDialog extends DialogFragment {

    EditText repeticoes;
    EditText serie;
    EditText peso;
    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_serie, container, false);
        repeticoes = (EditText) v.findViewById(R.id.repiticoes);
        serie = (EditText) v.findViewById(R.id.serie);
        peso = (EditText) v.findViewById(R.id.peso);
        TextView musculo = (TextView) v.findViewById(R.id.musculo);
        TextView exercicio = (TextView) v.findViewById(R.id.exercicio);

//        InputFilter[] filter = new InputFilter[]{new InputFilterMinMax("1", "12")};
//        et.setFilters();
//        et.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});
//        et.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});

        musculo.setText(getArguments().getString("musculo") + " -");
        exercicio.setText(getArguments().getString("exercicio"));


        // watch for button clicks.
        ImageView repeatDecrease = (ImageView) v.findViewById(R.id.repeatDecrease);
        repeatDecrease.setOnClickListener(createClickListener());
        ImageView repeatIncrease = (ImageView) v.findViewById(R.id.repeatIncrease);
        repeatIncrease.setOnClickListener(createClickListener());

        ImageView serieIncrease = (ImageView) v.findViewById(R.id.serieIncrease);
        serieIncrease.setOnClickListener(createClickListener());
        ImageView serieDecrease = (ImageView) v.findViewById(R.id.serieDecrease);
        serieDecrease.setOnClickListener(createClickListener());

        ImageView pesoIncrease = (ImageView) v.findViewById(R.id.pesoIncrease);
        pesoIncrease.setOnClickListener(createClickListener());
        ImageView pesoDecrease = (ImageView) v.findViewById(R.id.pesoDecrease);
        pesoDecrease.setOnClickListener(createClickListener());

        Button ok = (Button) v.findViewById(R.id.ok);
        ok.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onDialogPositiveClick(SerieDialog.this, repeticoes,serie, peso );
            }
        });

        Button cancel = (Button) v.findViewById(R.id.cancel);
        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onDialogNegativeClick(SerieDialog.this);
            }
        });
        return v;
    }

    private View.OnClickListener createClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                Integer v = 0;
                switch (id){
                    case R.id.repeatDecrease:
                        v = Integer.valueOf(repeticoes.getText().toString());
                        repeticoes.setText(formatNumber(v - 1));
                        break;
                    case R.id.repeatIncrease:
                        v = Integer.valueOf(repeticoes.getText().toString());
                        repeticoes.setText(formatNumber(v + 1));
                        break;
                    case R.id.serieDecrease:
                        v = Integer.valueOf(serie.getText().toString());
                        serie.setText(formatNumber(v - 1));
                        break;
                    case R.id.serieIncrease:
                        v = Integer.valueOf(serie.getText().toString());
                        serie.setText(formatNumber(v + 1));
                        break;
                    case R.id.pesoDecrease:
                        v = Integer.valueOf(peso.getText().toString());
                        peso.setText(formatNumber(v - 1));
                        break;
                    case R.id.pesoIncrease:
                        v = Integer.valueOf(peso.getText().toString());
                        peso.setText(formatNumber(v + 1));
                        break;
                }
            }
        };
    }

    private String formatNumber(int x){
        if (x < 0 ){
            return "00";
        }else{
            return String.format("%02d",x);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = ( NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, TextView repeticoes, TextView serie, TextView peso);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

}