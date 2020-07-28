package com.example.planetsib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Landscape extends AppCompatActivity {

    LinearLayout lin;
    Boolean menu_boolv = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);

        lin = (LinearLayout) findViewById(R.id.menu);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navig);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.akc:
                        Intent i1 = new Intent(Landscape.this, Promotions.class);
                        startActivity(i1);
                        break;
                    case R.id.card:
                        Intent i2 = new Intent(Landscape.this, Card.class);
                        startActivity(i2);
                        break;
                    case R.id.ment:
                        if(menu_boolv){
                            lin.setVisibility(View.INVISIBLE);
                            menu_boolv = false;
                        }else{
                            lin.setVisibility(View.VISIBLE);
                            menu_boolv = true;
                        }
                        break;
                    case R.id.magaz:
                        break;
                    case R.id.lichcab:
                        Intent i4 = new Intent(Landscape.this, Kabinet.class);
                        startActivity(i4);
                        break;
                }
                return false;
            }
        });
    }
}