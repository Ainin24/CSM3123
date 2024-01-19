package com.example.lab7_task2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager senseMan;
    Sensor lightSensor;
    Sensor proximitySensor;
    Sensor humiditySensor;

    TextView lightTextview;
    TextView proximityTextview;
    TextView humidityTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightTextview = (TextView)findViewById(R.id.light_textview);
        proximityTextview = (TextView)findViewById(R.id.proximity_textview);
        humidityTextview = (TextView)findViewById(R.id.humidity_textview);

        senseMan = (SensorManager) getSystemService(SENSOR_SERVICE);

        lightSensor = senseMan.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = senseMan.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        humiditySensor = senseMan.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if (lightSensor == null) {
            Toast.makeText(this, "Light sensor not found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Light sensor found", Toast.LENGTH_SHORT).show();
            senseMan.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        senseMan.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        senseMan.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            lightTextview.setText(Float.toString(event.values[0]));

        } else if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            proximityTextview.setText(Float.toString(event.values[0]));

        } else if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            humidityTextview.setText(Float.toString(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();

        senseMan.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        senseMan.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        senseMan.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        senseMan.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}