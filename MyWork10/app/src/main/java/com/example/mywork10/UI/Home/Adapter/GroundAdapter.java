package com.example.mywork10.UI.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.Bean.GroundImg;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Equipment.Equip_grid_Activity;
import com.example.mywork10.UI.Home.Ground.Ground_grid_Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 场地适配器
 */
public class GroundAdapter extends RecyclerView.Adapter<GroundAdapter.BaseViewHolder> {

    Context context;
    private List<GroundBean> dataList;
    private List<GroundImg> ImgList;
    public static final String PhotoS="photo";
    public static final String TitleS="title";
    public static final String LongContent="long_content";
    public GroundAdapter(List<GroundBean> dataList, List<GroundImg> imgList,Context context) {
        this.context=context;
        this.dataList = dataList;
        this.ImgList=imgList;
    }
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView grid_imgM;
        private TextView grid_txtM;

        public BaseViewHolder(View itemView) {
            super(itemView);
            grid_imgM = itemView.findViewById(R.id.grid_imgG);
            grid_txtM = itemView.findViewById(R.id.grid_txtG);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, Ground_grid_Activity.class);
                    //传值
                    Integer ImgId= (Integer) ImgList.get(getAdapterPosition()).getImgId();
                    String Title=(String) dataList.get(getAdapterPosition()).getName();
                    String Content=(String) dataList.get(getAdapterPosition()).getContent();
                    //intent进行传值
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
    public GroundAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ground_item, parent, false);//是否插入父空间
        //绑定页面
        GroundAdapter.BaseViewHolder holder=new BaseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GroundAdapter.BaseViewHolder holder, int position) {
        //绑定数据
        //设置显示的图片
        holder.grid_imgM.setImageResource(ImgList.get(position).getImgId());
        //设置显示的文字
        holder.grid_txtM.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        //设置显示的item数量为List列表的元素的数量
        return dataList.size();
    }

}
