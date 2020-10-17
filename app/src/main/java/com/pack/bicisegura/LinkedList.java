package com.pack.bicisegura;

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


    E getFirst() {
        if (!this.isEmpty()){
            return this.head.value;

        } else {
            return null;
        }
    }


    E getLast(){
        if (!this.isEmpty()){
            return this.tail.value;
        } else {
            return null;
        }
    }


    void deleteFirst() {
        if (this.length != 0){
            this.head.next.prev = null;
            this.head = this.head.next;

            this.length--;
        } else {
            System.out.println("No puedo eliminar en una lista vacia");
        }
    }


    void deleteLast() {
        if (this.length != 0){
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.length--;
        } else {
            System.out.println("No puedo eliminar en una lista vacia");
        }
    }



    void insertFirst(E element) {
        if(!this.isEmpty()){
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


    void insertLast(E element) {
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


    boolean isEmpty() {
        return this.length == 0;
    }


    Integer length() {
        return this.length;
    }


    void setValue(Integer index, E value){

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

    void deleteIndex(Integer index){

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



    void deleteValue(E value){
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




    void insert(Integer index, E value){
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



    void clear(){
        this.head=null;
        this.tail=null;
    }

    boolean contain(E value){


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
            }

            else{
                return false;
            }

        }

    }


}

