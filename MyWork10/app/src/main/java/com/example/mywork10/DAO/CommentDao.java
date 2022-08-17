package com.example.mywork10.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mywork10.Bean.CommentBean;

import java.util.List;

@Dao
public interface CommentDao {

    @Query("SELECT * FROM comments")
    List<CommentBean> getAllFromDb();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CommentBean commentBeans);

    @Delete
    void delete(CommentBean commentBean);

    @Update
    public void updateOnePlayer(CommentBean commentBean);


}
