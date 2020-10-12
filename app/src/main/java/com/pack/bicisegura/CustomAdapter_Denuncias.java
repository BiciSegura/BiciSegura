package com.pack.bicisegura;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class CustomAdapter_Denuncias{ //extends ArrayAdapter<Objeto_denuncia>{

    /* // Esta clase se necesita para la impresión de las denuncias, sin embargo necesita la clase Estructuras_Lista para implementarse
    private Estructuras_Lista lista;
    private Context mContext;
    private int resourceLayout;

    public CustomAdapter_Denuncias(@NonNull Context context, int resource, Estructuras_Lista<Objeto_denuncia> objects) {
        super(context, resource, (List<Objeto_denuncia>) objects); //Esto no se utiliza, por lo tanto para ahorrar tiempo usamos funciones nativas
        this.lista = objects;
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(mContext).inflate(resourceLayout, null);

        Objeto_denuncia denuncia = lista.getPosicion(position); Ajustar nombre del método al que sea establecido eventualmente.

        TextView textoUsuario = view.findViewById((R.id.usuario));
        String usuario = "Denunciado por:  " + denuncia.getUsuario();
        textoUsuario.setText(usuario);

        TextView textoNombre = view.findViewById((R.id.lugar));
        textoNombre.setText("Lugar:  "+denuncia.getLugar());

        TextView textoHora = view.findViewById((R.id.hora));
        String hora = "Hora:  " + denuncia.getHora();
        textoHora.setText(hora);



        return view;

    }*/
}
