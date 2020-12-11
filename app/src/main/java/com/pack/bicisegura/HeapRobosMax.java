package com.pack.bicisegura;

import java.util.HashMap;

public class HeapRobosMax {
    private static final int default_capacity = 10;
    public int tamañoActual;
    public Localidad[] arr;
    HashMap<String,Integer> posiciones = new HashMap<>();

    public HeapRobosMax() {
        this(default_capacity);
    }

    //Contructor con capacidad

    public HeapRobosMax(int capacidad) {
        tamañoActual = 0;
        arr = new Localidad[capacidad+1];
    }

    public void insert(Localidad x) {
        if(tamañoActual == arr.length-1) {
            enlargeArray(arr.length*2+1);
        }


        int hueco = ++tamañoActual;
        for(arr[0] = x; x.compareTo(arr[hueco / 2]) > 0;hueco /= 2) {
            arr[ hueco ] = arr[ hueco / 2 ];
            posiciones.put(arr[ hueco / 2 ].getNombre(),hueco);
        }
        arr[ hueco ] = x;
        posiciones.put(x.getNombre(),hueco);

    }
    public Localidad findMax() {
        //HACE FALTA AGREGAR LA EXCEPTION CUANDO ESTA VACIO
        return arr[1];
    }
    public Localidad deleteMax() {
        Localidad minValue = this.findMax();
        posiciones.remove(minValue.getNombre());

        arr[1] = arr[tamañoActual--];
        posiciones.put(arr[1].getNombre(),1);

        percolateDown(1);

        return minValue;
    }
    public void percolateDown(int hueco) {
        int hijo;
        Localidad aux = arr[hueco];
        for(;hueco*2<=tamañoActual; hueco = hijo) {
            hijo = hueco*2;
            if (hijo != tamañoActual && arr[hijo+1].compareTo(arr[hijo])>0) {
                hijo++;
            }if(arr[hijo].compareTo(aux)>0) {
                arr[hueco] = arr[hijo];
                posiciones.put(arr[hijo].getNombre(),hueco);
            }else {
                break;
            }
        }
        arr[hueco]= aux;
        posiciones.put(aux.getNombre(),hueco);

    }
    private void enlargeArray(int newSize) {
        Localidad[] oldArr = arr;
        arr = new Localidad[newSize];
        for (int i = 0; i< oldArr.length;i++) {
            arr[i] = oldArr[i];
        }
    }
    public void aumento(String Localidad) {
        int pos = posiciones.get(Localidad);
        int robL = arr[pos].getNumeroRobos();
        arr[pos].setNumeroRobos(robL+1);

        Localidad x = arr[pos];
        int hueco = pos;
        for(arr[0] = x; x.compareTo(arr[hueco / 2]) > 0;hueco /= 2) {
            arr[ hueco ] = arr[ hueco / 2 ];
            posiciones.put(arr[ hueco / 2 ].getNombre(),hueco);
        }
        arr[ hueco ] = x;
        posiciones.put(x.getNombre(),hueco);

    }




}
