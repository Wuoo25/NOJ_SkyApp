package com.example.mywork10.Bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻
 */
@Entity(tableName = "news")
public class NewsBean {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer News_id;
    @ColumnInfo(name = "title")
    private String Title;
    @ColumnInfo(name = "LongContent")
    private String LongContent;
    @ColumnInfo(name = "isFavorite")
    private Integer isFavorite;

    public NewsBean( String title,String longContent,Integer is_favorite) {
        Title = title;
        LongContent=longContent;
        isFavorite=is_favorite;
    }

    public Integer getNews_id() {
        return News_id;
    }

    public void setNews_id(Integer news_id) {
        News_id = news_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLongContent() {
        return LongContent;
    }

    public void setLongContent(String longContent) {
        LongContent = longContent;
    }
}
