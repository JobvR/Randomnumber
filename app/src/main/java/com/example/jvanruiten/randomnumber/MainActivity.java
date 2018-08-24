package com.example.jvanruiten.randomnumber;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et_min;
    EditText et_max;
    Button b_generate;
    TextView tv_result;

    Random r;
    int min, max, output;
    String intOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        et_min = (EditText) findViewById(R.id.et_min);
        et_max = (EditText) findViewById(R.id.et_max);
        b_generate = (Button) findViewById(R.id.b_generate);
        tv_result = (TextView) findViewById(R.id.tv_result);

        b_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                String tempMin, tempMax;
                tempMin = et_min.getText().toString();
                tempMax = et_max.getText().toString();

                if (!tempMin.equals("") && !tempMax.equals("")) {
                    min = Integer.parseInt(tempMin);
                    max = Integer.parseInt(tempMax);

                    if (max > min) {
                        output = r.nextInt((max - min) + 1) + min;

                        intOutput = Integer.toString(output);

                        tv_result.setText(intOutput);
                    }
                }
            }
        });

    }


}
