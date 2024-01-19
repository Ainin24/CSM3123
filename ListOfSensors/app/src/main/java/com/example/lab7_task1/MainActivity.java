package com.example.lab7_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager senseMan;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listview);

        senseMan = (SensorManager) getSystemService(SENSOR_SERVICE); //map sensor manager to sensor service in device

        //get all sensor list and keep it one list
        List<Sensor> sensorList = senseMan.getSensorList(Sensor.TYPE_ALL);

        //insert sensor list into list item
        //must have adapter
        lv.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_expandable_list_item_1,sensorList));
    }
}