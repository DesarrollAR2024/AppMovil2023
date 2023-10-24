package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Pregunta_1 extends AppCompatActivity {

    Button btnpuntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);

        btnpuntaje = findViewById(R.id.buttnsigp1);

        btnpuntaje.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Pregunta_1.this, Resultado_correcto.class);
            startActivity(intent);
        }
        });


    }
}