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

public class denunciar extends AppCompatActivity {

    LinkedList<Denuncia> ListaDenuncias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denunciar);

        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        final String usuario = sharedPreferences.getString("usuario", null);

        loadData();


        Button denunciar = findViewById(R.id.denunciar);

        denunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Hora = ((EditText) findViewById(R.id.hora)).getText().toString().trim();
                String Lugar = ((EditText) findViewById(R.id.lugar)).getText().toString().trim();

                Denuncia denuncia = new Denuncia();
                denuncia.setHora(Hora);
                denuncia.setLugar(Lugar);
                denuncia.setUsuario(usuario);

                //Guardar Hora y lugar en alguna parte

                ListaDenuncias.insertFirst(denuncia);

                saveData();

                Toast.makeText(denunciar.this, "Se guardó su denuncia", Toast.LENGTH_LONG).show();


                Intent reg = new Intent(denunciar.this, inicia_Pestañas.class);
                startActivity(reg);

            }
        });
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("denuncia list");
        String densString = "";

        for(int i = 0 ; i < ListaDenuncias.length;i++){

            Denuncia den = ListaDenuncias.getValue(i);
            densString = densString + toString(den);

        }
        editor.putString("denuncia list", densString);
        editor.apply();

    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        String densString = sharedPreferences.getString("denuncia list", null);

        if(densString == null){
            ListaDenuncias = new LinkedList<>();
        }else {
            ListaDenuncias = toLinkedList(densString);
        }

    }


    public static Denuncia fromString(String denString){

        int i = 0;
        String hora = "";
        String lugar = "";
        String usuario = "";


        while(!Character.toString(denString.charAt(i)).equals(">")){
            hora = hora + denString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(denString.charAt(i)).equals("]")){
            lugar = lugar + denString.charAt(i);
            i++;
        }
        i++;// hable mas bien para ir haciendo las cosas en conjunto mas rapido
        while(!Character.toString(denString.charAt(i)).equals(")")){
            usuario = usuario + denString.charAt(i);
            i++;
        }
        i++;

        Denuncia den = new Denuncia();
        den.setLugar(lugar);
        den.setUsuario(usuario);
        den.setHora(hora);

        return den;


    }

    public static String toString(Denuncia den){

        String denString = "";

        String Hora = den.getHora();
        String lugar = den.getLugar();
        String usuario = den.getUsuario();

        denString = denString +"{" + Hora+ ">" + lugar+ "]"  + usuario + ")";

        denString = denString + "}";




        return denString;

    }

    public static LinkedList<Denuncia> toLinkedList(String fullString){


        int j = 0;

        LinkedList<Denuncia> pruebafromstring = new LinkedList<Denuncia>();

        while(j < fullString.length()){

            if(Character.toString(fullString.charAt(j)).equals("{")){


                String denList = "";
                j++;
                while(!Character.toString(fullString.charAt(j)).equals("}")){
                    denList = denList+fullString.charAt(j);
                    j++;

                }

                Denuncia den = new Denuncia();
                den = fromString(denList);

                pruebafromstring.insertLast(den);
            }
            j++;
        }

        return pruebafromstring;

    }




}
