package com.ovov.www.greendaodemo;

import android.util.Log;

/**
 * Created by luweicheng on 2017/3/15 0015.
 */

public class L {
    public static Boolean DEBUD = true;
    public static final String TAG = "GreenDaoDebug";
    public static void e(String message){
        if(DEBUD){
            Log.e(TAG, "e: "+message );
        }
    }


}
