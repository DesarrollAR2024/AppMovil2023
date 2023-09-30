package com.desarrollar.triviagamer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class terminosycondiciones2 extends AppCompatActivity {

    Button btnvolvertyc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminosycondiciones2);
        btnvolvertyc1 = findViewById(R.id.buttnvolver);

        btnvolvertyc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(terminosycondiciones2.this , terminosycondi.class);
                startActivity(intent);
            }
        });
    }
}