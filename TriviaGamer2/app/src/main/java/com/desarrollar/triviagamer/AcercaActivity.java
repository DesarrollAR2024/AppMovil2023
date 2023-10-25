package com.desarrollar.triviagamer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AcercaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);

        TextView textViewTitulo = findViewById(R.id.textViewTitulo);
        TextView textViewContenido = findViewById(R.id.textViewContenido);
        ImageView imageView5 = findViewById(R.id.imageView5);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Configurar el contenido de las vistas
        textViewTitulo.setText("ACERCA DE NOSOTROS");
        textViewContenido.setText("Somos una empresa llamada DesarrollAR dedicada a realizar videojuegos como la trivia de GAMEATE para el entretenimiento y al alcance de todo el público.");

        // Asignar clic a los botones si es necesario
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agrega lógica para el botón Volver si es necesario
            }
        });
    }
}
