package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.Value;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public EditText user,pss;
    public Button login;
    URL link = new URL();
    public String URL =link.url;
    public static String ambilId;
    public TextView Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        user = (EditText) findViewById(R.id.txtUsername);
        pss =  (EditText) findViewById(R.id.txtPassword);
        login = (Button) findViewById(R.id.btnLogin);
        Register = (TextView) findViewById(R.id.regis);

        //untuk pergi kependaftaran
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this,"Ciieee",Toast.LENGTH_SHORT).show();
                Intent it = null;
                it = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(it);
            }
        });

        //melakukan login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RegisteterAPI api = retrofit.create(RegisteterAPI.class);
                Call<Value> call = api.Login(user.getText().toString(),pss.getText().toString());
                call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        String value = response.body().getValue();
                        ambilId = user.getText().toString();
                        if(value.equals("1")){
                            Toast.makeText(getApplicationContext(),"Selamat Anda Berhasil Login",Toast.LENGTH_SHORT).show();
                            Intent it = null;
                            it = new Intent(MainActivity.this,ActivityMenu.class);
                            it.putExtra("username",user.getText().toString());
                            finish();
                            startActivity(it);
                        }else{
                            Toast.makeText(getApplicationContext(),"Anda Gagal Login",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Koneksi Gagal",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
