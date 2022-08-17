package com.example.mywork10.UI.Home.Ground;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.Bean.GroundImg;
import com.example.mywork10.DAO.GroundDao;
import com.example.mywork10.DAO.GroundImgDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.GroundAdapter;
import com.example.mywork10.Utils.Layout.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 场馆收藏页面
 */
public class GroundLikeFragment extends Fragment {

    private RecyclerView mRecycler;
    private GroundAdapter myAdapter;
    private  List<GroundBean> groundBeanList = new ArrayList<>();
    private List<GroundImg> groundImgList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //fragment页面绘制
        View view=inflater.inflate(R.layout.fragment_ground_like,container,false);
        //数据调用
        groundBeanList=GroundDao.getListLike();
        groundImgList= GroundImgDao.getListImgLike();
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        myAdapter = new GroundAdapter(groundBeanList,groundImgList,this.getActivity());
        //实例化Recycler
        mRecycler = view.findViewById(R.id.re_like_waterfall);

        //定义布局管理器为Grid管理器，设置一行放3个
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器为线性布局管理器
        mRecycler.setLayoutManager(layoutManager);
        //item间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRecycler.addItemDecoration(decoration);
        //设置适配器
        mRecycler.setAdapter(myAdapter);
        //设置分隔线
        mRecycler.addItemDecoration(new GroundLikeFragment.MyDecoration());
        // Inflate the layout for this fragment
        return view;
    }
    //分割线
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //outRect.set()中的参数分别对应左、上、右、下的间隔
            outRect.set(10,10,10,10);
        }
    }

}