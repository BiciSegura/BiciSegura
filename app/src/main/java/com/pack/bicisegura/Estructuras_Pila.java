package com.pack.bicisegura;

public class Estructuras_Pila<E> extends LinkedList {
    Node<E> head;
    Node<E> tail;
    int length;
    public Estructuras_Pila(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public E peek (){
        return (E) this.getFirst();
    }
    public E pop (){
        Node<E> T = new Node<E>();
        T = (Node<E>) this.getFirst();
        this.deleteFirst();
        return (E) T;

    }
    public void push(E element){
        this.insertFirst(element);
    }

}
