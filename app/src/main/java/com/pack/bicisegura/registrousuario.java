package com.pack.bicisegura;

import android.content.Intent;
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
                String usuario = ((EditText) findViewById(R.id.usuario)).getText().toString().trim();


                if(correo.length() != 0 && password.length() !=  0 && usuario.length() != 0){
                    if(password.equals(confpass)){

                        Usuario newuser = new Usuario();
                        newuser.setContraseña(password);
                        newuser.setCorreo(correo);
                        newuser.setUsuario(usuario);

                        listausuarios.insertLast(newuser);
                        saveData();

                        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                        SharedPreferences.Editor editor2 = sharedPreferences.edit();
                        editor2.putString("usuario", usuario);
                        editor2.apply();

                        Toast.makeText(registrousuario.this, "Su usuario se registró correctamente", Toast.LENGTH_LONG).show();

                        Intent reg = new Intent(registrousuario.this, Barra_Lateral.class);
                        startActivity(reg);

                    }

                    else{
                        Toast.makeText(registrousuario.this, "Por favor confirmar su contraseña correctamente", Toast.LENGTH_LONG).show();
                    }
                }

                else{
                    Toast.makeText(registrousuario.this, "Por favor llenar los campos obligatorios", Toast.LENGTH_LONG).show();

                }



                //Próximamente?:
                /*String Usuario = ((EditText) findViewById(R.id.usuario)).getText().toString().trim();
                String Ciudad = ((EditText) findViewById(R.id.ciudad)).getText().toString().trim();
                String Telefono = ((EditText) findViewById(R.id.tel)).getText().toString().trim();*/

            }
        });


    }


    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("usuarios list");
        String ususString = "";

        for(int i = 0 ; i < listausuarios.length;i++){

            Usuario usu = listausuarios.getValue(i);
            ususString = ususString + UtoString(usu);

        }
        editor.putString("usuarios list", ususString);
        editor.apply();

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

}
