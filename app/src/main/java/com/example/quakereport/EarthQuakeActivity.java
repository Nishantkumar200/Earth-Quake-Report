package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    final ArrayList<QuakeInformation> quakereport = QueryUtils.extractQuakeInformation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);



        // These are the fake listed data

//        quakereport.add(new QuakeInformation("Feb 16 , 2020", "4.5", "Bihar"));
//        quakereport.add(new QuakeInformation("Feb 16 , 2020", "4.5", "Bihar"));
//        quakereport.add(new QuakeInformation("Feb 16 , 2020", "4.5", "Bihar"));
//        quakereport.add(new QuakeInformation("Feb 16 , 2020", "4.5", "Bihar"));
//        quakereport.add(new QuakeInformation("Feb 16 , 2020", "4.5", "Bihar"));

      //  Log.e("Data",String.valueOf(quakereport));
//

     final QuakeAdapter quakeAdapter = new QuakeAdapter(this,quakereport);
        ListView listView = findViewById(R.id.quakeInformation);
        listView.setAdapter(quakeAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // which item is clicke in the adapterview
                QuakeInformation everyquakedetail =  quakeAdapter.getItem(position);

                // once we get the position where the user clicked then we will get that url from below method;
                Uri earthquakeUri = Uri.parse(everyquakedetail.getmURL());

                // 
                startActivity(new Intent(Intent.ACTION_VIEW,earthquakeUri));

            }
        });
    }


}