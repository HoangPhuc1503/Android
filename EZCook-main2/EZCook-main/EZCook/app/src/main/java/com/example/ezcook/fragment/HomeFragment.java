package com.example.ezcook.fragment;

import static com.example.ezcook.adapter.h_category_listdata_adapter.CATEGORY_FOODNEW;
import static com.example.ezcook.adapter.h_category_listdata_adapter.CATEGORY_SUGGEST;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ezcook.AnimationUtil;
import com.example.ezcook.MainActivity;
import com.example.ezcook.R;
import com.example.ezcook.adapter.h_category_regime_eat_adapter;
import com.example.ezcook.adapter.h_category_suggest_adapter;
import com.example.ezcook.f_StepCookActivity;
import com.example.ezcook.h_SearchActivity;
import com.example.ezcook.model.h_category_foodnew_model;
import com.example.ezcook.model.h_category_regime_eat_model;
import com.example.ezcook.model.h_category_suggest_model;
import com.example.ezcook.adapter.h_category_listdata_adapter;
import com.example.ezcook.model.h_category_listdata_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private MainActivity mainActivity;

    private RecyclerView recyclerViewRegimeEat, recyclerViewCategoryData;
    private ImageView image_userhome,image_bt_filter;
    private TextView name_userhome;
    private LinearLayout action_search;
    h_category_listdata_adapter categoryListdataAdapter;

    h_category_suggest_adapter categorySuggestAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view_home = inflater.inflate(R.layout.fragment_home, container, false);
        mainActivity = (MainActivity) getActivity();


        Anhxa(view_home);
        show_activity_search();
        regime_recyclerView();
        category_listdata();
        show_fragment_filter();

        showUserInfo();
        return view_home;
    }
    private void Anhxa(View view){

        image_userhome = view.findViewById(R.id.image_userhome);
        name_userhome = view.findViewById(R.id.tv_name_user);
        action_search = view.findViewById(R.id.linear_search);
        image_bt_filter = view.findViewById(R.id.image_bt_filter);

        recyclerViewRegimeEat = view.findViewById(R.id.recycler_category_regime_eat);
        recyclerViewCategoryData = view.findViewById(R.id.recycler_category_data);


//        recyclerViewCategory_suggest = findViewById(R.id.recycler_category_suggest);
    }
    private void show_activity_search(){
        action_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_search = new Intent(mainActivity, h_SearchActivity.class);
                startActivity(intent_search);
            }
        });
    }

    private void show_fragment_filter(){
        image_bt_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void regime_recyclerView(){
        recyclerViewRegimeEat.setHasFixedSize(true);
        recyclerViewRegimeEat.setLayoutManager(new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false));

        List<h_category_regime_eat_model> categoryRegimeEatModels = new ArrayList<>();

        categoryRegimeEatModels.add(new h_category_regime_eat_model(R.drawable.image_buoisang,"Ăn sáng"));
        categoryRegimeEatModels.add(new h_category_regime_eat_model(R.drawable.cat_1,"Ăn trưa"));
        categoryRegimeEatModels.add(new h_category_regime_eat_model(R.drawable.cat_2,"Ăn tối"));
        categoryRegimeEatModels.add(new h_category_regime_eat_model(R.drawable.cat_3,"Ăn kiêng"));
        categoryRegimeEatModels.add(new h_category_regime_eat_model(R.drawable.cat_4,"Ăn chay"));

        h_category_regime_eat_adapter categoryRegimeEatAdapter = new h_category_regime_eat_adapter();
        categoryRegimeEatAdapter.setData(categoryRegimeEatModels);
        recyclerViewRegimeEat.setAdapter(categoryRegimeEatAdapter);
    }
    private void category_listdata(){
        recyclerViewCategoryData.setHasFixedSize(true);
        recyclerViewCategoryData.setLayoutManager(new LinearLayoutManager(mainActivity));

        categoryListdataAdapter = new h_category_listdata_adapter(mainActivity, mainActivity);

        categorySuggestAdapter = new h_category_suggest_adapter();
        categoryListdataAdapter.setData(getListData());
        recyclerViewCategoryData.setAdapter(categoryListdataAdapter);
    }

    private List<h_category_listdata_model> getListData() {

        List<h_category_suggest_model> categorySuggestModels = new ArrayList<>();
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.image_test, "Thịt kho tàu", "20 phút", "300 kcal", R.drawable.h_ic_easy));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.fast_1, "Ếch xào sả ớt", "15 phút", "310 kcal",R.drawable.h_ic_medium));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.fast_2, "Cơm chiên trứng", "25 phút", "290 kcal",R.drawable.h_ic_easy));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.fast_3, "Cơm hải sản", "10 phút", "120 kcal",R.drawable.h_ic_difficult));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.cat_1, "Bò hầm", "20 phút", "300 kcal", R.drawable.h_ic_difficult));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.cat_4, "Tàu hũ nướng", "15 phút", "310 kcal",R.drawable.h_ic_medium));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.cat_2, "Humburger", "25 phút", "290 kcal",R.drawable.h_ic_easy));
        categorySuggestModels.add(new h_category_suggest_model(R.drawable.cat_3, "Mì xào hải sản", "20 phút", "120 kcal",R.drawable.h_ic_easy));



        List<h_category_foodnew_model> categoryFoodnewModels = new ArrayList<>();
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_2, "Thịt kho tàu", "10 phút", "200 kcal", R.drawable.h_ic_user, "Bùi Đức Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_1, "Cơm chiên trứng", "30 phút", "200 kcal", R.drawable.h_ic_user, "Khánh Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_2, "Cơm chiên hải sản", "25 phút", "200 kcal", R.drawable.h_ic_user, "Khánh Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_3, "Thịt kho tàu", "15 phút", "200 kcal", R.drawable.h_ic_user, "Trần Thị Lê Trinh"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.image_test, "Thịt kho", "20 phút", "200 kcal", R.drawable.cat_4, "Khánh Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_2, "Thịt kho tàu", "10 phút", "200 kcal", R.drawable.h_ic_user, "Bùi Đức Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_1, "Thịt kho tàu", "30 phút", "200 kcal", R.drawable.h_ic_user, "Khánh Công"));
        categoryFoodnewModels.add(new h_category_foodnew_model(R.drawable.fast_2, "Cơm chiên hải sản", "25 phút", "200 kcal", R.drawable.h_ic_user, "Khánh Công"));


        List<h_category_listdata_model> categoryListdataModels = new ArrayList<>();
        categoryListdataModels.add(new h_category_listdata_model(CATEGORY_SUGGEST, "Gợi ý hôm nay", categorySuggestModels, null));
        categoryListdataModels.add(new h_category_listdata_model(CATEGORY_FOODNEW, "Món ăn mới nhất", null, categoryFoodnewModels));


        return categoryListdataModels;
    }
    public void showUserInfo(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            return;
        }

        String name_user = user.getDisplayName();
        String email_user = user.getEmail();
        Uri photoUrl = user.getPhotoUrl();
//
        if (name_user == null){
//            name_userhome.setVisibility(View.GONE);
            name_userhome.setText(email_user);
        }
        else {
            name_userhome.setVisibility(View.VISIBLE);
            name_userhome.setText(name_user);
        }

        Glide.with(this).load(photoUrl).error(R.drawable.h_account_circle_24).into(image_userhome);

    }

    @Override
    public void onResume() {
        super.onResume();
        showUserInfo();
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(mainActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.h_bottomsheetlayout_filter);

        LinearLayout row1 = dialog.findViewById(R.id.row1);
        LinearLayout row2 = dialog.findViewById(R.id.row2);
        LinearLayout row3 = dialog.findViewById(R.id.row3);
        LinearLayout row4 = dialog.findViewById(R.id.row4);

        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"Loc theo hang 1",Toast.LENGTH_SHORT).show();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"Loc theo hang 2",Toast.LENGTH_SHORT).show();
            }
        });

        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"Loc theo hang 3",Toast.LENGTH_SHORT).show();

            }
        });

        row4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"Loc theo hang 4",Toast.LENGTH_SHORT).show();

            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialoAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
