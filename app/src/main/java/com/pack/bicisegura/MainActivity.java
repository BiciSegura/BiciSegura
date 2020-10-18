package com.pack.bicisegura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                Node<Usuario> aux = listausuarios.head;
                if(listausuarios.length == 0 ){
                    Toast.makeText(MainActivity.this, "No hay usuarios registrados", Toast.LENGTH_LONG).show();

                }else{
                    int count = 1;
                    for(int i=0; i < listausuarios.length ; i++){
                        if(usuariosiguales(aux.value, us)){
                            Intent reg = new Intent(MainActivity.this, inicia_Pestañas.class);
                            startActivity(reg);
                            break;

                        }else{
                            aux = aux.next;
                            count = count + 1;
                            if (count == listausuarios.length ){
                                System.out.println("El valor no esta en la lista.");
                            }
                        }
                    }
                }

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

    private boolean usuariosiguales(Usuario a, Usuario b){

        if(a.getContraseña().equals(b.getContraseña()) && a.getCorreo().equals(b.getCorreo())){
            return true;
        }
        else{
            return false;
        }

    }

}