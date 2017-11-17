package com.example.pangling.appsjamu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pangling.appsjamu.R;
import com.example.pangling.appsjamu.model.ListArtikel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Pangling on 10/31/2017.
 */

public class RecycleViewAdapterDetail extends RecyclerView.Adapter<RecycleViewAdapterDetail.ViewHolder> {
    public Context context;
    public List<ListArtikel> detail;
    ImageView img;
    public RecycleViewAdapterDetail(Context context,List<ListArtikel> detail){
        this.context = context;
        this.detail = detail;
    }


    @Override
    public RecycleViewAdapterDetail.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_detail_artikel,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapterDetail.ViewHolder holder, int position) {
        ListArtikel ad = detail.get(position);
        holder.jdl.setText(ad.getJudul());
        Picasso.with(context).load(ad.getGambar()).into(img);
        holder.isi.setText(ad.getKonten());
    }

    @Override
    public int getItemCount() {
        return detail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView jdl,isi;

        public ViewHolder(View view){
            super(view);
            jdl = (TextView) view.findViewById(R.id.tvJudul);
            isi =(TextView) view.findViewById(R.id.tvIsiKonten);
            img = (ImageView) view.findViewById(R.id.imgKonten);
        }
    }
}
