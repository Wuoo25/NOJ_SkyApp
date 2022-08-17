package com.example.mywork10.UI.Home.Comment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mywork10.Bean.CommentBean;
import com.example.mywork10.DAO.CommentDao;
import com.example.mywork10.DataBase.AppDataBase;
import com.example.mywork10.R;
import com.example.mywork10.UI.Home.Adapter.ComAdapter;
import com.example.mywork10.Utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 留言板页面
 */
public class CommentActivity extends AppCompatActivity {

    private RecyclerView myRecycler;
    private EditText editText;
    private ImageButton imageButton;
    private List<CommentBean> mCommentBeanList = new ArrayList<>();
    private CommentDao commentDao;
    private ComAdapter mAdapter;
    //Handler主要用于异步消息的处理
    //handler通知主线程刷新数据
    private final Handler mHandler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //先设置布局，访问布局中的组件
        editText = findViewById(R.id.comment_content);
        imageButton = findViewById(R.id.send);
        //初始化recyclerview
        myRecycler = findViewById(R.id.comment_recycler);
        //实例化Adapter并调用带参数的构造方法传一个List的列表
        mAdapter = new ComAdapter(mCommentBeanList, this);
        //定义布局管理器为Liner管理器
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器为线性布局管理器
        myRecycler.setLayoutManager(layoutManager);
        //设置适配器
        myRecycler.setAdapter(mAdapter);
        //实例化CommentDao
        commentDao = AppDataBase.getInstance(this).commentDao();
        //添加初始化数据
        addList();
    }


    /**
     * 发送
     */
    public void sendComment(View view) {
        String com = editText.getText().toString();
        //判空
        if (TextUtils.isEmpty(com)) {
            ToastUtils.show("内容不能为空");
            return;
        }
        System.out.println(com);
        //子线程插入数据(异步线程)
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                // 设置日期格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = simpleDateFormat.format(date);
                System.out.println(format);//输出格式：2020-02-13 10:30:44
                CommentBean commentBean = new CommentBean(com, format);
                //插入数据
                commentDao.insert(commentBean);
                //在子线程中更新UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //列表末尾添加一条评论
                        mCommentBeanList.add(commentBean);
                        //RecyclerView列表插入操作
                        mAdapter.notifyItemInserted(mCommentBeanList.size()-1);
                        //清空输入框
                        editText.getText().clear();
                    }
                });
            }
        });
    }

    /**
     * 表中初始化、提取数据
     * @return
     */
    public void addList() {
        //异步执行
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                //子线程插入假的数据（便于初始化）
//                List<CommentBean> list = new ArrayList<>();
//                String comments[] = {"hhh", "fff", "jjj"};
//                String date[] = {"2020-01-13 10:30:44", "2020-02-13 10:40:22", "2021-02-13 10:30:44"};
//
//                CommentBean commentBean;
//                for (int i = 0; i < comments.length; i++) {
//                    //给每一个元素实例化，并将值传入对应元素的构造方法中
//                    commentBean = new CommentBean(comments[i], date[i]);
//                    //将每一个数组元素分别添加到列表中
//                    list.add(commentBean);
//                    commentDao.insert(commentBean);
//                }
                //查询数据库数据
                List<CommentBean> allFromDb = commentDao.getAllFromDb();
                //切换主线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mCommentBeanList.clear();
                        mCommentBeanList.addAll(allFromDb);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
    //如果参数为null，会将所有的Callbacks和Messages全部清除掉。
    //这样做的好处是在activity退出的时候，可以避免内存泄露。
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}