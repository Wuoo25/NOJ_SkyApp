package com.example.mywork10.UI.Notification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.GroundAdapter;
import com.example.mywork10.UI.Home.Adapter.NewsAdapter;
import com.example.mywork10.UI.Home.Adapter.NotiAdapter;

/**
 * 教学详情
 */
public class Noti_grid_Activity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Toolbar toolbar;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noti_grid);

        Intent intent = getIntent();
        Integer Photos=intent.getIntExtra(NotiAdapter.PhotoS,0);
        String Titles=intent.getStringExtra(NotiAdapter.TitleS);
        String longContent=intent.getStringExtra(NotiAdapter.LongContent);

        imageView=findViewById(R.id.grid_img_noti);
        textView=findViewById(R.id.grid_txt_noti);
        toolbar=findViewById(R.id.my_noti_toolbar);
        content=findViewById(R.id.grid_txt_noti_content);

        imageView.setImageResource(Photos);
        textView.setText(Titles);
        content.setText(longContent);

    }
}