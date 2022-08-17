package com.example.mywork10.DAO;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NewsImg;
import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

public class NewsImgDao {
    public static List<NewsImg> getListImg() {
        List<NewsImg> imgList = new ArrayList<>();
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {
                R.mipmap.news1,R.mipmap.news2

        };
        //创建一个equipment的对象数组
        NewsImg newsImgs[]=new NewsImg[imgId.length];

        //为fruitList列表添加元素
        for (int i = 0; i < imgId.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            newsImgs[i] = new NewsImg(imgId[i]);
            //将每一个数组元素分别添加到fruitList列表中
            imgList.add(newsImgs[i]);
        }

        //最后返回一个List<>的列表
        return imgList;
    }

    public static List<NewsImg> getListImgLike() {
        List<NewsImg> imgList = new ArrayList<>();
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {
                R.mipmap.news1,R.mipmap.news2

        };
        //创建一个equipment的对象数组
        NewsImg newsImgs[]=new NewsImg[imgId.length];

        //为fruitList列表添加元素
        for (int i = 0; i < imgId.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            newsImgs[i] = new NewsImg(imgId[i]);
            //将每一个数组元素分别添加到fruitList列表中
            imgList.add(newsImgs[i]);
        }

        //最后返回一个List<>的列表
        return imgList;
    }


}
