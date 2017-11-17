package com.example.pangling.appsjamu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HasilKonsulActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_konsul);
        lv = (ListView) findViewById(R.id.listView2);

        ad = new ArrayAdapter<String>(HasilKonsulActivity.this,android.R.layout.simple_list_item_1,KonsultasiActivity.datakonsul);
        lv.setAdapter(ad);
    }
}
