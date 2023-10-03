package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class terminosycondi extends AppCompatActivity {

    Button btnvolver;

    Button btnaceptar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminosycondi);

        btnvolver = findViewById(R.id.btnvolvertyc1);

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(terminosycondi.this , ayuda.class);
                startActivity(intent);
            }
        });

        btnaceptar= findViewById(R.id.btnaceptartyc);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(terminosycondi.this, Home.class);
                startActivity(intent);
            }
        });

    }


}