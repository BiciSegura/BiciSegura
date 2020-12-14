package com.pack.bicisegura;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Mejores_Rutas extends Fragment {

    LinkedList<Denuncia> ListaDenuncias;

    int[][] matrizLocalidades = {{0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,0},{0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,1,1,0},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0},{0,1,1,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,0},{0,0,0,0,0,1,0,1,1,0,0,0,1,1,1,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    private ListView mListView;
    private Spinner spinner1;
    private Spinner spinner2;

    private static final String[]paths1 = {"Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme",
            "Tunjuelito", "Bosa", "Kennedy", "Fontibón", "Engativá", "Suba", "Barrios Unidos" , "Teusaquillo",
            "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"};
    private static final String[]paths2 = {"Usaquén", "Chapinero", "Santa Fe", "San Cristóbal", "Usme",
            "Tunjuelito", "Bosa", "Kennedy", "Fontibón", "Engativá", "Suba", "Barrios Unidos" , "Teusaquillo",
            "Los Mártires", "Antonio Nariño", "Puente Aranda", "La Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListView = getView().findViewById(R.id.listView);
        ListAdapter mAdapter;

        spinner1 = (Spinner)getView().findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(requireActivity().getApplicationContext(), android.R.layout.simple_spinner_item,paths1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner)getView().findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(requireActivity().getApplicationContext(), android.R.layout.simple_spinner_item,paths2);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        final List<Localidad> mLista = new ArrayList<>();

        Button buscar = getView().findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String localidadInicial = spinner1.getSelectedItem().toString();
                String localidadFinal = spinner2.getSelectedItem().toString();

                int init, fin;
                init = localidadAInt(localidadInicial);
                fin = localidadAInt(localidadFinal);

                loadData();
                for (int i=0; i<ListaDenuncias.length;i++){
                    Denuncia temp = new Denuncia();
                    temp = ListaDenuncias.getValue(i);
                    String localidad_s = temp.getLocalidad();

                    switch (localidad_s) {
                        case "Usaquén":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[0][k] != 0) {
                                    matrizLocalidades[0][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][0]!=0){
                                    matrizLocalidades[k][0]++;
                                }
                            }
                            break;
                        case "Chapinero":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[1][k] != 0) {
                                    matrizLocalidades[1][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][1]!=0){
                                    matrizLocalidades[k][1]++;
                                }
                            }
                            break;
                        case "Santa fe":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[2][k] != 0) {
                                    matrizLocalidades[2][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][2]!=0){
                                    matrizLocalidades[k][2]++;
                                }
                            }
                            break;
                        case "San Critóbal":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[3][k] != 0) {
                                    matrizLocalidades[3][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][3]!=0){
                                    matrizLocalidades[k][3]++;
                                }
                            }
                            break;
                        case "Usme":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[4][k] != 0) {
                                    matrizLocalidades[4][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][4]!=0){
                                    matrizLocalidades[k][4]++;
                                }
                            }
                            break;
                        case "Tunjuelito":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[5][k] != 0) {
                                    matrizLocalidades[5][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][5]!=0){
                                    matrizLocalidades[k][5]++;
                                }
                            }
                            break;
                        case "Bosa":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[6][k] != 0) {
                                    matrizLocalidades[6][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][6]!=0){
                                    matrizLocalidades[k][6]++;
                                }
                            }
                            break;
                        case "Kennedy":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[7][k] != 0) {
                                    matrizLocalidades[7][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][7]!=0){
                                    matrizLocalidades[k][7]++;
                                }
                            }
                            break;
                        case "Fontibón":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[8][k] != 0) {
                                    matrizLocalidades[8][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][8]!=0){
                                    matrizLocalidades[k][8]++;
                                }
                            }
                            break;
                        case "Engativá":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[9][k] != 0) {
                                    matrizLocalidades[9][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][9]!=0){
                                    matrizLocalidades[k][9]++;
                                }
                            }
                            break;
                        case "Suba":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[10][k] != 0) {
                                    matrizLocalidades[10][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][10]!=0){
                                    matrizLocalidades[k][10]++;
                                }
                            }
                            break;
                        case "Barrios Unidos":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[11][k] != 0) {
                                    matrizLocalidades[11][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][11]!=0){
                                    matrizLocalidades[k][11]++;
                                }
                            }
                            break;
                        case "Teusaquillo":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[12][k] != 0) {
                                    matrizLocalidades[12][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][12]!=0){
                                    matrizLocalidades[k][12]++;
                                }
                            }
                            break;
                        case "Los Mártires":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[13][k] != 0) {
                                    matrizLocalidades[13][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][13]!=0){
                                    matrizLocalidades[k][13]++;
                                }
                            }
                            break;
                        case "Antonio Nariño":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[14][k] != 0) {
                                    matrizLocalidades[14][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][14]!=0){
                                    matrizLocalidades[k][14]++;
                                }
                            }
                            break;
                        case "Puente Aranda":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[15][k] != 0) {
                                    matrizLocalidades[15][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][15]!=0){
                                    matrizLocalidades[k][15]++;
                                }
                            }
                            break;
                        case "Candelaría":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[16][k] != 0) {
                                    matrizLocalidades[16][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][16]!=0){
                                    matrizLocalidades[k][16]++;
                                }
                            }
                            break;
                        case "Rafael Uribe":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[17][k] != 0) {
                                    matrizLocalidades[17][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][17]!=0){
                                    matrizLocalidades[k][17]++;
                                }
                            }
                            break;
                        case "Ciudad Bolivar":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[18][k] != 0) {
                                    matrizLocalidades[18][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][18]!=0){
                                    matrizLocalidades[k][18]++;
                                }
                            }
                            break;
                        case "Sumapaz":
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[19][k] != 0) {
                                    matrizLocalidades[19][k]++;

                                }
                            }
                            for(int k=0;k<20;k++){
                                if(matrizLocalidades[k][19]!=0) {
                                    matrizLocalidades[k][19]++;
                                }
                            }
                            break;
                    }
                }

                int[] preD = dijkstra(matrizLocalidades, init, fin);

                Localidad laloca = new Localidad();
                laloca.setNombre(intALocalidad(fin));

                mLista.add(laloca);
                int j = fin;
                while(j!=0){

                    j = preD[j];
                    laloca.setNombre(intALocalidad(preD[j]));
                    mLista.add(laloca);
                    System.out.print(" <- " + j);


                }
                laloca.setNombre(spinner1.toString());
                mLista.add(laloca);
                System.out.print(" <- " + init);
                System.out.println();





            }


        });

        mAdapter = new CustomAdapter_Camino(requireActivity().getApplicationContext(), R.layout.elemento_listas_camino,mLista);
        mListView.setAdapter(mAdapter);


        //pediriamos el inicial y final





    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mejores_rutas, container, false);
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

    public static int[] dijkstra(int[][] matrix, int ini, int fin){

        int initoriginal = ini;
        int[] preD = new int[20];
        if(ini == fin){
            System.out.println("Path = "+ini+" <-"+fin);
            return preD;
        }
        else{
            if(ini != 0){

                int[] tmp = matrix[ini];

                matrix[ini] = matrix[0];
                matrix[0] = tmp;

                for(int i = 0; i < 20; i++){

                    if(i != ini && i != fin){
                        int temp = matrix[i][ini];
                        matrix[i][ini] = matrix[i][0];
                        matrix[i][0] = temp;
                    }



                }

            }

            int min = 999, nextNode = 0; // min holds the minimum value, nextNode holds the value for the next node.
            //scan = new Scanner(System.in);
            int[] distance = new int[20]; // the distance matrix
            int[] visited = new int[20]; // the visited array

            //System.out.println("Enter the cost matrix");

            for(int i = 0; i < distance.length; i++){

                visited[i] = 0; //initialize visited array to zeros

                preD[i] = 0;

                for(int j = 0; j < distance.length; j++){

                    if(matrix[i][j]==0){

                        matrix[i][j] = 999; // make the zeros as 999

                    }

                }

            }


            distance = matrix[0]; //initialize the distance array
            visited[0] = 1; //set the source node as visited
            distance[0] = 0; //set the distance from source to source to zero which is the starting point

            for(int counter = 0; counter < 20; counter++){

                min = 999;

                for(int i = 0; i < 20; i++){

                    if(min > distance[i] && visited[i]!=1){

                        min = distance[i];
                        nextNode = i;

                    }

                }

                visited[nextNode] = 1;

                for(int i = 0; i < 20; i++){

                    if(visited[i]!=1){

                        if(min+matrix[nextNode][i] < distance[i]){

                            distance[i] = min+matrix[nextNode][i];
                            preD[i] = nextNode;

                        }

                    }

                }

            }
        /*
        *
        *
        for(int i = 0; i < 20; i++){

            System.out.print("|" + distance[i]);


        }
        System.out.println("|");
        *
        **
        */
            //int j = 20;

            /*
            *
            * *
            * *

            System.out.print("Path = " + fin);
            int j = fin;
            while(j!=0){

                j = preD[j];
                System.out.print(" <- " + j);


            }
            System.out.print(" <- " + initoriginal);
            System.out.println();
            *
            * *
            * *
            */
            return preD;

        }

    }

    public static int localidadAInt (String localidad){
        int iLocalidad = 0;
        switch (localidad) {
            case "Usaquén":
                iLocalidad = 0;
                break;
            case "Chapinero":
                iLocalidad = 1;
                break;
            case "Santa Fe":
                iLocalidad = 2;
                break;
            case "San Cristóbal":
                iLocalidad = 3;
                break;
            case "Usme":
                iLocalidad = 4;
                break;
            case "Tunjuelito":
                iLocalidad = 5;
                break;
            case "Bosa":
                iLocalidad = 6;
                break;
            case "Kennedy":
                iLocalidad = 7;
                break;
            case "Fontibón":
                iLocalidad = 8;
                break;
            case "Engativá":
                iLocalidad = 9;
                break;
            case "Suba":
                iLocalidad = 10;
                break;
            case "Barrios Unidos":
                iLocalidad = 11;
                break;
            case "Teusaquillo":
                iLocalidad = 12;
                break;
            case "Los Mártires":
                iLocalidad = 13;
                break;
            case "Antonio Nariño":
                iLocalidad = 14;
                break;
            case "Puente Aranda":
                iLocalidad = 15;
                break;
            case "La Candelaria":
                iLocalidad = 16;
                break;
            case "Rafael Uribe Uribe":
                iLocalidad = 17;
                break;
            case "Ciudad Bolívar":
                iLocalidad = 18;
                break;
            case "Sumapaz":
                iLocalidad = 19;
                break;
        }
        return iLocalidad;

    }

    public static String intALocalidad (int localidad){
        String localidad_s = " ";
        switch (localidad) {
            case 0:
                localidad_s = "Usaquén";
                break;
            case 1:
                localidad_s = "Chapinero";
                break;
            case 2:
                localidad_s = "Santa Fe";
                break;
            case 3:
                localidad_s = "San Cristóbal";
                break;
            case 4:
                localidad_s = "Usme";
                break;
            case 5:
                localidad_s = "Tunjuelito";
                break;
            case 6:
                localidad_s = "Bosa";
                break;
            case 7:
                localidad_s = "Kennedy";
                break;
            case 8:
                localidad_s = "Fontibón";
                break;
            case 9:
                localidad_s = "Engativá";
                break;
            case 10:
                localidad_s = "Suba";
                break;
            case 11:
                localidad_s = "Barrios Unidos";
                break;
            case 12:
                localidad_s = "Teusaquillo";
                break;
            case 13:
                localidad_s = "Los Mártires";
                break;
            case 14:
                localidad_s = "Antonio Nariño";
                break;
            case 15:
                localidad_s = "Puente Aranda";
                break;
            case 16:
                localidad_s = "La Candelaria";
                break;
            case 17:
                localidad_s = "Rafael Uribe Uribe";
                break;
            case 18:
                localidad_s = "Ciudad Bolívar";
                break;
            case 19:
                localidad_s = "Sumapaz";
                break;
        }
        return localidad_s;

    }

}
