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

public class denunciar extends AppCompatActivity {

    LinkedList<Denuncia> ListaDenuncias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denunciar);

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
                denuncia.setUsuario("Pepito");

                //Guardar Hora y lugar en alguna parte

                ListaDenuncias.insertFirst(denuncia);

                saveData();

                Toast.makeText(denunciar.this, "Se guardó su denuncia", Toast.LENGTH_LONG).show();


                finish();

            }
        });
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("denuncia list");

        Gson gson = new Gson();

        String json = gson.toJson(ListaDenuncias);

        editor.putString("denuncia list", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("denuncia list", null);
        Type type = new TypeToken<LinkedList<Denuncia>>() {}.getType();
        ListaDenuncias = gson.fromJson(json, type);

        if (ListaDenuncias == null){
            ListaDenuncias = new LinkedList<Denuncia>();
        }

    }
}
