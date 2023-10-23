package com.example.app_nauan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_nauan.R;
import com.example.app_nauan.model.MonAn;

import java.util.List;

public class AdapterMonAn extends RecyclerView.Adapter<AdapterMonAn.MonAnViewHolder> {

    private List<MonAn> mListMonAn;
    public void setData(List<MonAn> list){
        this.mListMonAn  = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MonAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monan,parent,false);
        return  new MonAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonAnViewHolder holder, int position) {
        MonAn monan = mListMonAn.get(position);
        if(monan == null){
            return;
        }
        holder.name.setText(monan.getTenmon());
        holder.thoigian.setText(monan.getThoigian());
        holder.kcal.setText(monan.getKcal());
        holder.imghinh.setImageResource(monan.getHinh());

    }

    @Override
    public int getItemCount() {
        if(mListMonAn != null){
            return mListMonAn.size();
        }
        return 0;
    }

    public class MonAnViewHolder extends RecyclerView.ViewHolder{
        private TextView name,thoigian, kcal;
        private ImageView imghinh;
        private ConstraintLayout mainLayout;
        public MonAnViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            thoigian = itemView.findViewById(R.id.thoigian);
            kcal = itemView.findViewById(R.id.kcal);
            imghinh = itemView.findViewById(R.id.imagehinh);

        }
    }
}
