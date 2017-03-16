package com.ovov.www.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.dao.DaoMaster;
import com.dao.DaoSession;

/**
 * Created by luweicheng on 2017/3/15 0015.
 */

public class MyApplication extends Application {
    private DaoMaster.DevOpenHelper dbHelper ;
    private DaoMaster daoMaster;
    private SQLiteDatabase db;
    private DaoSession daoSession;
    public static MyApplication instance;
    public static final String TAG = "MyApplication";

    public DaoMaster.DevOpenHelper getDbHelper() {
        return dbHelper;

    }

    public void setDbHelper(DaoMaster.DevOpenHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void setDaoMaster(DaoMaster daoMaster) {
        this.daoMaster = daoMaster;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public void setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
         instance = this;
         initDataBase();
    }

    /**
     * 初始化数据库只创建一次
     */
    private void initDataBase() {
        dbHelper = new DaoMaster.DevOpenHelper(instance,"person.db",null);
        db = dbHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        L.e("数据库创建完成application");
    }
}
