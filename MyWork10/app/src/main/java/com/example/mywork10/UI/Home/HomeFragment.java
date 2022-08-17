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
import com.example.mywork10.UI.Home.Equipment.EquipFragment;
import com.example.mywork10.UI.Home.Ground.GroundFragment;
import com.google.android.material.tabs.TabLayout;

/**
 * 首页页面
 */
public class HomeFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private EquipFragment equipFragment;
    private GroundFragment groundFragment;
    private LikeFragment likeFragment;

    /**
     * Tab滑动页面切换
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            //fragment页面绘制
            view=inflater.inflate(R.layout.fragment_home,container,false);
            viewPager=view.findViewById(R.id.home_page);
            tabLayout=view.findViewById(R.id.home_tab);
            equipFragment=new EquipFragment();
            groundFragment=new GroundFragment();
            likeFragment=new LikeFragment();
            //ViewPager适配器
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
            //添加页面
            viewPagerAdapter.addFragment(equipFragment, "器材");
            viewPagerAdapter.addFragment(groundFragment, "场地");
            viewPagerAdapter.addFragment(likeFragment, "心愿单");
            viewPager.setAdapter(viewPagerAdapter);
            //联系tab与viewPager
            tabLayout.setupWithViewPager(viewPager);
        return view;
        // Inflate the layout for this fragment
    }

    //跳转收藏栏函数
    public void ChangeToFa(){
        viewPager.setCurrentItem(2);
    }

}