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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.iworkout.R;

public class SerieDialog extends DialogFragment {

    TextView repeticoes;
    TextView serie;
    TextView peso;
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
        repeticoes = (TextView) v.findViewById(R.id.repiticoes);
        serie = (TextView) v.findViewById(R.id.serie);
        peso = (TextView) v.findViewById(R.id.peso);


        // watch for button clicks.
        ImageButton repeatDecrease = (ImageButton) v.findViewById(R.id.repeatDecrease);
        repeatDecrease.setOnClickListener(createClickListener());
        ImageButton repeatIncrease = (ImageButton) v.findViewById(R.id.repeatIncrease);
        repeatIncrease.setOnClickListener(createClickListener());

        ImageButton serieIncrease = (ImageButton) v.findViewById(R.id.serieIncrease);
        serieIncrease.setOnClickListener(createClickListener());
        ImageButton serieDecrease = (ImageButton) v.findViewById(R.id.serieDecrease);
        serieDecrease.setOnClickListener(createClickListener());

        ImageButton pesoIncrease = (ImageButton) v.findViewById(R.id.pesoIncrease);
        pesoIncrease.setOnClickListener(createClickListener());
        ImageButton pesoDecrease = (ImageButton) v.findViewById(R.id.pesoDecrease);
        pesoDecrease.setOnClickListener(createClickListener());

        Button ok = (Button) v.findViewById(R.id.ok);
        ok.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onDialogPositiveClick(SerieDialog.this, repeticoes,serie, peso );
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
                        repeticoes.setText(String.valueOf(v - 1));
                        break;
                    case R.id.repeatIncrease:
                        v = Integer.valueOf(repeticoes.getText().toString());
                        repeticoes.setText(String.valueOf(v + 1));
                        break;
                    case R.id.serieDecrease:
                        v = Integer.valueOf(serie.getText().toString());
                        serie.setText(String.valueOf(v - 1));
                        break;
                    case R.id.serieIncrease:
                        v = Integer.valueOf(serie.getText().toString());
                        serie.setText(String.valueOf(v + 1));
                        break;
                    case R.id.pesoDecrease:
                        v = Integer.valueOf(peso.getText().toString());
                        peso.setText(String.valueOf(v - 1));
                        break;
                    case R.id.pesoIncrease:
                        v = Integer.valueOf(peso.getText().toString());
                        peso.setText(String.valueOf(v + 1));
                        break;
                }
            }
        };
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
            mListener = (NoticeDialogListener) activity;
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