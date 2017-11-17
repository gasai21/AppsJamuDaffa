package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ActivityMenu extends AppCompatActivity {

    ImageButton konsul,history,artikel,lohout;
    Intent it = null;
    public static String penting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_menu);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        penting = intent.getStringExtra("username");

        konsul = (ImageButton) findViewById(R.id.imageButton);
        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,KonsultasiActivity.class);
                startActivity(it);
                //Toast.makeText(getApplicationContext(),"ini konsultasi",Toast.LENGTH_SHORT).show();
            }
        });

        history = (ImageButton) findViewById(R.id.imageButton2);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,HistoryActivity.class);
                startActivity(it);
                //Toast.makeText(getApplicationContext(),"ini History",Toast.LENGTH_SHORT).show();
            }
        });

        artikel = (ImageButton) findViewById(R.id.imageButton3);
        artikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(ActivityMenu.this,ArtikelActivity.class);
                startActivity(it);
                //Toast.makeText(getApplicationContext(),"ini Artikel",Toast.LENGTH_SHORT).show();
            }
        });

        lohout = (ImageButton) findViewById(R.id.imageButton4);
        lohout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

    }

    public void logout(){
        it = new Intent(ActivityMenu.this,MainActivity.class);
        startActivity(it);
        finish();
    }
}
