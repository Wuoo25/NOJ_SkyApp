package com.example.mywork10.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mywork10.Bean.CommentBean;
import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.DAO.CommentDao;

/**
 * 数据库
 */
@Database(entities = {CommentBean.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract CommentDao commentDao();

    //要使用单例模式必须在内部将自身进行如下定义
    private static AppDataBase INSTANCE;
    //参数根据需求进行设计
    public static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            //如果为空实例化，在一个进行实例化时，锁住另一个
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    //允许主线程操作（不建议）
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "WzjDB").allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;
    }
}
