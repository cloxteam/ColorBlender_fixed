package com.devcolibry.artya.colorblender;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Artya on 17.06.2016.
 */
public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private EditText editTextRed, editTextRed2, editTextGreen, editTextGreen2,
           editTextBlue, editTextBlue2;

    private Integer redBlended;
    private Integer greenBlended;
    private Integer blueBlended;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextRed = (EditText) findViewById(R.id.editTextRed);
        editTextRed.setFilters(new InputFilter[]{new InputFilterMinMax("0","255")});//for min and max

        editTextRed2 = (EditText) findViewById(R.id.editTextRed2);
        editTextRed2.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});

        editTextGreen = (EditText) findViewById(R.id.editTextGreen);
        editTextGreen.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});

        editTextGreen2 = (EditText) findViewById(R.id.editTextGreen2);
        editTextGreen2.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});

        editTextBlue = (EditText) findViewById(R.id.editTextBlue);
        editTextBlue.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});

        editTextBlue2 = (EditText) findViewById(R.id.editTextBlue2);
        editTextBlue2.setFilters(new InputFilter[]{new InputFilterMinMax("0", "255")});

        textViewResult = (TextView) findViewById(R.id.textViewRelult);


       findViewById(R.id.buttonCalculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateColor(v);
            }
        });

        findViewById(R.id.buttonShowColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCustomViewActivity(v);
            }
        });
    }

    public void calculateColor(View view){
        CustomView customView = new CustomView(getApplicationContext());
        //parsing
        textViewResult.setText(editTextRed.getText().toString());
        Integer R1 =  Integer.parseInt(editTextRed.getText().toString());
        Integer R2 =   Integer.parseInt(editTextRed2.getText().toString());
        Integer G1 =   Integer.parseInt(editTextGreen.getText().toString());
        Integer G2 =  Integer.parseInt(editTextGreen2.getText().toString());
        Integer B1 =  Integer.parseInt(editTextBlue.getText().toString());
        Integer B2 =  Integer.parseInt(editTextBlue2.getText().toString());

        //blending colors from editText fields
        redBlended = (R1 + R2) / 2;
        greenBlended = (G1 + G2) / 2;
        blueBlended = (B1 + B2) / 2;



        //need to create getter an setter
        //send colors to custom View
        /* this variant not work for me

        customView.setRedBlended(redBlended);
        customView.setGreenBlended(greenBlended);
        customView.setBlueBlended(blueBlended);
*/
                /* complete code
                *
                *
                *
                * */
        //output text
        textViewResult.setText(getString(R.string.red) + " " + String.valueOf(redBlended) + ", " +
                getString(R.string.green) + " " + String.valueOf(greenBlended) + ", "
                + getString(R.string.blue) + " " + String.valueOf(blueBlended));


        //better variant

        customView._redBlended = redBlended;
        customView._greenBlended = greenBlended;
        customView._blueBlended = blueBlended;

    }

    public void startCustomViewActivity(View view){
        Intent intent = new Intent(getApplicationContext(), CustomViewActivity.class);
        startActivity(intent);
    }
}
