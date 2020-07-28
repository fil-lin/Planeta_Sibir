package com.example.planetsib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Cod extends AppCompatActivity {

    Button btn;

    EditText edt;

    final String FILENAME = "norm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod);

        edt = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cod.this, MainActivity.class);
                if(edt.getText().toString() == "1234"){
                    //i.putExtra("bool", '0');

                    MainActivity mn = new MainActivity();
                    mn.auth();

                    startActivity(i);
                }else {
                    //здесь надпись об ошибке. Сделать потом
                }

            }
        });*/
    }

    public void naver(View view) {
        Intent i = new Intent(Cod.this, MainActivity.class);
        MainActivity mn = new MainActivity();
        mn.logIn();
        startActivity(i);
        if(edt.getText().toString() == "1234"){
            //i.putExtra("bool", '0');

            startActivity(i);
        }else {
            //здесь надпись о неправильном коде. Сделать потом
        }
    }

    void auth(){
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
                // пишем данные
                bw.write("Содержимое файла");
                // закрываем поток
                bw.close();
        }catch (Error | IOException e){

        }
    }
}