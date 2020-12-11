package com.pack.bicisegura;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class CustomAdapter_Localidades extends ArrayAdapter<Localidad>{

    private List<Localidad> lista;
    private Context mContext;
    private int resourceLayout;

    public CustomAdapter_Localidades(@NonNull Context context, int resource, List<Localidad> objects) {
        super(context, resource, (List<Localidad>) objects); //Esto no se utiliza, por lo tanto para ahorrar tiempo usamos funciones nativas
        this.lista = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        Localidad localidad = lista.get(position); //Ajustar nombre del método al que sea establecido eventualmente.

        String Numint = Integer.toString(localidad.getNumeroRobos());

        TextView textoLocal = view.findViewById((R.id.nombre_localidad));
        String nombrelocalidad = "Localidad:  " + localidad.getNombre();
        textoLocal.setText(nombrelocalidad);

        TextView textoNum = view.findViewById((R.id.número_denuncias));
        textoNum.setText("Número de robos:  "+ Numint);


        return view;

    }
}
