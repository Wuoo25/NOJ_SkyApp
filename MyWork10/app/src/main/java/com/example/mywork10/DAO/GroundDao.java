package com.example.mywork10.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.Bean.GroundBean;
import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface GroundDao {

    public static List<GroundBean> getList() {
        List<GroundBean> groundBeanList = new ArrayList<>();
        String name[] = {
                "甘肃兰州抱龙山凤凰岭滑雪场", "兰州龙山国际滑雪场", "甘肃松鸣岩国际滑雪场"
        };
        String longContent[]={
                "抱龙山凤凰岭滑雪场位于甘肃省兰州市西固区岸门1向刘兰公路7公里处,是横跨中国西北陕甘宁三省规模最大的高山四季滑雪场。项目总占地面积约1000余亩,拥有设施完备、功能养全的各类综合硬件设施及管理服务团队,是目前兰洲及周边地区最专业的滑雪场。\n" +
                        "雪场依山就势,沿抱龙山山脉一顷而下,依据西北山地独有地形特点,配置包括练习、初、中、高级,雪圈、障碍及野雪等7条专业雪道,满足各年龄段及各类水平滑雪省的需求,雪道总长20公里,造雪面积约50万平方米,高级雪道最大坡度达50%,垂直落差达400米,并配置4人吊椅式索道,及单人魔毯。"
                ,"兰州龙山国际滑雪场由甘肃恒远投资有限公司投资7.8亿元打造,项目总占地面积7000余亩,地处兰州黄河北岸的龙山之上,与著名的什则世界第一古梨园仅一河之隔,距兰州市中心仪75公里,全程一级公路,交通便利。作为什川文化体育产业基地的龙头项目,兰州龙山国际滑雪场集高山滑雪、越野滑雪、自由式滑雪、休闲娱乐为一体的综合滑雪场。兰州龙山国际滑雪场造雪面积58万平方米,雪道总长15公里,高级道了条是目前省内难度系数最大的雪道,中级道6条平均宽度50m,初级道下条长1.5公里,魔毯练习道5条。场内建有省内最大的自由公园,配有70名专业教练的滑雪学校,以及超4万平米的雪上乐园,极具挑战性的雪圈道74条,另有雪地摩托、雪地坦克、悠波球、雪地挖掘机、推雪机等10多项雪上娱乐项目。配套4人吊椅缆车、便捷魔毯,3000余套品牌雪具,场内可同时接待游客5000余位。兰州龙山国际滑雪场,没有1万余平方米多功能接待大厅,现场我们提供优质贴心的各项服务;厅内自助餐、中餐、火锅等美食应有尽有; VIP 休息区、儿童游乐区、雪县专卖店、超市等,随时为游客提供优质的服务。雪场不仅满足您白天的滑雪需求,我们还为您提供了夜间滑雪服务,让您在工作之余,畅享夜滑带给您的快乐。逃离都市,没有生活谈事,没有工作邮件,走进龙山--更蓝的天、更高的山,更长的雪道和更清新的空气,相聚龙山国际滑雪场,体验不一样的冰雪世界!"
                ,"松嘎岩国际滑雪场位于甘肃省和政县松鸣镇风景区松鸣岩,距临夏市45公里,临兆35公里,兰州120公里,是临夏州第一座集健身、餐饮、住宿、娱乐为一体的综合性娱乐场所。\n" +
                "雪场总造雪面积约20多万平方米,雪道13条,初级道7条、环形道7条,中级道5条,高级道2条,雪圈道7条,猫跳道7条,波浪道了条,练习道7条,雪道总长度5000米左右,滑雪场还建有5条魔毯,2条缆车,1条拖牵,可同时容纳约6000人滑雪。"
        };
        Integer isFavorite[]={
                0,0,0,0
        };

        //创建一个equipment的对象数组
        GroundBean groundBeans[]=new GroundBean[name.length];

        //为fruitList列表添加元素
        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            groundBeans[i] = new GroundBean(name[i],longContent[i],isFavorite[i]);
            //将每一个数组元素分别添加到fruitList列表中
            groundBeanList.add(groundBeans[i]);
        }

        //最后返回一个List<>的列表
        return groundBeanList;
    }

    public static List<GroundBean> getListLike() {
        List<GroundBean> groundBeanList = new ArrayList<>();
        String name[] = {
                "甘肃兰州抱龙山凤凰岭滑雪场",  "甘肃松鸣岩国际滑雪场"
        };
        String longContent[]={
                "抱龙山凤凰岭滑雪场位于甘肃省兰州市西固区岸门1向刘兰公路7公里处,是横跨中国西北陕甘宁三省规模最大的高山四季滑雪场。项目总占地面积约1000余亩,拥有设施完备、功能养全的各类综合硬件设施及管理服务团队,是目前兰洲及周边地区最专业的滑雪场。\n" +
                        "雪场依山就势,沿抱龙山山脉一顷而下,依据西北山地独有地形特点,配置包括练习、初、中、高级,雪圈、障碍及野雪等7条专业雪道,满足各年龄段及各类水平滑雪省的需求,雪道总长20公里,造雪面积约50万平方米,高级雪道最大坡度达50%,垂直落差达400米,并配置4人吊椅式索道,及单人魔毯。"
                ,"松嘎岩国际滑雪场位于甘肃省和政县松鸣镇风景区松鸣岩,距临夏市45公里,临兆35公里,兰州120公里,是临夏州第一座集健身、餐饮、住宿、娱乐为一体的综合性娱乐场所。\n" +
                "雪场总造雪面积约20多万平方米,雪道13条,初级道7条、环形道7条,中级道5条,高级道2条,雪圈道7条,猫跳道7条,波浪道了条,练习道7条,雪道总长度5000米左右,滑雪场还建有5条魔毯,2条缆车,1条拖牵,可同时容纳约6000人滑雪。"
        };
        Integer isFavorite[]={
                0,0
        };

        //创建一个equipment的对象数组
        GroundBean groundBeans[]=new GroundBean[name.length];

        //为fruitList列表添加元素
        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            groundBeans[i] = new GroundBean(name[i],longContent[i],isFavorite[i]);
            //将每一个数组元素分别添加到fruitList列表中
            groundBeanList.add(groundBeans[i]);
        }

        //最后返回一个List<>的列表
        return groundBeanList;
    }


    @Query("SELECT * FROM grounds")
    List<GroundBean> getAllFromDb();

    @Query("SELECT * FROM grounds WHERE isFavorite=1")
    List<GroundBean> getEqFavoriteFromDb();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(GroundBean... groundBeans);

    @Delete
    void delete(GroundBean groundBean);

    /**
     * 更新收藏状态
     * @param groundBean
     */

    @Update
    public void updateOnePlayer(GroundBean groundBean);

}
