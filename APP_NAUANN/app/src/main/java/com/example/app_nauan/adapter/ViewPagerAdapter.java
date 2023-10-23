package com.example.app_nauan.adapter;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.app_nauan.fragment.BaiDang_Fragment;
import com.example.app_nauan.fragment.YeuThich_Fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BaiDang_Fragment();
            case 1:
                return new YeuThich_Fragment();
            default:
                return new BaiDang_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title="";
        switch(position){
            case 0:
                title = "Bài đăng";
                break;
            case 1:
                title = "Yêu thích";
                break;
        }
        return title;
    }
}
