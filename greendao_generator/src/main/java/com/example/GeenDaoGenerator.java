package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;

/**
 * Created by luweicheng on 2017/3/14 0014.
 */

public class GeenDaoGenerator {
    /**
     * 创建自动生成GreenDaoGenerator类
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 创建全局Schema 一个儿子对应一个父亲
         */
        Schema schema = new Schema(1, "com.ovov.greendao");
        //son的数据库
        Entity son = schema.addEntity("Son");
        son.addStringProperty("name");
        son.addIntProperty("age");
        son.addDoubleProperty("height");
        Property fatherId = son.addLongProperty("fatherId").getProperty();//创建外键


        //father数据库

        Entity father = schema.addEntity("Father");
        father.addStringProperty("name");
        father.addIntProperty("age");
        father.addDoubleProperty("height");

        son.addToOne(father, fatherId);//添加外键


        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
