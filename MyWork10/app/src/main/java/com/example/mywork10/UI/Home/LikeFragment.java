package com.example.mywork10.UI.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.ViewPagerAdapter;
import com.example.mywork10.UI.Home.Ground.GroundFragment;
import com.example.mywork10.UI.Home.Ground.GroundLikeFragment;
import com.example.mywork10.UI.Home.News.NewsLikeFragment;

import java.util.ArrayList;

/**
 * 心愿单页面
 */
public class LikeFragment extends Fragment{


    private com.example.mywork10.Utils.ViewPager.VerticalTabLayout mTab;
    private ViewPager mVp;
    private ArrayList<String> mTitlesList;
    private ArrayList<Fragment> mFragmentsList;
    private NewsLikeFragment newsLikeFragment;
    private GroundLikeFragment groundLikeFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_like,container,false);

        mTab=view.findViewById(R.id.like_tab);
        mVp =  view.findViewById(R.id.like_viewPager);
        //初始化Tab栏数据
        mTitlesList = new ArrayList<>();
        mTitlesList.add("场地");
        mTitlesList.add("赛事");
        //页面实例化
        newsLikeFragment =new NewsLikeFragment();
        groundLikeFragment=new GroundLikeFragment();
        //添加fragment碎片
        mFragmentsList = new ArrayList<>();
        mFragmentsList.add(new GroundFragment());
        mFragmentsList.add(new NewsLikeFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        //为适配器添加fragment
        viewPagerAdapter.addFragment(groundLikeFragment, "场地");
        viewPagerAdapter.addFragment(newsLikeFragment, "赛事");
        mVp.setAdapter(viewPagerAdapter);
        //联系tab与viewPager
        mTab.setupWithViewPager(mVp);
        return view;
    }


}