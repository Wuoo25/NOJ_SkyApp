package com.example.mywork10.DAO;

import com.example.mywork10.Bean.NewsBean;
import com.example.mywork10.Bean.NotiBean;
import com.example.mywork10.R;

import java.util.ArrayList;
import java.util.List;

public class NotiDao {

    public static List<NotiBean> getListFr() {
        List<NotiBean> notiBeanList = new ArrayList<>();
        //水果的名字
        String name[] = {
                "初级教学|滑雪入门级必看，三分钟图解滑雪技巧"
        };
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {
                R.mipmap.ski1

        };
        String longContent[]={
                "1.基础站姿：\n" +
                        "①双脚与肩同宽，保持腿部放松，膝盖前曲，膝盖骨位于脚背上方；\n" +
                        "②上身挺直，略前倾（与小腿平行），使脚跟处于微微受力状态；\n" +
                        "③大臂自然下垂并向两侧略打开，小臂前伸，协助平衡，目视前方。\n" +
                        "2.移动、滑行技巧：\n" +
                        "在雪地行走时，要将雪板依次抬起落下进行移动，避免雪板不断摩擦雪面。滑行时，在基础站姿的前提下，两臂向前，上体前屈，雪杖杖尖落在脚尖前方，两臂同时用力向后撑。滑行期间，可适当降低重心，保持身体稳定。\n" +
                        "3.转弯技巧：\n" +
                        "转弯时要遵循八字口诀：压左转右，压右转左。左转弯时，右腿和右脚踝略弯曲，将重心放在右脚。左脚雪板轻浮在雪面上，向左划出一道弧线，同理右转动作相反。\n" +
                        "4.停止技巧：\n" +
                        "以脚掌为轴，双脚脚跟慢慢将雪板尾部向外推开，呈内八字进行减速。\n" +
                        "5.摔倒处理技巧：\n" +
                        "摔倒时有3个“不要”：不要用手支撑，不要手脚乱动，身体不要翻滚。摔倒时应向左后或右后方坐下，双手摆放于两侧。摔倒后可用手撑起臀部和身体，蹲在雪板上站起，也可将雪仗置于身后方，借助力量支撑起身体。"
        };

        //创建一个equipment的对象数组
        NotiBean notiBeans[]=new NotiBean[name.length];

        //为fruitList列表添加元素
        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            notiBeans[i] = new NotiBean(name[i], imgId[i],longContent[i]);
            //将每一个数组元素分别添加到fruitList列表中
            notiBeanList.add(notiBeans[i]);
        }

        //最后返回一个List<>的列表
        return notiBeanList;
    }

    public static List<NotiBean> getListTh() {
        List<NotiBean> notiBeanList = new ArrayList<>();
        //水果的名字
        String name[] = {
                "双板滑雪中级技巧|横滑降要领教学"
        };
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {

                R.mipmap.ski2
        };
        String longContent[]={
                "横滑降技巧。横滑降在自由式双板滑雪里面算是基础入门技术，在卡宾竞技滑雪里面算是高级技术，有的卡宾大弯滑的很好的人横滑降都不行，但是横滑降又是一个滑野雪必备的技术，所以在自由式滑雪里我们把横滑降提到前面练习。\n" +
                        "一旦你掌握了平行式就赶紧练习横滑降，横滑降不但能让你下陡坡，而且还能让你滑行姿势更好看，我们知道并板是滑野雪必备的，因为能提升浮力，所以练好横滑降也能更好地让你并板。把横滑降提到卡宾前面还有个好处就是横滑降是板底技术，而很多卡宾滑的很不错的人练习横滑降很痛苦，恰恰因为他们习惯立刃了。"
        };

        //创建一个equipment的对象数组
        NotiBean notiBeans[]=new NotiBean[name.length];

        //为fruitList列表添加元素
        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            notiBeans[i] = new NotiBean(name[i], imgId[i],longContent[i]);
            //将每一个数组元素分别添加到fruitList列表中
            notiBeanList.add(notiBeans[i]);
        }

        //最后返回一个List<>的列表
        return notiBeanList;
    }

    public static List<NotiBean> getList3() {
        List<NotiBean> notiBeanList = new ArrayList<>();
        //水果的名字
        String name[] = {
                "高级教学|高级滑雪技巧"
        };
        // 图片所在位置的id，可以看到，上面的字符数组中的元素和我下面图片的名字是对应的，比如苹果和apple,我是为了便于用循环来索引
        int imgId[] = {
                R.mipmap.ski3
        };
        String longContent[]={
                "最近我们有讲到关于“刃”的相关知识技巧，今天我们就来研究探讨一下“换刃”时重心应该放在哪个位置。\n" +"当然，单板是个动态平衡的运动，没有一个固定的位置和动作在任何情况下都是对的，所以本期视频我们主要来讲一下我们将重心放在前脚、中间以及后脚时分别会有什么好处和坏处，大家便可以针对不同地形不同情况灵活使用。有兴趣的朋友也可以给我评论留言一起探讨哦！\n"
        };

        //创建一个equipment的对象数组
        NotiBean notiBeans[]=new NotiBean[name.length];

        //为fruitList列表添加元素
        for (int i = 0; i < name.length; i++) {
            //给每一个元素实例化，并将name数组和imgId数组的值传入对应元素的构造方法中
            notiBeans[i] = new NotiBean(name[i], imgId[i],longContent[i]);
            //将每一个数组元素分别添加到fruitList列表中
            notiBeanList.add(notiBeans[i]);
        }

        //最后返回一个List<>的列表
        return notiBeanList;
    }

}
