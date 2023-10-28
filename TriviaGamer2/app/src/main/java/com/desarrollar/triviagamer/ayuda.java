package com.desarrollar.triviagamer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*import com.google.android.material.bottomnavigation.BottomNavigationView;*/

public class ayuda extends AppCompatActivity {
   Button btnvolver;

   Button btnpf;

   /* BottomNavigationView bottomNavigationView;*/



    Button btncontacto;

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

        btncontacto= findViewById(R.id.buttoncontacto);
        btncontacto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ayuda.this, Contacto.class);
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

/*        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.informacion);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.informacion) {
                return true;
            } else if (itemId == R.id.perfil) {
                startActivity(new Intent(getApplicationContext(), Perfil.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.ranking) {
                startActivity(new Intent(getApplicationContext(), Ranking.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;

            } else if (itemId == R.id.home) {
                startActivity(new Intent(getApplicationContext(), Home.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

            return false;
        });*/

    }
}