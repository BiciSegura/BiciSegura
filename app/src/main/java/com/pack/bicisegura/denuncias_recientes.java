package com.pack.bicisegura;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class denuncias_recientes extends Fragment{

    private ListView mListView;
    LinkedList<Denuncia> ListaDenuncias;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Denuncia> mLista = new ArrayList<>();

        if(ListaDenuncias != null){
            while(ListaDenuncias.getFirst() != null){

                Denuncia den = ListaDenuncias.pop();

                String hora = den.getHora();
                String lugar = den.getLugar();
                String usuario = den.getUsuario();

                mLista.add(new Denuncia(hora,lugar,usuario));
                mAdapter = new CustomAdapter_Denuncias(requireActivity().getApplicationContext(), R.layout.elemento_listas_denuncia,mLista);
                mListView.setAdapter(mAdapter);

            }
        }




        Button buscar = getView().findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hora = ((EditText) getView().findViewById(R.id.buscar_por_hora)).getText().toString().trim();
                String lugar = ((EditText) getView().findViewById(R.id.buscar_por_lugar)).getText().toString().trim();

                Toast.makeText(getActivity(), "Todavía no se puede xd", Toast.LENGTH_LONG).show();

            }
        });

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_denuncias_recientes, container, false);
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("denuncia list", null);
        Type type = new TypeToken<LinkedList<Denuncia>>() {}.getType();
        ListaDenuncias =  gson.fromJson(json, type);

        if (ListaDenuncias == null){
            ListaDenuncias = new LinkedList<>();
        }

    }


}

