package com.example.pangling.appsjamu.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pangling.appsjamu.R;
import com.example.pangling.appsjamu.URL;
import com.example.pangling.appsjamu.api.RegisteterAPI;
import com.example.pangling.appsjamu.model.Bekas;
import com.example.pangling.appsjamu.model.Value;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pangling on 10/26/2017.
 */
public class RecycleViewAdapterHistory extends RecyclerView.Adapter<RecycleViewAdapterHistory.ViewHolder> {

    private Context context;
    private List<Bekas> histories;
    public static String id;
    URL link = new URL();
    String URL = link.url;
    public RecycleViewAdapterHistory(Context context, List<Bekas> histories) {
        this.context = context;
        this.histories = histories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_history, parent, false);
        ViewHolder holder3 = new ViewHolder(v);

        return holder3;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Bekas mhs = histories.get(position);
        String ucr = mhs.getUsername();
        holder.textViewNIM.setText(mhs.getTgl());
        holder.textViewNama.setText(mhs.getKonsultasi());
        holder.tvid.setText(mhs.getId());

    }

    @Override
    public int getItemCount() {
        return  histories == null ? 0 : histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txtDate)TextView textViewNIM;
        @BindView(R.id.txtIsi)TextView textViewNama;
        TextView tvid;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            tvid = (TextView) itemView.findViewById(R.id.txtIDHistory);

        }


        @Override
        public void onClick(final View view) {
            String tgl = textViewNIM.getText().toString();
            String Isi = textViewNama.getText().toString();
            id = tvid.getText().toString();

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            final CharSequence[] dialogitem = {"Hapus History", "Keluar"};
            builder.setTitle("Pilihan");
            builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    switch (item) {
                        case 0:
                            hapusdata(id);
                            break;
                        case 1:

                            break;

                    }
                }
            });
            builder.create().show();
            /*Intent i = new Intent(context, UpdateActivity.class);
            i.putExtra("nim",nim);
            i.putExtra("nama",nama);
            context.startActivity(i);*/

        }

        public void hapusdata(String data){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RegisteterAPI api = retrofit.create(RegisteterAPI.class);
            Call<Value> call = api.delete(data);
            call.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    String value = response.body().getValue();
                    if(value.equals("1")){
                        Toast.makeText(itemView.getContext(),"Data Berhasil Di Hapus!",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(itemView.getContext(),"Data Gagal Di Hapus!",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Value> call, Throwable t) {
                    Toast.makeText(itemView.getContext(),"Gagal Koneksi!",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
