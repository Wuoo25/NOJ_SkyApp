package com.example.mywork10.Bean;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
/**
 * 留言
 */
@Entity(tableName = "comments")
public class CommentBean {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private Integer Comment_id;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "date")
    private String date;


    public CommentBean( String comment, String date) {
        this.comment = comment;
        this.date = date;
    }

    public Integer getComment_id() {
        return Comment_id;
    }

    public void setComment_id(Integer comment_id) {
        Comment_id = comment_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
