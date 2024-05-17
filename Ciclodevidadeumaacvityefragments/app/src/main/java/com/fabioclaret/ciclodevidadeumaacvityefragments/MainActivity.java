package com.fabioclaret.ciclodevidadeumaacvityefragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import com.fabioclaret.ciclodevidadeumaacvityefragments.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               int posicao = tab.getPosition();
               int teste = 0;
                switch (posicao){
                    case 0:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragmentContainerView, new FirstFragment()).commit();
                        break;
                    case 1:
                         getSupportFragmentManager().beginTransaction().
                                replace(R.id.fragmentContainerView, new SecondFragment2()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().
                     
                                replace(R.id.fragmentContainerView, new ThirdFragment()).commit();
                        break;
                }
            };
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}