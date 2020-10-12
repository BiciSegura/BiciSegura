package com.pack.bicisegura;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class mis_denuncias extends Fragment {

    FloatingActionButton fab, fab2;
    private ListView mListView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Objeto_denuncia> mLista = new ArrayList<>();


        /*
        while(pila.getLast() != null){

            String correo = ps al correo del usuario xd
            Objeto_denuncia den = pila.pop();

            if(den.getUsuario().equals(correo)){
                String hora = den.getHora();
                String lugar = den.getLugar();
                String usuario = den.getUsuario();

                mLista.add(new Objeto_denuncia(hora,lugar,usuario));
                mAdapter = new CustomAdapter_Denuncias(requireActivity().getApplicationContext(), R.layout.elemento_listas_denuncia,mLista);
                mListView.setAdapter(mAdapter);

            }



        }
        */


        mListView = getView().findViewById(R.id.listView);

        fab = getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "Agregar empleado", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                Intent intent = new Intent(getActivity(), denunciar.class);
                getActivity().startActivity(intent);
            }
        });

        fab2 = getView().findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "Agregar empleado", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                Intent intent = new Intent(getActivity(), eliminar_denuncia.class);
                getActivity().startActivity(intent);
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mis_denuncias, container, false);
    }
}
