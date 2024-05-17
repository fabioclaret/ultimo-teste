package com.android.bancodedadossqlite.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.android.bancodedadossqlite.R;
import com.android.bancodedadossqlite.controller.ClienteController;

public class MainActivity extends AppCompatActivity {
    ClienteController controler;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        controler = new ClienteController(context);
    }
}