package com.pack.bicisegura;

// Implementacion de Binary Heap con Arreglos
public class MinHeap<Anytype extends Comparable<? super Anytype>>{

    private static final int default_capacity = 10;
    //Numero de elementos en el Heap
    public int tamañoActual;
    //Array del Heap
    public Anytype[] arr;

    public MinHeap() {
        this(default_capacity);
    }
    public MinHeap(int capacidad) {
        tamañoActual = 0;
        arr = (Anytype []) new Comparable[capacidad+1];
    }


    public void insert(Anytype x) {
        if(tamañoActual == arr.length-1) {
            enlargeArray(arr.length*2+1);
        }


        int hueco = ++tamañoActual;
        for(arr[0] = x; x.compareTo(arr[hueco / 2]) < 0;hueco /= 2) {
            arr[ hueco ] = arr[ hueco / 2 ];
        }
        arr[ hueco ] = x;
    }


    public Anytype findmin() {    //HACE FALTA AGREGAR LA EXCEPTION CUANDO ESTA VACIO
        return arr[1];
    }
    public Anytype deleteMin() {
        Anytype minValue = this.findmin();
        arr[1] = arr[tamañoActual--];
        percolateDown(1);
        return minValue;
    }

    public boolean isEmpty() {
        return tamañoActual == 0;

    }
    public void makeEmpty() {
        tamañoActual = 0;
    }
    private void percolateDown(int hueco) {
        int hijo;
        Anytype aux = arr[hueco];
        for(;hueco*2<=tamañoActual; hueco = hijo) {
            hijo = hueco*2;
            if (hijo != tamañoActual && arr[hijo+1].compareTo(arr[hijo])<0) {
                hijo++;
            }if(arr[hijo].compareTo(aux)<0) {
                arr[hueco] = arr[hijo];
            }else {
                break;
            }
        }

    }

    private void enlargeArray(int newSize) {
        Anytype[] oldArr = arr;
        arr = (Anytype []) new Comparable[newSize];
        for (int i = 0; i< oldArr.length;i++) {
            arr[i] = oldArr[i];
        }
    }




}

