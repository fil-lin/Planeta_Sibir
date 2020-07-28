package com.example.planetsib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Promotions extends AppCompatActivity {

    ViewFlipper v_flip;
    Boolean menu_boolv = false;
    LinearLayout lin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotions);

        int[] image = {R.drawable.banner1, R.drawable.banner2};

        v_flip = (ViewFlipper) findViewById(R.id.flip);
        lin = (LinearLayout) findViewById(R.id.menu);

        for (int images : image){
            flipImg(images);
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navig);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.akc:
                        //Intent i1 = new Intent(Card.this, Promotions.class);
                        //startActivity(i1);
                        break;
                    case R.id.card:
                        Intent i1 = new Intent(Promotions.this, Card.class);
                        startActivity(i1);
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
                        Intent i3 = new Intent(Promotions.this, Landscape.class);
                        startActivity(i3);
                        break;
                    case R.id.lichcab:
                        Intent i4 = new Intent(Promotions.this, Kabinet.class);
                        startActivity(i4);
                        break;
                }
                return false;
            }
        });
    }

    public void flipImg(int image){
        ImageView imv = new ImageView(this);
        imv.setBackgroundResource(image);

        v_flip.addView(imv);
        v_flip.setFlipInterval(5000);
        v_flip.setAutoStart(true);

        //Анимация:
        v_flip.setInAnimation(this, android.R.anim.slide_in_left);
        v_flip.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}