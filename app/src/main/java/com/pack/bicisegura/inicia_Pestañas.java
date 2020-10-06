package com.pack.bicisegura;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class inicia_Pestañas extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new Pestañas()).commit();
        }
    }
}