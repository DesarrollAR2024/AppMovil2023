package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contacto extends AppCompatActivity {

    Button btnenvcontacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnenvcontacto= findViewById(R.id.button10);
        btnenvcontacto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Contacto.this, Home.class);
                startActivity(intent);
            }
        });
    }

}