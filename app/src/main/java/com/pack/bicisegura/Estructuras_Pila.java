package com.pack.bicisegura;

public class Estructuras_Pila<E> extends LinkedList {

    public Estructuras_Pila(){
        super();
    }

    public E peek (){
        return (E) this.getFirst();
    }

    public void push(E element) {
        this.insertFirst(element);
    }

}
