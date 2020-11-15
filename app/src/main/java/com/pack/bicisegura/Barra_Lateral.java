package com.pack.bicisegura;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Barra_Lateral extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_lateral);


        //Como se quitó la ActionBar en esta pantalla, se agrega una barra de herramientas en su lugar, de la siguiente manera
        Toolbar barra = findViewById(R.id.barra_tareas);
        setSupportActionBar(barra);

        drawer = findViewById(R.id.DrawerLayout);

        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);

        //(contexto, variable drawer, variable toolbar, las strings que definimos anteriormene.
        ActionBarDrawerToggle tog = new ActionBarDrawerToggle(this, drawer, barra, R.string.nav_drawer_open,R.string.nav_drawer_close);
        drawer.addDrawerListener(tog);
        //Rota el hamburger icon (el cuadro que abre el drawer)
        tog.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.cont_fragmentos, new Pestañas_entrega1()).commit(); //Inicia con la actividad información en primer lugar, no vacío
            nav_view.setCheckedItem(R.id.entrega1);
        }
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.entrega1:
                getSupportFragmentManager().beginTransaction().replace(R.id.cont_fragmentos, new Pestañas_entrega1()).commit();
                break;
            case R.id.entrega2:
                getSupportFragmentManager().beginTransaction().replace(R.id.cont_fragmentos, new Pestañas_entrega2()).commit();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true; //Item selected
    }

    //El siguiente método permite que, cuando nuestro drawer está abierto, y al presionar "volver" en nuestro teléfono, este layout se cierre, como es común.
    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            final CharSequence[] opciones = {"Cerrar Sesión", "Cancelar"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Elige una opción");
            builder.setItems(opciones, new DialogInterface.OnClickListener() {
                @SuppressLint("IntentReset")
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (opciones[i] == "Cerrar Sesión") {
                        Intent intent = new Intent(Barra_Lateral.this, MainActivity.class);
                        startActivity(intent);

                    } else if (opciones[i] == "Cancelar") {
                        dialogInterface.dismiss();
                    }
                }
            });
            builder.show();
        }

    }


}
