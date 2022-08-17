package com.example.mywork10.UI.Home.News;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.Bean.GroundImg;
import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NewsImg;
import com.example.mywork10.DAO.NewsDao;
import com.example.mywork10.DAO.NewsImgDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.EqAdapter;
import com.example.mywork10.UI.Home.Adapter.NewsAdapter;
import com.example.mywork10.UI.Home.Equipment.EquipFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻页面
 */
public class NewsFragment extends Fragment {

    private RecyclerView mRecycler;
    private NewsAdapter myAdapter;
    private List<NewsBean> newsBeanList = new ArrayList<>();
    private List<NewsImg> newsImgList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //fragment页面绘制
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        super.onCreate(savedInstanceState);
        mRecycler = view.findViewById(R.id.news_recycler);
        //获取新闻列表
        newsBeanList=NewsDao.getList();
        //获取新闻图片列表
        newsImgList= NewsImgDao.getListImg();
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        myAdapter = new NewsAdapter(newsBeanList,newsImgList, this.getActivity());
        //定义布局管理器为Liner管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        //设置布局管理器为线性布局管理器
        mRecycler.setLayoutManager(layoutManager);
        //设置适配器
        mRecycler.setAdapter(myAdapter);
        //设置分隔线
        //mRecycler.addItemDecoration(new NewsFragment().MyDecoration());
        // Inflate the layout for this fragment
        return view;

    }




}
