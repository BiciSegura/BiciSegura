package com.pack.bicisegura;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Menos_Peligrosas extends Fragment{

    private ListView mListView;
    LinkedList<Denuncia> ListaDenuncias;

    
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();
        HeapRobos MenosR = new HeapRobos();
        MenosR.insert(new Localidad("Usaquén",0));
        MenosR.insert(new Localidad("Chapinero",0));
        MenosR.insert(new Localidad("Santa Fe",0));
        MenosR.insert(new Localidad("San Cristóbal",0));
        MenosR.insert(new Localidad("Usme",0));
        MenosR.insert(new Localidad("Tunjuelito",0));
        MenosR.insert(new Localidad("Bosa",0));
        MenosR.insert(new Localidad("Kennedy",0));
        MenosR.insert(new Localidad("Fontibón",0));
        MenosR.insert(new Localidad("Engativá",0));
        MenosR.insert(new Localidad("Suba",0));
        MenosR.insert(new Localidad("Barrios Unidos",0));
        MenosR.insert(new Localidad("Teusaquillo",0));
        MenosR.insert(new Localidad("Los Mártires",0));
        MenosR.insert(new Localidad("Antonio Nariño",0));
        MenosR.insert(new Localidad("Puente Aranda",0));
        MenosR.insert(new Localidad("La Candelaria",0));
        MenosR.insert(new Localidad("Rafael Uribe Uribe",0));
        MenosR.insert(new Localidad("Ciudad Bolívar",0));
        MenosR.insert(new Localidad("Sumapaz",0));


        for (int i=0; i<ListaDenuncias.length;i++){
            Denuncia temp = new Denuncia();
            temp = ListaDenuncias.getValue(i);
            MenosR.aumento(temp.getLocalidad());
        }


        /* lanuevalista.fillList(1000);*/

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Localidad> mLista = new ArrayList<>();


        while(MenosR.tamañoActual != 0){

            Localidad loca = MenosR.deleteMin();
            String nombre = loca.getNombre();
            int num = loca.getNumeroRobos();
            mLista.add(new Localidad(nombre,num));

            System.out.println(nombre + num);
            mAdapter = new CustomAdapter_Localidades(requireActivity().getApplicationContext(), R.layout.elemento_listas_localidades,mLista);
            mListView.setAdapter(mAdapter);
        }


            /*while(ListaDenuncias.getFirst() != null){


                Denuncia den = ListaDenuncias.getFirst();
                ListaDenuncias.deleteFirst();

                String hora = den.getHora();
                String lugar = den.getLugar();
                String usuario = den.getUsuario();
                String localidad = den.getLocalidad();

                mLista.add(new Denuncia(lugar,hora,usuario, localidad));
                mAdapter = new CustomAdapter_Denuncias(requireActivity().getApplicationContext(), R.layout.elemento_listas_denuncia,mLista);
                mListView.setAdapter(mAdapter);

            }*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_localidades, container, false);
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

