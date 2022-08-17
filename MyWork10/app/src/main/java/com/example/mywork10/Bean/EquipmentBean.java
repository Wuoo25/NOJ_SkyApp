package com.example.mywork10.Bean;

/**
 * 器材
 */
public class EquipmentBean {

    private Integer Equipment_id;
    private String name;
    private String  imgUrl;
    private Integer imgId;
    private String content;


    public EquipmentBean(String name, int imgId,String Content) {
        this.name = name;
        this.imgId = imgId;
        content=Content;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String count) {
        this.content = count;
    }

}
