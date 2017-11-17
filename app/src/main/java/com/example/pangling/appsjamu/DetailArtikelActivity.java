package com.example.pangling.appsjamu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.pangling.appsjamu.adapter.RecycleViewAdapterDetail;
import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.ListArtikel;
import com.example.pangling.appsjamu.model.Value;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailArtikelActivity extends AppCompatActivity {

    URL link = new URL();
    public String URL =link.url;
    private List<ListArtikel> detail = new ArrayList<>();
    private RecycleViewAdapterDetail viewAdapter;
   public String judul ;
    @BindView(R.id.recyclerviewdetailArtikel)RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        judul = intent.getStringExtra("judul");
        //Toast.makeText(getApplicationContext(),judul,Toast.LENGTH_SHORT).show();
        viewAdapter = new RecycleViewAdapterDetail(this, detail);
        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        LoadData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    public void LoadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisteterAPI api = retrofit.create(RegisteterAPI.class);
        Call<Value> call = api.detail(judul);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();

                if(value.equals("1")){
                    //Toast.makeText(getApplicationContext(),"bisa",Toast.LENGTH_SHORT).show();
                    detail = response.body().getAmbilA();
                    viewAdapter = new RecycleViewAdapterDetail(DetailArtikelActivity.this,detail);
                    recyclerView.setAdapter(viewAdapter);
                }else {
                    Toast.makeText(getApplicationContext(),"Coba",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Gagal Koneksi",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
