package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.infowithvijay.triviaquizapp2.R;

public class Resultado_correcto extends AppCompatActivity {

    Button btncorrecto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_correcto);

        btncorrecto = findViewById(R.id.buttnsigcorrecto);

        btncorrecto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Resultado_correcto.this ,  puntaje.class);
                startActivity(intent);
            }

        });



    }
}