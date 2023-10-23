package com.example.app_nauan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_nauan.R;
import com.example.app_nauan.adapter.AdapterMonAn;
import com.example.app_nauan.model.MonAn;

import java.util.ArrayList;
import java.util.List;


public class BaiDang_Fragment extends Fragment {

    private RecyclerView rcvMonAn;
    private View mView;
    public BaiDang_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_bai_dang_,container,false);
        rcvMonAn = mView.findViewById(R.id.recycler_monan);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rcvMonAn.setLayoutManager(linearLayoutManager);

        AdapterMonAn adapterMonAn = new AdapterMonAn();
        adapterMonAn.setData(getListMonAn());

        rcvMonAn.setAdapter(adapterMonAn);

        return mView;
    }
    private List<MonAn> getListMonAn(){
        List<MonAn> list = new ArrayList<>();
        list.add(new MonAn("Thịt kho tàu","15 phút", "280 kcal", R.drawable.thanh_pham));
        list.add(new MonAn("Bún bò huế","25 phút", "370 kcal", R.drawable.thanh_pham_bunbo));
        list.add(new MonAn("Canh mướp đắng","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
        list.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
        list.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
        list.add(new MonAn("Canh mướp đắng","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
        list.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
        list.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
        return list;
    }
}