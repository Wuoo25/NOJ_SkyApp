package com.example.mywork10.UI.Home.Ground;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mywork10.DAO.GroundDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.EqAdapter;
import com.example.mywork10.UI.Home.Adapter.GroundAdapter;
import com.example.mywork10.UI.Home.Comment.CommentActivity;
import com.example.mywork10.Utils.ToastUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class Ground_grid_Activity extends AppCompatActivity {
    //跳转页面

    ImageView imageView;
    TextView textView;
    Toolbar toolbar;
    ImageButton button;
    FloatingActionButton floatingActionButton;
    TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ground_grid);
        //页面跳转传值
        Intent intent = getIntent();
        Integer Photos=intent.getIntExtra(GroundAdapter.PhotoS,0);
        String Titles=intent.getStringExtra(GroundAdapter.TitleS);
        String Content=intent.getStringExtra(GroundAdapter.LongContent);
        //实例化
        imageView =findViewById(R.id.grid_img_ground);
        textView = findViewById(R.id.ground_toolbar_title);
        toolbar=findViewById(R.id.my_ground_toolbar);
        button=findViewById(R.id.ground_button);
        floatingActionButton=findViewById(R.id.fab);
        content=findViewById(R.id.grid_content_ground);
        //赋值
        imageView.setImageResource(Photos);
        textView.setText(Titles);
        textView.setTextSize(16);
        content.setText(Content);
        Context context=this;
        //悬浮按钮，点击进入留言板
       floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,CommentActivity.class);
                context.startActivity(intent);
            }
        });

    }
    /**
     * 收藏按钮
     */
    public void GR_Favorite(View view){
        //Toast工具类
        ToastUtils.show("收藏成功！");
    }

}