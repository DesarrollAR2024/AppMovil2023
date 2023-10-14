package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Registro extends AppCompatActivity {

    Button btnregistrohome;
    Button btniniciarsesionf;
    ImageView btnbackbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        btnbackbutton2 = findViewById(R.id.backmain);
        btnregistrohome = findViewById(R.id.buttonregistros);
        btniniciarsesionf=findViewById(R.id.buttoniniciarsesions);
        btnregistrohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this , Home.class);
                startActivity(intent);
            }
        });

        btniniciarsesionf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this , login.class);
                startActivity(intent);
            }
        });

        btnbackbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registro.this , login.class);
                startActivity(intent);
            }
        });



    }
}