package com.example.mywork10.Bean;

/**
 * 教学
 */
public class NotiBean {

    private Integer No_id;
    private String No_Title;
    private Integer No_imgId;
    private String No_imgUrl;
    private String No_ShortContent;
    private String NoLongContent;

    public NotiBean(String no_Title, Integer no_imgId,String longContent) {
        No_Title = no_Title;
        No_imgId = no_imgId;
        NoLongContent=longContent;
    }

    public Integer getNo_id() {
        return No_id;
    }

    public void setNo_id(Integer no_id) {
        No_id = no_id;
    }

    public String getNo_Title() {
        return No_Title;
    }

    public void setNo_Title(String no_Title) {
        No_Title = no_Title;
    }

    public Integer getNo_imgId() {
        return No_imgId;
    }

    public void setNo_imgId(Integer no_imgId) {
        No_imgId = no_imgId;
    }

    public String getNo_ShortContent() {
        return No_ShortContent;
    }

    public void setNo_ShortContent(String no_ShortContent) {
        No_ShortContent = no_ShortContent;
    }

    public String getNoLongContent() {
        return NoLongContent;
    }

    public void setNoLongContent(String noLongContent) {
        NoLongContent = noLongContent;
    }
}
