package com.example.mywork10.UI.Home.Equipment;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.DAO.EquipDao;
import com.example.mywork10.DAO.NewsDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.EqAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 器材页面
 */
public class EquipFragment extends Fragment {

    private RecyclerView mRecycler;
    private EqAdapter myAdapter;
    private  List<EquipmentBean> equipmentBeanList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //fragment页面绘制
        View view=inflater.inflate(R.layout.fragment_equip,container,false);

        //将getList的列表全部添加到List中
        equipmentBeanList= EquipDao.getList();
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        myAdapter = new EqAdapter(equipmentBeanList,this.getActivity());
        //实例化Recycler
        mRecycler = view.findViewById(R.id.recycler);
        //定义布局管理器为Grid管理器，设置一行放3个
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getActivity(),3);
        //设置布局管理器为线性布局管理器
        mRecycler.setLayoutManager(layoutManager);
        //设置适配器
        mRecycler.setAdapter(myAdapter);
        //设置分隔线
        mRecycler.addItemDecoration(new MyDecoration());
        return view;

    }
    //设置网格布局线
     class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //outRect.set()中的参数分别对应左、上、右、下的间隔
            outRect.set(10,10,10,10);
        }
    }

}