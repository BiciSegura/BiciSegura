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

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences.edit();
        editor1.remove("usuario");
        editor1.apply();

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
                    for(int i=0; i < listausuarios.length ; i++){
                        if(usuariosiguales(aux.value, us)){

                            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                            SharedPreferences.Editor editor2 = sharedPreferences.edit();
                            editor2.putString("usuario", aux.value.getUsuario());
                            editor2.apply();
                            Intent reg = new Intent(MainActivity.this, Barra_Lateral.class);
                            startActivity(reg);
                            break;

                        }else{
                            aux = aux.next;
                            if (i == listausuarios.length-1 ){
                                Toast.makeText(MainActivity.this, "Este usuario no se encuentra registrado", Toast.LENGTH_LONG).show();
                                ;
                            }
                        }
                    }
                }

            }
        });
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        String ususString = sharedPreferences.getString("usuarios list", null);

        if(ususString == null){
            listausuarios = new LinkedList<>();
        }else {
            listausuarios = UtoLinkedList(ususString);
        }

    }

    public static Usuario UfromString(String usuString){

        int i = 0;
        String correo = "";
        String contraseña = "";
        String usuario = "";


        while(!Character.toString(usuString.charAt(i)).equals(">")){
            correo = correo + usuString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(usuString.charAt(i)).equals("]")){
            contraseña = contraseña + usuString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(usuString.charAt(i)).equals(")")){
            usuario = usuario + usuString.charAt(i);
            i++;
        }
        i++;

        Usuario usu = new Usuario();
        usu.setCorreo(correo);
        usu.setContraseña(contraseña);
        usu.setUsuario(usuario);
        return usu;


    }

    public static String UtoString(Usuario usu){

        String usuString = "";

        String correo = usu.getCorreo();
        String contraseña = usu.getContraseña();
        String usuario = usu.getUsuario();

        usuString = usuString +"{" + correo+ ">" + contraseña+ "]"  + usuario + ")";

        usuString = usuString + "}";




        return usuString;

    }

    public static LinkedList<Usuario> UtoLinkedList(String fullString){


        int j = 0;

        LinkedList<Usuario> pruebalinked = new LinkedList<Usuario>();

        while(j < fullString.length()){

            if(Character.toString(fullString.charAt(j)).equals("{")){


                String usuList = "";
                j++;
                while(!Character.toString(fullString.charAt(j)).equals("}")){
                    usuList = usuList+fullString.charAt(j);
                    j++;

                }

                Usuario usu = new Usuario();
                usu = UfromString(usuList);

                pruebalinked.insertLast(usu);
            }
            j++;
        }

        return pruebalinked;

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