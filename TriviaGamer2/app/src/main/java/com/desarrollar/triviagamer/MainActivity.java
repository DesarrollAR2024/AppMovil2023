package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btniniciarsesion;
    Button btnregistro;

    // declare una variable indicando el tipo de control

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btniniciarsesion = findViewById(R.id.butn_iniciarsesionm);
        btnregistro = findViewById(R.id.butn_iniciarsesionm2);
        btniniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    //codigo para ir a otra pagina indicando a donde quiero ir!//
}