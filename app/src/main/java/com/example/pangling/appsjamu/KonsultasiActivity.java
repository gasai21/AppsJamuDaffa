package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.Value;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KonsultasiActivity extends AppCompatActivity {

    int i=0;
    Button konsul,add;
    ListView lv;
    List<String> a = new ArrayList<>();
    ArrayAdapter ad;
    Spinner bahan;
    public static List<String> datakonsul = new ArrayList<>();
    String hasilkonsul;
    String coba="";
    URL link = new URL();
    public String URL =link.url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi);

        //inisialisasi
        konsul = (Button) findViewById(R.id.btnKonsul);
        add = (Button) findViewById(R.id.btnAdd);
        lv = (ListView) findViewById(R.id.listView);
        bahan = (Spinner) findViewById(R.id.spinner);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int i2 =i++;
                //Toast.makeText(getApplicationContext(),String.valueOf(i2),Toast.LENGTH_SHORT).show();
                final String data = bahan.getSelectedItem().toString();
                a.add(data);

                ad = new ArrayAdapter(KonsultasiActivity.this,android.R.layout.simple_list_item_1,a);
                lv.setAdapter(ad);

                //menyeleksi data
                String kamu = bahan.getSelectedItem().toString();

                if(kamu.equals("Menambah nafsu makan")){
                    hasilkonsul = "Jamu Menambah nafsu makan adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Menghilangkan pegal linu")){
                    hasilkonsul = "Jamu menghilangkan pegal linu adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Meningkatkan stamina")){
                    hasilkonsul = "Jamu Meningkatkan stamina adalah Beras kencur";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Sakit perut karena datang bulan")){
                    hasilkonsul = "Jamu Sakit perut karena datang bulan adalah Kunyit Asam";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Mencerahkan kulit")){
                    hasilkonsul = "Jamu Mencerahkan kulit adalah Kunyit Asam";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Peradangan lambung")){
                    hasilkonsul = "Jamu Peradangan lambung adalah Sinom";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Maag")){
                    hasilkonsul = "Jamu Maag adalah Sinom";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Sakit pinggang")){
                    hasilkonsul = "Jamu Sakit pinggang adalah Cabe Puyang";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Kesemutan")){
                    hasilkonsul = "Jamu Kesemutan adalah Cabe Puyang";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Mencegah diabetes")){
                    hasilkonsul = "Jamu Mencegah diabetes adalah Pahitan";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Terapi cuci darah")){
                    hasilkonsul = "Jamu Terapi Cuci darah adalah Pahitan";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Meningkatkan produk ASI")){
                    hasilkonsul = "Jamu Meningkatkan produk ASI adalah uyup-uyup";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Menghilangkan bau badan")){
                    hasilkonsul = "Jamu Menghilangkan bau badan adalah uyup-uyup";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Menghilangkan kembung")){
                    hasilkonsul = "Jamu Menghilangkan kembung adalah uyup-uyup";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Meredakan demam")){
                    hasilkonsul = "Jamu Meredakan demam adalah Kudu Laos";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Pusing")){
                    hasilkonsul = "Jamu pusing adalah Temulawak";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Mual")){
                    hasilkonsul = "Jamu Mual adalah Temulawak";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else if(kamu.equals("Gejala masuk angin")){
                    hasilkonsul = "Jamu Gejala masuk angin adalah Temulawak";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }else {
                    hasilkonsul = "Jamu Menghilangkan jerawat adalah Pahitan";
                    datakonsul.add(hasilkonsul);
                    coba += kamu + " & ";
                }
            }
        });

        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpanData();
                Intent it = null;
                it = new Intent(KonsultasiActivity.this,HasilKonsulActivity.class);
                startActivity(it);
            }
        });
    }

    public void simpanData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String username = MainActivity.ambilId;
        String konsulan = coba;
        RegisteterAPI api = retrofit.create(RegisteterAPI.class);
        Call<Value> call = api.insert(username,konsulan);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();

                if(value.equals("1")){
                    Toast.makeText(getApplicationContext(),"Data Berhasil Di tambah!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Data Gagal Di tambah!",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Koneksi Gagal!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
