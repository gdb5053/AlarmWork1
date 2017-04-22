package com.example.gdb5053.alarmwork1;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
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

                //get alarmName and store in string
                EditText alarmName = (EditText)findViewById(R.id.alarmName);
                String alarmNameString = alarmName.getText().toString();

                //get lat and lon

                    //request permission

                int permissionCheck = ContextCompat.checkSelfPermission(thisActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION);

                    //Get location
                    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
                    Location currentLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    double lon = currentLocation.getLongitude();
                    double lat = currentLocation.getLatitude();

                //generate Noaa Url String
                String noaaUrl = "http://forecast.weather.gov/MapClick.php?lat="+lat+"&"+lon+"=-122.419416&unit=0&lg=english&FcstType=dwml";

                //change result textview
                TextView NoaaResult = (TextView) findViewById(R.id.NOAAText);
                NoaaResult.setText("Alarm Name: " + alarmNameString+"/n"+noaaUrl );

            }
        });


    }//end onCreate




}//end class



