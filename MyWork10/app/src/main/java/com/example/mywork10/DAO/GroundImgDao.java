package com.example.mywork10.DAO;

import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.Bean.GroundImg;
import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

public class GroundImgDao {

    public static List<GroundImg> getListImg() {
        List<GroundImg> imgList = new ArrayList<>();
        int imgId[] = {
                R.mipmap.baolongshan,R.mipmap.longshan,R.mipmap.songmingyan

        };
        //创建一个equipment的对象数组
        GroundImg groundImgs[]=new GroundImg[imgId.length];

        //为fruitList列表添加元素
        for (int i = 0; i < imgId.length; i++) {
            groundImgs[i] = new GroundImg(imgId[i]);
            //将每一个数组元素分别添加到fruitList列表中
            imgList.add(groundImgs[i]);
        }

        //最后返回一个List<>的列表
        return imgList;
    }

    public static List<GroundImg> getListImgLike() {
        List<GroundImg> imgList = new ArrayList<>();
        int imgId[] = {
                R.mipmap.baolongshan,R.mipmap.songmingyan

        };
        //创建一个equipment的对象数组
        GroundImg groundImgs[]=new GroundImg[imgId.length];

        //为fruitList列表添加元素
        for (int i = 0; i < imgId.length; i++) {
            groundImgs[i] = new GroundImg(imgId[i]);
            //将每一个数组元素分别添加到fruitList列表中
            imgList.add(groundImgs[i]);
        }

        //最后返回一个List<>的列表
        return imgList;
    }


}
