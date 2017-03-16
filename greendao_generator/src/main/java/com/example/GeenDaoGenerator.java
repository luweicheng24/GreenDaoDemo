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
     * �����Զ�����GreenDaoGenerator��
     * @param args
     */
    public static void main(String[] args) {
        /**
         * ����ȫ��Schema һ�����Ӷ�Ӧһ������
         */
        Schema schema = new Schema(1, "com.ovov.greendao");
        //son�����ݿ�
        Entity son = schema.addEntity("Son");
        son.addStringProperty("name");
        son.addIntProperty("age");
        son.addDoubleProperty("height");
        Property fatherId = son.addLongProperty("fatherId").getProperty();//�������


        //father���ݿ�

        Entity father = schema.addEntity("Father");
        father.addStringProperty("name");
        father.addIntProperty("age");
        father.addDoubleProperty("height");

        son.addToOne(father, fatherId);//������


        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
