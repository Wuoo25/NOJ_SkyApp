package com.example.mywork10.UI.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NotiBean;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.News.News_grid_Activity;
import com.example.mywork10.UI.Notification.Noti_grid_Activity;

import java.util.List;

/**
 * 教学适配器
 */
public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.BaseViewHolder> {

    Context context;
    private  List<NotiBean> dataList;
    public static final String PhotoS="photo";
    public static final String TitleS="title";
    public static final String LongContent="long_content";
    public NotiAdapter(List<NotiBean> dataList, Context context) {
        this.context=context;
        this.dataList = dataList;
    }
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView grid_imgM;
        private TextView grid_txtM;

        public BaseViewHolder(View itemView) {
            super(itemView);
            grid_imgM = itemView.findViewById(R.id.grid_noti_bk);
            grid_txtM = itemView.findViewById(R.id.grid_txtNo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //页面跳转-教学详情
                    Intent intent=new Intent(context, Noti_grid_Activity.class);
                    //传值
                    Integer ImgId= (Integer) dataList.get(getAdapterPosition()).getNo_imgId();
                    String Title=(String) dataList.get(getAdapterPosition()).getNo_Title();
                    String Content=dataList.get(getAdapterPosition()).getNoLongContent();
                    //赋值
                    intent.putExtra(PhotoS,ImgId);
                    intent.putExtra(TitleS,Title);
                    intent.putExtra(LongContent,Content);
                    context.startActivity(intent);
                }
            });

        }
    }

    @NonNull
    @Override
    public NotiAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noti_item, parent, false);//是否插入父空间
        //绑定页面
        NotiAdapter.BaseViewHolder holder=new BaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotiAdapter.BaseViewHolder holder, int position) {
        //绑定数据
        //设置显示的图片
        holder.grid_imgM.setImageResource(dataList.get(position).getNo_imgId());
        //设置显示的文字
        holder.grid_txtM.setText(dataList.get(position).getNo_Title());
    }

    @Override
    public int getItemCount() {
        //设置显示的item数量为List列表的元素的数量
        return dataList.size();
    }

}
