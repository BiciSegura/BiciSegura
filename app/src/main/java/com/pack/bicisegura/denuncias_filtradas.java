package com.pack.bicisegura;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class denuncias_filtradas extends AppCompatActivity {

    private ListView mListView;
    LinkedList<Denuncia> ListaDenuncias;
    Boolean bool = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_denuncias_filtradas);

        String Usuario = getIntent().getStringExtra("usuario");
        String Lugar = getIntent().getStringExtra("lugar");
        String Hora = getIntent().getStringExtra("hora");
        String Localidad = getIntent().getStringExtra("localidad");


        loadData();

        mListView = findViewById(R.id.listView);
        ListAdapter mAdapter;
        List<Denuncia> mLista = new ArrayList<>();
        List<Denuncia> pLista = new ArrayList<>();

        if(ListaDenuncias != null){
            while(ListaDenuncias.getFirst() != null){


                    Denuncia den = ListaDenuncias.getFirst();
                    ListaDenuncias.deleteFirst();

                    String hora = den.getHora();
                    String lugar = den.getLugar();
                    String usuario = den.getUsuario();
                    String localidad = den.getLocalidad();


                    mLista.add(new Denuncia(lugar,hora,usuario, localidad));
                    pLista.add(new Denuncia(lugar, hora, usuario, localidad));



            }


            int n = mLista.size();
            int cont = 0;

            System.out.println("SIZE: "+n);


            for(int i = 0; i < n; i++){
                if(!Usuario.equals("")){


                    Denuncia den = mLista.get(i);
                    String usu = den.getUsuario();
                    if(!Usuario.equals(usu)){
                        pLista.remove(i-cont);
                        cont = cont+1;

                        System.out.println(mLista.size()+ "----" + pLista.size());
                        continue;
                    }




                }

                if(!Lugar.equals("")){
                    Denuncia den = mLista.get(i);
                    String lug = den.getLugar();
                    if(!Lugar.equals(lug)){
                        pLista.remove(i-cont);
                        cont = cont+1;
                        continue;
                    }

                }

                if(!Hora.equals("")){
                    Denuncia den = mLista.get(i);
                    String hora = den.getHora();

                    if(!Hora.equals(hora)){
                        pLista.remove(i-cont);
                        cont = cont+1;
                        continue;
                    }
                }
                if(!Localidad.equals("")){
                    Denuncia den = mLista.get(i);
                    String loc = den.getLocalidad();

                    if(!Localidad.equals(loc)){
                        pLista.remove(i-cont);
                        cont = cont+1;
                        continue;
                    }
                }
            }

            mAdapter = new CustomAdapter_Denuncias(this, R.layout.elemento_listas_denuncia,pLista);
            mListView.setAdapter(mAdapter);



        }






    }


    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);

        String densString = sharedPreferences.getString( "denuncia list", null);
        if(densString == null){
            ListaDenuncias = new LinkedList<>();
        }else {
            ListaDenuncias = toLinkedList(densString);
        }

    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", Context.MODE_PRIVATE);

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

