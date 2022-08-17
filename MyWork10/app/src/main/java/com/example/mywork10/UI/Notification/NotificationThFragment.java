package com.example.mywork10.UI.Notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywork10.Bean.NotiBean;
import com.example.mywork10.DAO.NotiDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.NotiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 高级教学页面
 */
public class NotificationThFragment extends Fragment {

    private RecyclerView mRecycler;
    private NotiAdapter myAdapter;
    private Spinner mSpinner;
    private List<NotiBean> notiBeanList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //fragment页面绘制
        View view = inflater.inflate(R.layout.fragment_th_notifi, container, false);
        //将getList的列表全部添加到List中
        super.onCreate(savedInstanceState);

        notiBeanList= NotiDao.getList3();
        mRecycler=view.findViewById(R.id.notification_th_recycler);
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        myAdapter = new NotiAdapter(notiBeanList, this.getActivity());
        //定义布局管理器为Liner管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        //设置布局管理器为线性布局管理器
        mRecycler.setLayoutManager(layoutManager);
        //设置适配器
        mRecycler.setAdapter(myAdapter);

        return view;
    }

}