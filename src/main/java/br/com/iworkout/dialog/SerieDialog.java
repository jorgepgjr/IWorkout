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
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;

import br.com.iworkout.R;
import roboguice.inject.InjectView;

public class SerieDialog extends RoboSherlockDialogFragment {

    TextView repeticoes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_serie, container, false);
        repeticoes = (TextView) v.findViewById(R.id.repiticoes);
        View.OnClickListener a = createDecreaseListener();
//        // watch for button clicks.
        ImageButton repeatDecrease = (ImageButton) v.findViewById(R.id.repeatDecrease);
        repeatDecrease.setOnClickListener(a);

        ImageButton repeatIncrease = (ImageButton) v.findViewById(R.id.repeatIncrease);
        repeatIncrease.setOnClickListener(createIncreaseListener());


        return v;
    }

    private View.OnClickListener createDecreaseListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                switch (id){
                    case R.id.repeatDecrease:
                        int v = Integer.valueOf(repeticoes.getText().toString());
                        repeticoes.setText(String.valueOf(v + 1));
                        break;
                }
            }
        };
    }

    private View.OnClickListener createIncreaseListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getId();
                //TODO: Pelo id aumenta o numero;
//                repeticoes.setText(Integer.valueOf(String.valueOf(repeticoes.getText())) + 1);
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
        public void onDialogPositiveClick(RoboSherlockDialogFragment dialog);
        public void onDialogNegativeClick(RoboSherlockDialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;
}