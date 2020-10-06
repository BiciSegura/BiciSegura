package com.pack.bicisegura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class denunciar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denunciar);


        Button denunciar = findViewById(R.id.denunciar);

        denunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Hora = ((EditText) findViewById(R.id.hora)).getText().toString().trim();
                String Lugar = ((EditText) findViewById(R.id.lugar)).getText().toString().trim();

                //Guardar Hora y lugar en alguna parte

                Toast.makeText(denunciar.this, "Se guardó su denuncia", Toast.LENGTH_LONG).show();


                finish();

            }
        });
    }
}
