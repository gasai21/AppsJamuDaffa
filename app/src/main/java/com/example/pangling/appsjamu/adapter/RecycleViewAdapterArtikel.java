package com.example.pangling.appsjamu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.appsjamu.DetailArtikelActivity;
import com.example.pangling.appsjamu.R;
import com.example.pangling.appsjamu.model.ListArtikel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Pangling on 10/27/2017.
 */
public class RecycleViewAdapterArtikel extends RecyclerView.Adapter<RecycleViewAdapterArtikel.ViewHolder> {
    Context context;
    List<ListArtikel> artikels;
    ImageView bg;

    String konten,gambar,id;
    public RecycleViewAdapterArtikel(Context context,List<ListArtikel> artikels){
        this.context = context;
        this.artikels = artikels;

    }

    @Override
    public RecycleViewAdapterArtikel.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_artikel,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapterArtikel.ViewHolder holder, int position) {
        ListArtikel ar = artikels.get(position);
        holder.judul.setText(ar.getJudul());
        Picasso.with(context).load(ar.getGambar()).into(bg);

    }

    @Override
    public int getItemCount() {
        return artikels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView judul,isi;
        //public ImageView gb;
        public ViewHolder(View view){
            super(view);
            judul = (TextView) view.findViewById(R.id.tvJudullva);
            isi = (TextView) view.findViewById(R.id.tvDeskripsi);
            bg = (ImageView) view.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String judul2 = judul.getText().toString();

            //Toast.makeText(view.getContext(),judul2,Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, DetailArtikelActivity.class);
            i.putExtra("judul",judul2);
            context.startActivity(i);
        }
    }
}
