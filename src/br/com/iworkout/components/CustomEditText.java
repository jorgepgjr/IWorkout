package br.com.iworkout.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import br.com.iworkout.R;

/**
 * Created by Jorge on 10/7/2014.
 */
public class CustomEditText extends LinearLayout {

    private EditText editText;

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomEditText);
        String titleText = typedArray.getString(R.styleable.CustomEditText_value);
        Boolean color = typedArray.getBoolean(R.styleable.CustomEditText_color,false);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_test, this, true);

        ImageView decrease = (ImageView) findViewById(R.id.decrease);
        ImageView increase = (ImageView) findViewById(R.id.increase);

        if (color){
            decrease.setImageResource(R.drawable.train_serie_seta_esquerda);
            increase.setImageResource(R.drawable.train_serie_seta_direita);
        }
        editText = (EditText) findViewById(R.id.value);
        editText.setText(titleText);

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = Integer.valueOf(editText.getText().toString());
                editText.setText(formatNumber(v - 1));
            }
        });

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = Integer.valueOf(editText.getText().toString());
                editText.setText(formatNumber(v + 1));
            }
        });
    }

    public Integer getValue(){
        return Integer.valueOf(editText.getText().toString());
    }

    private String formatNumber(int x){
        if (x < 0 ){
            return "00";
        }else{
            return String.format("%02d",x);
        }
    }

}
