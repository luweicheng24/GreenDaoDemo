package com.dao;

import com.ovov.www.greendaodemo.L;
import com.ovov.www.greendaodemo.MyApplication;

import org.greenrobot.greendao.query.QueryBuilder;

import greenden.Father;
import greenden.Son;

/**
 * Created by luweicheng on 2017/3/15 0015.
 */

public class SqliteManager {
    private SonDao sonDao;
    private FatherDao fatherDao;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private QueryBuilder sonQueryBuilder;
    private QueryBuilder fatherQueryBuilder;

    public SqliteManager() {
        daoMaster = MyApplication.instance.getDaoMaster();
        daoSession = MyApplication.instance.getDaoSession();
        sonDao = MyApplication.instance.getDaoSession().getSonDao();
        fatherDao = MyApplication.instance.getDaoSession().getFatherDao();
        sonQueryBuilder = sonDao.queryBuilder();
        fatherQueryBuilder = sonDao.queryBuilder();

    }

    public void insertSon(Son son) {
        sonDao.insert(son);
        L.e("插入成功" +
                "");
    }

    public void deleteSon(long id) {
        sonDao.deleteByKey(id);
    }

    public void update(Son son) {
        sonDao.update(son);

    }
    public void insertFather(Father father) {
        fatherDao.insert(father);
    }

    public void deleteFather(Father father) {
        fatherDao.delete(father);
    }

    public void update(Father father) {
        fatherDao.update(father);

    }

    public QueryBuilder getSonQueryBuilder() {
        return sonQueryBuilder;
    }

    public QueryBuilder getFatherQueryBuilder() {
        return fatherQueryBuilder;
    }

}
