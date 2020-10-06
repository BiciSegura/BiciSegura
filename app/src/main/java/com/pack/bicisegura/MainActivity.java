package com.pack.bicisegura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registro = findViewById(R.id.registro);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(MainActivity.this, registrousuario.class);
                startActivity(reg);
            }
        });

        Button ingreso = findViewById(R.id.ingreso);

        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Correo = ((EditText) findViewById(R.id.email)).getText().toString().trim();
                String Pass = ((EditText) findViewById(R.id.password)).getText().toString().trim();

                if(Correo.equals("1") && Pass.equals("2")){
                    Intent reg = new Intent(MainActivity.this, inicia_Pestañas.class);
                    startActivity(reg);
                }

            }
        });
    }
}