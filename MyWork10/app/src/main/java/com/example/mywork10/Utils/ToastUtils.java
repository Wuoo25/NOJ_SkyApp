package com.example.mywork10.Utils;

import android.content.Context;
import android.widget.Toast;

import com.example.mywork10.MyApplication;

/**
 * Toast封装工具类
 */
public class ToastUtils {
    public static void show(int resId) {
        show(MyApplication.getContext().getResources().getString(resId));
    }
    //常用方法
    public static void show(String content) {
        Toast.makeText(MyApplication.getContext(),content,Toast.LENGTH_SHORT).show();
    }
}
