package com.pack.bicisegura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    LinkedList<Usuario> listausuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadData();

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

                Usuario us = new Usuario();

                us.setCorreo(Correo);
                us.setContraseña(Pass);

                if(listausuarios.contain(us)){
                    Intent reg = new Intent(MainActivity.this, inicia_Pestañas.class);
                    startActivity(reg);
                }

                /*if(Correo.equals("1") && Pass.equals("2")){
                    Intent reg = new Intent(MainActivity.this, inicia_Pestañas.class);
                    startActivity(reg);
                }*/

            }
        });
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<LinkedList<Usuario>>() {}.getType();
        listausuarios = gson.fromJson(json, type);

        if (listausuarios == null){
            listausuarios = new LinkedList<Usuario>();
        }

    }

}