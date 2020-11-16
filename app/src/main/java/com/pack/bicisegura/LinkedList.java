package com.pack.bicisegura;
import java.util.Random;

public class LinkedList <E> {
    Node<E> head;
    Node<E> tail;
    int length;


    public LinkedList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }


    public E getValue(Integer index){
        if (index == 0){
            return this.head.value;

        } else if (index == this.length-1){
            return this.tail.value;

        } else if (index > this.length){
            System.out.println("El índice es mayor al tamaño de la lista");
            return null;

        } else {
            Node<E> aux = this.head;
            for(int i = 0; i < index; i++){
                aux = aux.next;

            }

            return aux.value;
        }
    }


    public E getFirst() {
        if (this.length != 0){
            return this.head.value;

        } else {
            return null;
        }
    }


    public E getLast(){
        if (!this.isEmpty()){
            return this.tail.value;
        } else {
            return null;
        }
    }


    public void deleteFirst() {
        if (this.length >1){
            this.head.next.prev = null;
            this.head = this.head.next;

            this.length--;
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length = 0;

        }
        else {
            System.out.println("No puedo eliminar en una lista vacia");
        }
    }


    public void deleteLast() {
        if (this.length > 1){
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.length--;
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length = 0;
        }
        else {
            System.out.println("No puedo eliminar en una lista vacia");
        }
    }



    public void insertFirst(E element) {
        if(this.length != 0){
            this.length++;
            Node<E> newFirst = new Node<E>(element);
            newFirst.next = this.head;
            this.head.prev = newFirst;
            newFirst.prev = null;
            this.head = newFirst;
        }
        else{
            this.length++;
            Node<E> newFirst = new Node<E>(element);
            newFirst.next= null;
            newFirst.prev = null;
            this.head = newFirst;
            this.tail = newFirst;
        }

    }


    public void insertLast(E element) {
        if(!this.isEmpty()){
            this.length++;
            Node<E> newLast = new Node<E>(element);
            newLast.prev = this.tail;
            this.tail.next = newLast;
            newLast.next = null;
            this.tail = newLast;
        }else{
            this.length++;
            Node<E> newLast = new Node<E>(element);
            newLast.next= null;
            newLast.prev = null;
            this.head = newLast;
            this.tail = newLast;
        }
    }


    public boolean isEmpty() {
        return this.length == 0;
    }


    public Integer length() {
        return this.length;
    }


    public void setValue(Integer index, E value){

        Node<E> aux = this.head;

        if( index < 0 || index >= this.length){
            System.out.println("El índice está fuera del rango");
        }
        else{
            for(int i = 0; i < index; i++){
                aux = aux.next;
            }
            aux.value = value;
        }
    }

    public void deleteIndex(Integer index){

        Node<E> aux = head;

        if(index==0) {
            this.deleteFirst();
            this.length--;
        }else if(index==this.length-1) {
            this.deleteLast();
            this.length--;
        }else if(index < 0 || index >= this.length) {
            System.out.println("El índice está fuera del rango");
        }else{
            for(int i = 0; i < index; i++){
                aux = aux.next;
            }

            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            this.length--;

        }

    }




    public int findFirstValue(E value) throws Exception{
        Node<E> aux = head;
        Exception e = new Exception();
        if(this.length == 0 ){
            System.out.println("La lista esta vacia.");
            throw e;
        }else{
            for(int i=0;i < this.length ; i++){
                if(aux.value.equals(value)){
                    return i;
                }else{
                    aux = aux.next;
                }
            }
            throw e;

        }
    }



    public int findLastValue(E value) throws Exception{
        Node<E> aux = tail;

        if(this.length == 0 ){
            System.out.println("La lista esta vacia.");
            throw new Exception();
        }else{
            for(int i = 0;i < this.length ; i++){
                if(aux.value == value){
                    return this.length - i;
                }else{
                    aux = aux.prev;
                }
            }
            throw new Exception();
        }
    }



    public void deleteValue(E value){
        Node<E> aux = this.head;
        if(this.length == 0 ){
            System.out.println("La lista esta vacia.");
        }else{
            int count = 1;
            for(int i=0; i < this.length ; i++){
                if(aux.value.equals(value)){
                    this.deleteIndex(i);
                    break;
                }else{
                    aux = aux.next;
                    count = count + 1;
                    if (count == this.length ){
                        System.out.println("El valor no esta en la lista.");
                    }
                }
            }
        }
    }




    public void insert(Integer index, E value){
        Node<E> newnode = new Node<E>(value);
        Node<E> current = this.head;

        if(index <= this.length && this.head != null){


            for(int i=0; i<index-1;i++){
                current = current.next;

            }

            if(index == this.length){
                this.insertLast(value);

                index = this.length;
            }

            else if(index == 0){
                this.insertFirst(value);
            }

      /*else if(index==this.length-1){

        newnode.next = current.next;
        newnode.prev = current;
        current.next.prev = newnode;
        current.next = newnode;

        this.length++;

      }*/
            else if(0<index && index<this.length){

                newnode.next = current.next;
                newnode.prev = current;

                current.next = newnode;
                newnode.next.prev = newnode;

                this.length++;

            }

        }

        else if(this.head==null){
            this.insertFirst(value);
        }
    }



    public void clear(){
        this.head=null;
        this.tail=null;
    }

    public boolean contain(E value){
        if(this.length == 0 ){
            return false;

        }else{
            Node<E> aux = head;
            for(int i=0;i < this.length ; i++){
                if(aux.value == value){
                    break;
                }else{

                    if(aux.next == null){
                        break;
                    }
                    else{
                        aux = aux.next;
                    }
                }
            }
            if(aux.value == value){
                return true;
            } else{
                return false;
            }
        }
    }


    public void fillList(int cantidad){
        Random rand = new Random();
        int horamax = 2400;
        int callemax = 200;
        int localidadmax = 20;
        String localidad_s = new String();
        for(int i = 0 ; i < cantidad; i++){
            int hora = rand.nextInt(horamax);
            int calle_random = rand.nextInt(callemax);
            int carrera_random = rand.nextInt(callemax);
            int numero_random = rand.nextInt(callemax);
            int locanum_random = rand.nextInt(localidadmax);
            switch (locanum_random) {
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
            String lugar = "calle " + calle_random + " carrera " + carrera_random + " - " + numero_random;
            Denuncia P = new Denuncia();
            P.setHora(Integer.toString(hora));
            P.setLugar(lugar);
            P.setUsuario("pepito" +i);
            P.setLocalidad(localidad_s);
            this.insertLast((E) P);

        }
    }

    public E pop (){
        E T = (E) this.getFirst();
        this.deleteFirst();
        return T;

    }


}

