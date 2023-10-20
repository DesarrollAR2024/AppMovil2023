package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class terminosycondi extends AppCompatActivity {

    Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminosycondi);

        btnsiguiente= findViewById(R.id.buttnsiguientetyc);
        btnsiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(terminosycondi.this, terminosycondiciones2.class);
                startActivity(intent);
            }
        });
    }


}