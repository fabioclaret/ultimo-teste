package com.android.bancodedadossqlite.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.android.bancodedadossqlite.api.AppUtil;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "MeuApp.sqlite";

    public static  int VERSION = 1;

    public AppDataBase(Context context) {
        super(context, DB_NAME, null, VERSION);

        Log.i(AppUtil.TAG, "AppDataBase: Criando o banco de dados");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
