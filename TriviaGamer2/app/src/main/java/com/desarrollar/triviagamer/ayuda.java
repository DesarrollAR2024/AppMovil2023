package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ayuda extends AppCompatActivity {
 Button btnvolver;

 Button btnpf;

 Button btntyc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        btnvolver= findViewById(R.id.btnvolverhome);
        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ayuda.this , Home.class);
                startActivity(intent);
            }
        });

        btnpf= findViewById(R.id.buttonpf);
        btnpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ayuda.this, Preguntas_Frecuentes.class);
                startActivity(intent);
            }
        });

        btntyc= findViewById(R.id.buttontyc);
        btntyc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ayuda.this, terminosycondi.class);
                startActivity(intent);
            }
        });
    }
}