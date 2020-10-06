package com.pack.bicisegura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class eliminar_denuncia extends AppCompatActivity {

    static TextView hora, lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar_denuncia);

        hora = findViewById(R.id.e_hora);
        hora.setText("Hora: " + "ejemplo");

        lugar = findViewById(R.id.e_lugar);
        lugar.setText("Lugar: " + "ejemplo");

        Button eliminar = findViewById(R.id.eliminar);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(eliminar_denuncia.this, "Su denuncia fue eliminada", Toast.LENGTH_LONG).show();


                finish();

            }
        });
    }
}

