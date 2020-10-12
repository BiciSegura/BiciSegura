package com.pack.bicisegura;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class registrousuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        Button registrarse = findViewById(R.id.registrarse);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String correo = ((EditText) findViewById(R.id.correo)).getText().toString().trim();
                String password = ((EditText) findViewById(R.id.contra)).getText().toString().trim();
                String confpass = ((EditText) findViewById(R.id.confir_contra)).getText().toString().trim();


                //Próximamente?:
                /*String Usuario = ((EditText) findViewById(R.id.usuario)).getText().toString().trim();
                String Ciudad = ((EditText) findViewById(R.id.ciudad)).getText().toString().trim();
                String Telefono = ((EditText) findViewById(R.id.tel)).getText().toString().trim();*/


                //Intent reg = new Intent(registrousuario.this, algo.class);
                //startActivity(reg);
            }
        });
    }
}
