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

import com.google.gson.internal.LinkedTreeMap;

import java.util.List;


public class CustomAdapter_Denuncias extends ArrayAdapter<Denuncia>{

    // Esta clase se necesita para la impresión de las denuncias, sin embargo necesita la clase Estructuras_Lista para implementarse
    private List<Denuncia> lista;
    private Context mContext;
    private int resourceLayout;

    public CustomAdapter_Denuncias(@NonNull Context context, int resource, List<Denuncia> objects) {
        super(context, resource, (List<Denuncia>) objects); //Esto no se utiliza, por lo tanto para ahorrar tiempo usamos funciones nativas
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

        Denuncia denuncia = lista.get(position); //Ajustar nombre del método al que sea establecido eventualmente.



        TextView textoUsuario = view.findViewById((R.id.usuario));
        String usuario = "Denunciado por:  " + denuncia.getUsuario();
        textoUsuario.setText(usuario);

        TextView textoNombre = view.findViewById((R.id.lugar));
        textoNombre.setText("Lugar:  "+denuncia.getLugar());

        TextView textoHora = view.findViewById((R.id.hora));
        String hora = "Hora:  " + denuncia.getHora();
        textoHora.setText(hora);

        TextView textoLocalidad = view.findViewById((R.id.localidad));
        String localidad = "Localidad:  " + denuncia.getLocalidad();
        textoLocalidad.setText(localidad);



        return view;

    }
}
