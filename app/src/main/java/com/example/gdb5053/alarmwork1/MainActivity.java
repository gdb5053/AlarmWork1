package com.example.gdb5053.alarmwork1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //make button
        final Button zipCodeCalcButton = (Button) findViewById(R.id.zipCodeCalcButton);

        //onclick button function
        zipCodeCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get zip and store in string
                EditText zipCode = (EditText)findViewById(R.id.zipCode);
                String zipCodeString = zipCode.getText().toString();

                //SHOULD IMPORT ERR CATCH FOR BAD ZIP


                //change result textview
                TextView NoaaResult = (TextView) findViewById(R.id.NOAAText);
                NoaaResult.setText(zipCodeString);

            }
        });


    }//end onCreate



}//end class



