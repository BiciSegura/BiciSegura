package com.pack.bicisegura;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class registrousuario extends AppCompatActivity {

    LinkedList<Usuario> listausuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        loadData();

        Button registrarse = findViewById(R.id.registrarse);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String correo = ((EditText) findViewById(R.id.correo)).getText().toString().trim();
                String password = ((EditText) findViewById(R.id.contra)).getText().toString().trim();
                String confpass = ((EditText) findViewById(R.id.confir_contra)).getText().toString().trim();

                if(password.equals(confpass)){

                    Usuario newuser = new Usuario();
                    newuser.setContraseña(password);
                    newuser.setCorreo(correo);

                    listausuarios.insertLast(newuser);
                    saveData();

                }

                else{
                    Toast.makeText(registrousuario.this, "Por favor confirmar su contraseña correctamente", Toast.LENGTH_LONG).show();
                }

                //Próximamente?:
                /*String Usuario = ((EditText) findViewById(R.id.usuario)).getText().toString().trim();
                String Ciudad = ((EditText) findViewById(R.id.ciudad)).getText().toString().trim();
                String Telefono = ((EditText) findViewById(R.id.tel)).getText().toString().trim();*/


                //Intent reg = new Intent(registrousuario.this, algo.class);
                //startActivity(reg);
            }
        });


    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listausuarios);
        editor.putString("task list", json);
        editor.apply();
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
