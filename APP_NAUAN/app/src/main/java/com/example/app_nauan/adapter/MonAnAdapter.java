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
import com.example.app_nauan.adapter.MonAnAdapter;
import java.util.List;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.layout_Monan>{
    public MonAnAdapter(List<MonAn> monAn) {
        this.monAn = monAn;
    }

    List<MonAn> monAn;
    @NonNull
    @Override
    public layout_Monan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_monan, parent, false);
        return new layout_Monan(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull layout_Monan holder, int position) {
        holder.name.setText(monAn.get(position).getTenmon());
        holder.thoigian.setText(monAn.get(position).getThoigian());
        holder.kcal.setText(monAn.get(position).getKcal());
        holder.imghinh.setImageResource(monAn.get(position).getHinh());
    }

    @Override
    public int getItemCount() {
        return monAn.size();
    }
   public class layout_Monan extends RecyclerView.ViewHolder{
        TextView name,thoigian, kcal;
        ImageView imghinh;
        ConstraintLayout mainLayout;

        public layout_Monan(@NonNull View itemView) {
            super(itemView);
                name = itemView.findViewById(R.id.name);
                thoigian = itemView.findViewById(R.id.thoigian);
                kcal = itemView.findViewById(R.id.kcal);
                imghinh = itemView.findViewById(R.id.imagehinh);

        }


    }


}
