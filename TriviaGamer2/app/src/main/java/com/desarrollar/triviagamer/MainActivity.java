package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btniniciarsesion;


    // declare una variable indicando el tipo de control



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btniniciarsesion = findViewById(R.id.butn_iniciarsesionm);
        btniniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , login.class);
                startActivity(intent);
            }
        });
    }

    //codigo para ir a otra pagina indicando a donde quiero ir!//
}