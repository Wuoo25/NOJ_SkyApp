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

import com.example.mywork10.Bean.CommentBean;
import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Equipment.Equip_grid_Activity;

import java.util.List;
/**
 * 留言板适配器
 */
public class ComAdapter extends RecyclerView.Adapter <ComAdapter.EqViewHolder>{

    Context context;
    private List<CommentBean> commentBeanList;
    public ComAdapter(List<CommentBean> commentBeanList, Context context){

        this.context=context;
        this.commentBeanList = commentBeanList;
    }
    class EqViewHolder extends RecyclerView.ViewHolder{
        private TextView comment;
        private TextView date;
        public EqViewHolder(@NonNull View itemView) {
            super(itemView);
            comment = itemView.findViewById(R.id.grid_txtComment);
            date = itemView.findViewById(R.id.grid_txtDate);
        }
    }
    @NonNull
    @Override
    public ComAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);//是否插入父空间
        //绑定页面
        EqViewHolder holder = new EqViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ComAdapter.EqViewHolder holder, int position) {
        //绑定数据
        holder.comment.setText(commentBeanList.get(position).getComment());
        holder.date.setText(commentBeanList.get(position).getDate());
    }
    @Override
    public int getItemCount() {
        return commentBeanList.size();
    }



}
