package com.example.mywork10.Bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 场地
 */
@Entity(tableName = "grounds")
public class GroundBean {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer Ground_id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "content")
    private String content;
    //是否收藏默认为0（未收藏）
    @ColumnInfo(name = "isFavorite")
    private Integer isFavorite;

    public GroundBean(String name,String longContent,Integer is_favorite) {
        this.name = name;
        content=longContent;
        isFavorite=is_favorite;
    }

    public GroundBean(Integer ground_id) {
        Ground_id = ground_id;
    }

    public Integer getGround_id() {
        return Ground_id;
    }

    public void setGround_id(Integer ground_id) {
        Ground_id = ground_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setCount(String count) {
        this.content = count;
    }

}
