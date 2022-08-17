package com.example.mywork10.UI.Home.Equipment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.EqAdapter;
/**
 * 器材详情页面
 */
public class Equip_grid_Activity extends AppCompatActivity {
    //跳转页面

    ImageView imageView;
    TextView textView;
    Toolbar toolbar;
    TextView content;
    ImageButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equip_grid);
        //页面跳转
        Intent intent = getIntent();
        Integer Photos=intent.getIntExtra(EqAdapter.PhotoS,0);
        String Titles=intent.getStringExtra(EqAdapter.TitleS);
        String Content=intent.getStringExtra(EqAdapter.LongContent);
        //控件
        imageView =findViewById(R.id.grid_img);
        textView = findViewById(R.id.equip_toolbar_title);
        toolbar=findViewById(R.id.my_equipment_toolbar);
        content=findViewById(R.id.grid_txt);
        //赋值
        imageView.setImageResource(Photos);
        textView.setText(Titles);
        content.setText(Content);
    }

}