package com.example.mywork10.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mywork10.Bean.CommentBean;
import com.example.mywork10.Bean.EquipmentBean;
import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;


public class EquipDao {

    public static List<EquipmentBean> getList() {
        List<EquipmentBean> equipmentBeanList = new ArrayList<>();
        //水果的名字
        String name[] = {
                "单板", "雪板", "滑雪镜","头盔"
        };
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {
                R.mipmap.eq1,R.mipmap.doubleboard,R.mipmap.glasses,R.mipmap.head

        };
        String content[]={

          "Aviator是Jones品牌在不断前行路上主力发动机之一，这款集合了诸多板型优点的全能雪板在这个雪季的中期迎来了一次全面进化。更现代化的制造工艺与高新科技材料的应用让飞行家进阶到2.0版本，Koroyd蜂窝材料与无木芯技术的结合成为了飞行家继续飞翔的新动力。2.0版本的飞行家生而为了全地形滑行，一板滑天下是它的使命，它更是为全地形玩家准备的次时代礼物，融合性的使用了Koroyd材料进一步提升雪板性能。当你与飞行家2.0一起驰骋在雪道上，贴地飞行般的滑行感受能让你的滑行变的更流畅，飞行家2.0是一款为未来而准备的全地形雪板。"
                ,
                "双板可以有很多种分类，这里我先简单的按地域分类为：雪道板、野雪板、公园板和全地域板。建议新手开始就买一块雪道板即可，如果一开始就接触的是公园，那就直接买公园板。野雪和全地域一般开始的时候是用不到的。越初级的雪板越软越轻。选择雪板一般按身高减去10公分来定长度即可，这个是一个万精油的标准，体重大的可以少减几公分，体重小的多减几公分，雪板越短转向越灵活，稳定性越差，速度慢，反之转向越钝但稳定性好，速度快。最终，我想说，雪板的参数只能参考，如何发挥一块雪板的性能，最终是靠人，人的技术占了非常重要的地位，所以迷信板不如迷信技术来的靠谱。\n"
                ,
                "滑雪镜是必须的滑雪用品，用来遮挡强光和风。好的雪镜可以有效过滤很多有害光线对眼睛的伤害，同时，雪镜还可以在摔倒时有效保护眼睛不被刮伤或者戳伤，必备！\n"
                ,
                "头盔是非常重要的护具之一，保护你的头部。进入工地请戴安全帽，进入雪场请戴头盔，道理是一样的，记住，一定要戴头盔，只有在保护好自己的前提下，才能很好的享受滑雪这项运动。有的头盔戴上后，非但不会影响你的形象，还会让你看上去更加的Cool。\n"
        };


        //创建一个equipment的对象数组
        EquipmentBean equipmentBeans[]=new EquipmentBean[name.length];

        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            equipmentBeans[i] = new EquipmentBean(name[i], imgId[i],content[i]);
            //将每一个数组元素分别添加到fruitList列表中
            equipmentBeanList.add(equipmentBeans[i]);
        }
        //最后返回一个List<>的列表
        return equipmentBeanList;
    }
/*
    @Query("SELECT * FROM equipments")
    List<EquipmentBean> getAllFromDb();

    @Query("SELECT * FROM equipments WHERE isFavorite=1")
    List<EquipmentBean> getEqFavoriteFromDb();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(EquipmentBean... equipmentBeans);

    @Delete
    void delete(EquipmentBean equipmentBean);*/

    /**
     * 更新收藏状态
     * @param equipmentBean
     */
/*
    @Update
    public void updateOnePlayer(EquipmentBean equipmentBean);
*/


}
