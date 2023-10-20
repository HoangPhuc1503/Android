package com.example.app_nauan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.app_nauan.adapter.MonAnAdapter;
import com.example.app_nauan.model.MonAn;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.recycler_monan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        List<MonAn> arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Thịt kho tàu","15 phút", "280 kcal", R.drawable.thanh_pham));
        arrayList.add(new MonAn("Bún bò huế","25 phút", "370 kcal", R.drawable.thanh_pham_bunbo));
        arrayList.add(new MonAn("Canh mướp đắng","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
        arrayList.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
        arrayList.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));

        MonAnAdapter adapter = new MonAnAdapter(arrayList);
        recyclerView.setAdapter(adapter);
    }
}