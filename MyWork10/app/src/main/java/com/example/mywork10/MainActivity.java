package com.example.mywork10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mywork10.UI.Home.LikeFragment;
import com.example.mywork10.UI.Home.News.NewsFragment;
import com.example.mywork10.UI.Home.HomeFragment;
import com.example.mywork10.UI.Login.LoginActivity;
import com.example.mywork10.UI.Login.RegisterActivity;
import com.example.mywork10.UI.Notification.NotificationFragment;
import com.example.mywork10.Utils.ToastUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //变量定义
    private BottomNavigationView btmView;
    private FrameLayout navContainer;
    private static NewsFragment dbFragment;
    private HomeFragment homeFragment;
    private NotificationFragment notFragment;
    private LikeFragment likeFragment;

    DrawerLayout mDrawerLayout;//根布局
    NavigationView mLeftView;//侧边栏布局
    View mContent;//主页面布局
    ImageButton imageButton;
    Context mContext;
    Button notLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeFragment=new LikeFragment();
        mContext=this;
        //获取根布局
        mDrawerLayout = findViewById(R.id.drawer_layout_root);
        //获取侧边栏布局
        mLeftView = findViewById(R.id.drawer_start);
        notLogin=findViewById(R.id.not_login);
        mContent=mDrawerLayout.getChildAt(0);
        //获取用户头像和昵称布局
        View headerView = mLeftView.getHeaderView(0);
        RelativeLayout rlHeader = headerView.findViewById(R.id.rl_header);
        //获取TextView
        TextView username=headerView.findViewById(R.id.user_name);
        rlHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //修改用户名弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_pets_24);
                builder.setTitle("确定修改用户名吗");
                //通过LayoutInflater来加载一个xml的布局文件作为一个View对象
                View dia_v = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
                //设置我们自己定义的布局文件作为弹出框的Content
                builder.setView(dia_v);
                //弹窗editText
                final EditText change_username = (EditText)dia_v.findViewById(R.id.change_username);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String a = change_username.getText().toString();
                        if(TextUtils.isEmpty(a)){
                            ToastUtils.show("内容为空");
                            return;
                        }
                        //修改昵称
                        username.setText(a);
                        //将输入的用户名和密码打印出来
                        ToastUtils.show("修改成功！");
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                    }
                });
                builder.show();
            }
        });

        //侧滑菜单项跳转
        mLeftView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_like:
                        //跳转首页
                        initTab(0);
                        //调用自定义函数跳转切换至收藏页面
                        homeFragment.ChangeToFa();
                        return true;
                    case R.id.go_login:
                        //跳转注册
                        Intent intent =new Intent(mContext, RegisterActivity.class);
                        mContext.startActivity(intent);
                        return true;
                }
                return false;
            }
        });

        //点击展示侧滑菜单
        imageButton=findViewById(R.id.Head_img);
        imageButton.setImageResource(R.drawable.ic_perm_24);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //三个fragment、fragmentLayout定义
        navContainer=findViewById(R.id.nav_container);
        btmView=findViewById(R.id.bottom_navigation);
        btmView.setOnItemSelectedListener(mNavListener);
        btmView.setSelectedItemId(R.id.navigation_home);
        //开启事务，进行页面切换（底部导航栏）
        initTab(0);
    }

    /**
     * 底部导航栏
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mNavListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    //调用切换页面函数，转至主页面
                    initTab(0);
                    return true;
                case R.id.navigation_news:
                    //调用切换页面函数，转至资讯页面
                    initTab(1);
                    return true;
                case R.id.navigation_notifications:
                    //调用切换页面函数，转至教学页面
                    initTab(2);
                    return true;
            }
            return false;
        }
    };
    /**
     * 底部导航栏页面切换
     * @param position
     */
    private void initTab(int position){
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //防止重复刷新，采用hide，show方式，调用hideFragment方法进行页面隐藏
        hideFragments(transaction);
        switch (position){
            //判断并切换首页页面
            case 0:
                if (homeFragment == null){
                    homeFragment=new HomeFragment();
                    transaction.add(R.id.nav_container,homeFragment);
                }else {
                    transaction.show(homeFragment);
                }
                break;
            //判断并切换资讯页面
            case 1:
                if (dbFragment == null){
                    dbFragment=new NewsFragment();
                    transaction.add(R.id.nav_container,dbFragment);
                }else {
                    transaction.show(dbFragment);
                }
                break;
            //判断并切换教学页面
            case 2:
                if (notFragment == null){
                    notFragment=new NotificationFragment();
                    transaction.add(R.id.nav_container,notFragment);
                }else {
                    transaction.show(notFragment);
                }
                break;
        }
        transaction.commitNowAllowingStateLoss();
    }

    /**
     * 判断页面
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction){
        if (homeFragment != null){
            //隐藏首页
            transaction.hide(homeFragment);
        }
        if (dbFragment != null){
            //隐藏资讯页面
            transaction.hide(dbFragment);
        }
        if (notFragment != null){
            //隐藏教学页面
            transaction.hide(notFragment);
        }
    }

    /**
     * 取消登录按钮跳转
     * @param view
     */
    public void NotLogin(View view){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}