package com.example.planetsib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    static SharedPreferences mSettings;
    final String SAVE = "ok";
    Intent i = getIntent();

    final Intent i1 = new Intent(MainActivity.this, Card.class);
    final Intent i2 = new Intent(MainActivity.this, Authoriz.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences("my_storage", Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /*try {
                    if(mSettings.getBoolean("is_visited", false)){
                        startActivity(i1);
                    }else{
                        startActivity(i2);
                    }
                }catch (Error e){
                    startActivity(i2);
                }*/
                startActivity(new Intent(MainActivity.this, Card.class));
                finish();
            }
        }, 3000);
    }

    public Intent inte(){
        Intent i = new Intent();
        try {
            if(mSettings.getBoolean("is_visited", false)){
                i = i1;
            }else{
                i = i2;
            }
        }catch (Error e){
            i = i2;
        }
        return i;
    }

    public void logIn(){
        Editor edit = mSettings.edit();
        edit.putBoolean("is_logged", true).apply();
    }

}