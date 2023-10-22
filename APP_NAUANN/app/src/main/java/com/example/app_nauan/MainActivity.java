package com.example.app_nauan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_nauan.adapter.MonAnAdapter;
import com.example.app_nauan.model.MonAn;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Button monan_btn,yeuthich_btn,bottomsheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomsheet = findViewById(R.id.bottom_sheet);
        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView = findViewById(R.id.recycler_monan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        monan_btn = findViewById(R.id.monan_btn);
        yeuthich_btn = findViewById(R.id.yeuthich_btn);
        monan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MonAn> arrayList = new ArrayList<>();
                arrayList.add(new MonAn("Thịt kho tàu","15 phút", "280 kcal", R.drawable.thanh_pham));
                arrayList.add(new MonAn("Bún bò huế","25 phút", "370 kcal", R.drawable.thanh_pham_bunbo));
                arrayList.add(new MonAn("Canh mướp đắng","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
                arrayList.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
                arrayList.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
                arrayList.add(new MonAn("Canh mướp đắng","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
                arrayList.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
                arrayList.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
                MonAnAdapter adapter = new MonAnAdapter(arrayList);
                recyclerView.setAdapter(adapter);
            }
        });
        yeuthich_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MonAn> arrayList = new ArrayList<>();
                arrayList.add(new MonAn("Thịt ","15 phút", "280 kcal", R.drawable.thanh_pham));
                arrayList.add(new MonAn("Bún bò ","25 phút", "370 kcal", R.drawable.thanh_pham_bunbo));
                arrayList.add(new MonAn("Canh ","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
                arrayList.add(new MonAn("Sườn rim ","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
                arrayList.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
                arrayList.add(new MonAn("Canh mướp ","45 phút", "330 kcal", R.drawable.thanh_pham_canhmuopdang));
                arrayList.add(new MonAn("Sườn rim ngọt","30 phút", "330 kcal", R.drawable.thanh_pham_suonrim));
                arrayList.add(new MonAn("Thị kho","45 phút", "330 kcal", R.drawable.thanh_pham));
                MonAnAdapter adapter = new MonAnAdapter(arrayList);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomsheetlayout);

        LinearLayout layoutSetting = dialog.findViewById(R.id.layoutSetting);
        LinearLayout layoutCaNhan = dialog.findViewById(R.id.layoutCaNhan);
        LinearLayout layoutQR = dialog.findViewById(R.id.layoutQR);
        LinearLayout layoutHD = dialog.findViewById(R.id.layoutHD);

        layoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintenSetting = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(myintenSetting);
            }
        });

        layoutCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintenSettingUser = new Intent(MainActivity.this,SettingUserActivity.class);
                startActivity(myintenSettingUser);
            }
        });

        layoutQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"QR is click",Toast.LENGTH_SHORT).show();
            }
        });

        layoutHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Hoạt động is click",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}