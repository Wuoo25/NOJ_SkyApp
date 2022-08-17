package com.example.mywork10.UI.Home.News;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.DAO.NewsDao;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.GroundAdapter;
import com.example.mywork10.UI.Home.Adapter.NewsAdapter;
import com.example.mywork10.Utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

//新闻详情页面
public class News_grid_Activity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView content;
    ImageButton favorite;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_grid);

        Intent intent = getIntent();
        Integer Photos=intent.getIntExtra(NewsAdapter.PhotoS,0);
        String Titles=intent.getStringExtra(NewsAdapter.TitleS);
        String longContent=intent.getStringExtra(NewsAdapter.LongContent);

        imageView=findViewById(R.id.grid_img_news);
        textView=findViewById(R.id.grid_txt_title);
        content=findViewById(R.id.grid_txt_news);

        imageView.setImageResource(Photos);
        //toolbar.setTitle(Titles);
        textView.setText(Titles);
        content.setText(longContent);
        content.setMovementMethod(ScrollingMovementMethod.getInstance());

    }
    /**
     * 收藏按钮
     */
    public void New_Favorite(View view){
        //Toast工具类
        ToastUtils.show("收藏成功！");
    }

}