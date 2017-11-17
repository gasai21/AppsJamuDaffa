package com.example.pangling.appsjamu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.Value;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText nama,username,password;
    Button btnRegis;
    URL link = new URL();
    public String URL =link.url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //inisialisasi
        nama =(EditText) findViewById(R.id.txtNamaRegis);
        username = (EditText) findViewById(R.id.txtUsernameRegis);
        password = (EditText) findViewById(R.id.txtPasswordRegis);
        btnRegis = (Button) findViewById(R.id.btnRegis);

        //action registrasi
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),username.getText().toString()+" "+nama.getText().toString(), Toast.LENGTH_SHORT).show();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RegisteterAPI api = retrofit.create(RegisteterAPI.class);
                Call<Value> call = api.daftar(nama.getText().toString(),username.getText().toString(),password.getText().toString());
                call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        String value = response.body().getValue();
                        String message = response.body().getMessage();
                        if(value.equals("1")){
                            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
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
