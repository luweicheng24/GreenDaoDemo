package com.ovov.www.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.dao.DaoSession;
import com.dao.FatherDao;
import com.dao.SonDao;
import com.dao.SqliteManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import greenden.Father;
import greenden.Son;

public class MainActivity extends AppCompatActivity {
    private DaoSession daoSession;
    private SonDao sonDao;
    private FatherDao fatherDao;
    private SqliteManager sqliteManager;
    private EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqliteManager = new SqliteManager();
        daoSession = MyApplication.instance.getDaoSession();
        sonDao =  daoSession.getSonDao();
        fatherDao = daoSession.getFatherDao();
        name = (EditText) findViewById(R.id.et_name);
        age = (EditText) findViewById(R.id.et_age);
    }

    public void insert(View view){
        if(TextUtils.isEmpty(name.getText().toString())){
            L.e("name为空");
            return;
        }
        L.e("插入");
        Father father = new Father(5,name.getText().toString(),"boy");
        sqliteManager.insertFather(father);
    }
    public void delete(View view){
        L.e("删除");
        sqliteManager.deleteSon(6l);

    }
    public void modify(View view){
        L.e("修改");

        Son son = sonDao.queryBuilder().where(SonDao.Properties.Id.eq("4")).build().unique();
        if(son!=null){

            sqliteManager.update(son);
            L.e("修改成功");
        }else{
            L.e("不存在该数据");
        }
    }
    public void query(View view){
        L.e("查询");

        QueryBuilder qb = sqliteManager.getSonQueryBuilder();
        List<Son> mList = qb.list();
        L.e(mList.toString());

    }
}
