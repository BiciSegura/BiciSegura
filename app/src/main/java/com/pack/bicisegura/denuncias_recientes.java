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

import org.intellij.lang.annotations.JdkConstants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class denuncias_recientes extends Fragment{

    private ListView mListView;
    LinkedList<Denuncia> ListaDenuncias;
    Boolean bool = false;

    LinkedList<Denuncia> lanuevalista = new LinkedList<Denuncia>();
    
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();

       /* lanuevalista.fillList(1000);*/

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Denuncia> mLista = new ArrayList<>();

        if(ListaDenuncias != null){
            while(ListaDenuncias.getFirst() != null){


                Denuncia den = ListaDenuncias.getFirst();
                ListaDenuncias.deleteFirst();

                String hora = den.getHora();
                String lugar = den.getLugar();
                String usuario = den.getUsuario();
                String localidad = den.getLocalidad();

                mLista.add(new Denuncia(lugar,hora,usuario, localidad));
                mAdapter = new CustomAdapter_Denuncias(requireActivity().getApplicationContext(), R.layout.elemento_listas_denuncia,mLista);
                mListView.setAdapter(mAdapter);

            }
        }




        Button buscar = getView().findViewById(R.id.buscar);

        /*buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lugar = ((EditText) getView().findViewById(R.id.buscar_por_hora)).getText().toString().trim();
                String Hora = ((EditText) getView().findViewById(R.id.buscar_por_lugar)).getText().toString().trim();
                Toast.makeText(getActivity(), "Falta por implementar", Toast.LENGTH_LONG).show();

                int i = 0;

                while(i < lanuevalista.length()){

                    Denuncia den = lanuevalista.getValue(i);
                    lanuevalista.deleteFirst();

                    String hora = den.getHora();
                    String lugar = den.getLugar();
                    String usuario = den.getUsuario();

                    bool = true;

                }


            }
        });*/

        Button volver = getView().findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bool){
                    Intent reg = new Intent(getActivity(), inicia_Pestañas.class);
                    getActivity().startActivity(reg);
                }
                else{
                    Toast.makeText(getActivity(), "Ya se están viendo todas las denuncias", Toast.LENGTH_LONG).show();
                }

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

        String densString = sharedPreferences.getString( "denuncia list", null);
        if(densString == null){
            ListaDenuncias = new LinkedList<>();
        }else {
            ListaDenuncias = toLinkedList(densString);
        }

    }
    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove( "denuncia list");
        String densString = "";

        for(int i = 0 ; i < ListaDenuncias.length;i++){

            Denuncia den = ListaDenuncias.getValue(i);
            densString = densString + toString(den);

        }

        editor.putString( "denuncia list", densString);
        editor.apply();

    }

    public static LinkedList<Denuncia> toLinkedList(String fullString){


        int j = 0;

        LinkedList<Denuncia> pruebafromstring = new LinkedList<Denuncia>();

        while(j < fullString.length()){

            if(Character.toString(fullString.charAt(j)).equals("{")){


                String denList = "";
                j++;
                while(!Character.toString(fullString.charAt(j)).equals("}")){
                    denList = denList+fullString.charAt(j);
                    j++;

                }

                Denuncia den = new Denuncia();
                den = fromString(denList);

                pruebafromstring.insertLast(den);
            }
            j++;
        }

        return pruebafromstring;

    }

    public static String toString(Denuncia den){

        String denString = "";

        String Hora = den.getHora();
        String lugar = den.getLugar();
        String usuario = den.getUsuario();
        String localidad = den.getLocalidad();

        denString = denString +"{" + Hora+ ">" + lugar+ "]"  + usuario + ")" +localidad+ "?";

        denString = denString + "}";




        return denString;

    }

    //string.indexOf('a')



    public static Denuncia fromString(String denString){

        int i = 0;
        String hora = "";
        String lugar = "";
        String usuario = "";
        String localidad = "";


        while(!Character.toString(denString.charAt(i)).equals(">")){
            hora = hora + denString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(denString.charAt(i)).equals("]")){
            lugar = lugar + denString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(denString.charAt(i)).equals(")")){
            usuario = usuario + denString.charAt(i);
            i++;
        }
        i++;
        while(!Character.toString(denString.charAt(i)).equals("?")){
            localidad = localidad + denString.charAt(i);
            i++;
        }
        i++;

        Denuncia den = new Denuncia();
        den.setLugar(lugar);
        den.setUsuario(usuario);
        den.setHora(hora);
        den.setLocalidad(localidad);

        return den;


    }


}

