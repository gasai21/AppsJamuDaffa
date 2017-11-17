package com.example.pangling.appsjamu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pangling.appsjamu.R;
import com.example.pangling.appsjamu.model.Bekas;

import java.util.List;

/**
 * Created by Pangling on 11/18/2017.
 */

public class DaffaBelajar extends RecyclerView.Adapter<DaffaBelajar.ViewHolder> {
    Context context ;
    List<Bekas> ngetesBekas ;

    public DaffaBelajar(Context context, List<Bekas> ngetesBekas) {
        this.context = context;
        this.ngetesBekas = ngetesBekas;
    }

    @Override
    public DaffaBelajar.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_history,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(DaffaBelajar.ViewHolder holder, int position) {
        Bekas bekaz = ngetesBekas.get(position);

        holder.idnya.setText(bekaz.getId());
    }

    @Override
    public int getItemCount() {
        return ngetesBekas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView idnya;



        public ViewHolder(View itemView) {

            super(itemView);
            idnya = (TextView) itemView.findViewById(R.id.txtIDHistory);
        }

    }
}
