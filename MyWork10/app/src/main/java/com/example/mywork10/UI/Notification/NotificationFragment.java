package com.example.mywork10.UI.Notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NotiBean;
import com.example.mywork10.DAO.NewsDao;
import com.example.mywork10.DAO.NotiDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.NewsAdapter;
import com.example.mywork10.UI.Home.Adapter.NotiAdapter;
import com.example.mywork10.UI.Home.Adapter.ViewPagerAdapter;
import com.example.mywork10.UI.Home.Equipment.EquipFragment;
import com.example.mywork10.UI.Home.Ground.GroundFragment;
import com.example.mywork10.UI.Home.LikeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 教学页面
 */
public class NotificationFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private NotificationFrFragment frFragment;
    private NotificationSeFragment seFragment;
    private NotificationThFragment thFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //fragment页面绘制
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        //将getList的列表全部添加到List中
        super.onCreate(savedInstanceState);

        viewPager=view.findViewById(R.id.not_page);
        tabLayout=view.findViewById(R.id.not_tab);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frFragment=new NotificationFrFragment();
        seFragment=new NotificationSeFragment();
        thFragment=new NotificationThFragment();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), 0);
        viewPagerAdapter.addFragment(frFragment, "初级");
        viewPagerAdapter.addFragment(seFragment, "中级");
        viewPagerAdapter.addFragment(thFragment, "高级");
        viewPager.setAdapter(viewPagerAdapter);
        //联系tab与viewPager
        tabLayout.setupWithViewPager(viewPager);

    }
}