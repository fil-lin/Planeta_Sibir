package com.example.planetsib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.google.android.material.bottomnavigation.BottomNavigationView;



public class Card extends AppCompatActivity {

    private String path = "R.drawable.";
    Boolean menu_boolv = false;
    LinearLayout lin;
    ImageButton imb;
    int l = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        imb = (ImageButton) findViewById(R.id.carta);
        lin = (LinearLayout) findViewById(R.id.menu);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navig);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.akc:
                        Intent i1 = new Intent(Card.this, Promotions.class);
                        startActivity(i1);
                        break;
                    case R.id.card:
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
                        Intent i3 = new Intent(Card.this, Landscape.class);
                        startActivity(i3);
                        break;
                    case R.id.lichcab:
                        Intent i4 = new Intent(Card.this, Kabinet.class);
                        startActivity(i4);
                        break;
                }
                return false;
            }
        });

    }

    public void cliKK(View view) {
        if(l==1){
            imb.setImageResource(R.drawable.cardface);
            l++;
        }else{
            imb.setImageResource(R.drawable.cardbarc);
            l--;
        }
    }

    public void menu(){
        FragmentManager fragment = getSupportFragmentManager();
        //MyDialogFragment
    }
}