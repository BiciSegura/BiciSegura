package com.pack.bicisegura;
import java.util.*;
import java.util.Random;

public class Estructuras_Hashmap<T> extends LinkedList{

    public LinkedList<T> [] cora;
    public int size;
    public int ocupadas;

    public Estructuras_Hashmap (int size){
        this.cora= new LinkedList [nextPrime(size)];
        this.size=size;
    }
    public int functionHash (T value){
        //codigo tomado de Mark Allen Weiss
        int hashVal = value.hashCode( );

        hashVal %= cora.length;
        if( hashVal < 0 )
            hashVal += cora.length;

        return hashVal;

    }
    public void inserts (T value){

        int pos= functionHash(value);
        LinkedList<T> nuevo = cora[ pos ];
        if(!nuevo.contain(value)){
            nuevo.insertFirst(value);
            ocupadas++;
        }

    }

    public void deletes(T value){
        int pos= functionHash(value);
        LinkedList<T> nuevo = cora[ pos ];
        if(nuevo.contain(value)){
            nuevo.deleteValue(value);
            ocupadas--;
        }

    }
    public boolean contieneValue(T value){

        int pos= functionHash(value);
        LinkedList<T> nuevo = cora[ pos ];
        if(nuevo.contain(value)){
           return true;
        }else{
            return false;
        }

    }

    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !esPrimo( n ); n += 2 )
            ;

        return n;
    }

    private static boolean esPrimo( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }





}