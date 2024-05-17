package com.android.bancodedadossqlite.controller;

import android.content.Context;
import android.util.Log;

import com.android.bancodedadossqlite.api.AppUtil;
import com.android.bancodedadossqlite.datasource.AppDataBase;

public class ClienteController extends AppDataBase {
    public ClienteController(Context context) {
        super(context);
        Log.i(AppUtil.TAG, "ClienteController: Conectado ao banco de dados");
    }
}
