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

public class BelajarRecycleView extends RecyclerView.Adapter<BelajarRecycleView.ViewHolder> {
    Context context;
    List<Bekas> data;

    public BelajarRecycleView(Context context, List<Bekas> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public BelajarRecycleView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_history,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(BelajarRecycleView.ViewHolder holder, int position) {
        Bekas bk = data.get(position);
        holder.tv.setText(bk.getId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.txtIDHistory);
        }
    }
}
