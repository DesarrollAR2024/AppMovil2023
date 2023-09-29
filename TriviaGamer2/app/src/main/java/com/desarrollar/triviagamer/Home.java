package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    Button btnfacil;

    ImageView help;

    ImageView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnfacil = findViewById(R.id.buttonfacil);
        help= findViewById(R.id.imagenhelp);
        perfil = findViewById(R.id.imagenavatar);
        btnfacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , Pregunta_1.class);
                startActivity(intent);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , ayuda.class);
                startActivity(intent);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this , Perfil.class);
                startActivity(intent);
            }
        });

    }
}