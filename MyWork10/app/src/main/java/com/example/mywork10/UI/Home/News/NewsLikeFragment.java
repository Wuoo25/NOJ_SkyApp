package com.example.mywork10.UI.Home.News;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NewsImg;
import com.example.mywork10.DAO.NewsDao;
import com.example.mywork10.DAO.NewsImgDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻收藏页面
 */
public class NewsLikeFragment extends Fragment {

    private RecyclerView mRecycler;
    private NewsAdapter myAdapter;
    private List<NewsBean> newsBeanList = new ArrayList<>();
    private List<NewsImg> newsImgList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //fragment页面绘制
        View view = inflater.inflate(R.layout.fragment_news_like, container, false);
        super.onCreate(savedInstanceState);

        mRecycler = view.findViewById(R.id.news_like_recycler);
        newsBeanList=NewsDao.getListLike();
        newsImgList= NewsImgDao.getListImgLike();
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        myAdapter = new NewsAdapter(newsBeanList,newsImgList,this.getActivity());

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
