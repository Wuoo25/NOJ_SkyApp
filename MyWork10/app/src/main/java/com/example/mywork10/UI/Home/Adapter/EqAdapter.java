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

import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Equipment.Equip_grid_Activity;

import java.util.List;

/**
 * 器材适配器
 */
public class EqAdapter extends RecyclerView.Adapter <EqAdapter.EqViewHolder>{

    Context context;
    private List<EquipmentBean> equipmentBeanList;
    public static final String PhotoS="photo";
    public static final String TitleS="title";
    public static final String LongContent="long_content";

    public EqAdapter(List<EquipmentBean> equipmentBeanList, Context context){
        this.context=context;
        this.equipmentBeanList = equipmentBeanList;
    }

    class EqViewHolder extends RecyclerView.ViewHolder{
        private ImageView grid_imgM;
        private TextView grid_txtM;
        public EqViewHolder(@NonNull View itemView) {
            super(itemView);
            grid_imgM = itemView.findViewById(R.id.grid_imgM);
            grid_txtM = itemView.findViewById(R.id.grid_txtM);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //页面跳转
                    Intent intent=new Intent(context, Equip_grid_Activity.class);
                    Integer ImgId= (Integer) equipmentBeanList.get(getAdapterPosition()).getImgId();
                    String Title=(String) equipmentBeanList.get(getAdapterPosition()).getName();
                    String Content=(String) equipmentBeanList.get(getAdapterPosition()).getContent();
                    //传值
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
    public EqAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equip_item, parent, false);//是否插入父空间
        //绑定页面
        EqViewHolder holder = new EqViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull EqAdapter.EqViewHolder holder, int position) {
        //绑定数据
        //设置显示的图片
        holder.grid_imgM.setImageResource(equipmentBeanList.get(position).getImgId());
        //设置显示的文字
        holder.grid_txtM.setText(equipmentBeanList.get(position).getName());
    }
    @Override
    public int getItemCount() {
        //设置显示的item数量为List列表的元素的数量
        return equipmentBeanList.size();
    }
}
