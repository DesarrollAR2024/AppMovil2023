package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Preguntas_Frecuentes extends AppCompatActivity {

    Button btnvolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas_frecuentes);

        btnvolver= findViewById(R.id.buttonvolverfaq);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Preguntas_Frecuentes.this, ayuda.class);
                startActivity(intent);
            }
        });
    }
}
