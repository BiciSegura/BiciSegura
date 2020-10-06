package com.pack.bicisegura;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class denuncias_recientes extends Fragment {

    private ListView mListView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = getView().findViewById(R.id.listView);

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
