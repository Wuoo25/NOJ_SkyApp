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

import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.Bean.GroundImg;
import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NewsImg;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Ground.Ground_grid_Activity;
import com.example.mywork10.UI.Home.News.News_grid_Activity;

import java.util.List;

/**
 * 新闻适配器
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.BaseViewHolder> {

    Context context;
    private List<NewsBean> dataList;
    private List<NewsImg> ImgList;
    public static final String PhotoS="photo";
    public static final String TitleS="title";
    public static final String LongContent="long_content";
    public NewsAdapter(List<NewsBean> dataList,List<NewsImg> newsImgs, Context context) {
        this.context=context;
        this.dataList = dataList;
        this.ImgList=newsImgs;
    }
    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView grid_imgM;
        private TextView grid_txtM;

        public BaseViewHolder(View itemView) {
            super(itemView);
            grid_imgM = itemView.findViewById(R.id.grid_imgN);
            grid_txtM = itemView.findViewById(R.id.grid_txtN);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, News_grid_Activity.class);
                    //传值
                    Integer ImgId= (Integer) ImgList.get(getAdapterPosition()).getImgId();
                    String Title=(String) dataList.get(getAdapterPosition()).getTitle();
                    String Content=dataList.get(getAdapterPosition()).getLongContent();
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
    public NewsAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);//是否插入父空间
        //绑定页面
        NewsAdapter.BaseViewHolder holder=new BaseViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.BaseViewHolder holder, int position) {
        //绑定数据
        //设置显示的图片
        holder.grid_imgM.setImageResource(ImgList.get(position).getImgId());
        //设置显示的文字
        holder.grid_txtM.setText(dataList.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        //设置显示的item数量为List列表的元素的数量
        return dataList.size();
    }

}
