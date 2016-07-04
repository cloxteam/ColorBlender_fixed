package com.devcolibry.artya.colorblender;

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
                textViewResult.setText(editTextRed.getText().toString());
                Integer R1 =  Integer.parseInt(editTextRed.getText().toString());
                Integer R2 =   Integer.parseInt(editTextRed2.getText().toString());
                Integer G1 =   Integer.parseInt(editTextGreen.getText().toString());
                Integer G2 =  Integer.parseInt(editTextBlue2.getText().toString());
                Integer B1 =  Integer.parseInt(editTextBlue.getText().toString());
                Integer B2 =  Integer.parseInt(editTextBlue2.getText().toString());

                Integer redBlended = (R1 + R2) / 2;
                Integer greenBlended = (G1 + G2) / 2;
                Integer blueBlended = (B1 + B2) / 2;

                /* complete code
                * ColorResultImagie(redBlended, greenBlended, blueBlended);
                *
                *
                * */

                textViewResult.setText(getString(R.string.red) + " " + String.valueOf(redBlended) + ", " +
                       getString(R.string.green) + " " + String.valueOf(greenBlended) + ", "
                        + getString(R.string.blue) + " " + String.valueOf(blueBlended));
            }
        });

    }

  /*  public void onBlending(View view){
        //get all colors
        Integer R1 =  Integer.parseInt(editTextRed.getText().toString());
        Integer R2 =   Integer.parseInt(editTextRed2.getText().toString());
        Integer G1 =   Integer.parseInt(editTextGreen.getText().toString());
        Integer G2 =  Integer.parseInt(editTextBlue2.getText().toString());
        Integer B1 =  Integer.parseInt(editTextBlue.getText().toString());
        Integer B2 =  Integer.parseInt(editTextBlue2.getText().toString());

        //blend
        Integer redBlended = (R1 + R2) / 2;
       Integer greenBlended = (G1 + G2) / 2;
       Integer blueBlended = (B1 + B2) / 2;

       // String red = redBlended.toString();
       // String green = greenBlended.toString();
       // String blue = blueBlended.toString();

        textViewResult.setText(String.valueOf(redBlended));
    }*/
}
