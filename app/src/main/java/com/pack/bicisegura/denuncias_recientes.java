package com.pack.bicisegura;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

public class denuncias_recientes extends Fragment {

    private ListView mListView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* // Esto imprime las denuncias al recorrer la pila que las contendrá

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Objeto_denuncia> mLista = new ArrayList<>();

        while(pila.getLast() != null){

            Objeto_denuncia den = pila.pop();

            String hora = den.getHora();
            String lugar = den.getLugar();
            String usuario = den.getUsuario();

            mLista.add(new Objeto_denuncia(hora,lugar,usuario));
            mAdapter = new CustomAdapter_Denuncias(requireActivity().getApplicationContext(), R.layout.elemento_listas_denuncia,mLista);
            mListView.setAdapter(mAdapter);

        }
        */

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
}
