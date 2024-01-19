package com.example.lab7_task3exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer, gyroscope, magnetometer;

    private TextView accelX, accelY, accelZ;
    private TextView gyroX, gyroY, gyroZ;
    private TextView magX, magY, magZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        accelX = findViewById(R.id.accel_x);
        accelY = findViewById(R.id.accel_y);
        accelZ = findViewById(R.id.accel_z);

        gyroX = findViewById(R.id.gyro_x);
        gyroY = findViewById(R.id.gyro_y);
        gyroZ = findViewById(R.id.gyro_z);

        magX = findViewById(R.id.mag_x);
        magY = findViewById(R.id.mag_y);
        magZ = findViewById(R.id.mag_z);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;

        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelX.setText(String.format("%s", event.values[0]));
            accelY.setText(String.format("%s", event.values[1]));
            accelZ.setText(String.format("%s", event.values[2]));

        } else if(sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyroX.setText(String.format("%s", event.values[0]));
            gyroY.setText(String.format("%s", event.values[1]));
            gyroZ.setText(String.format("%s", event.values[2]));

        } else if(sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magX.setText(String.format("%s", event.values[0]));
            magY.setText(String.format("%s", event.values[1]));
            magZ.setText(String.format("%s", event.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}