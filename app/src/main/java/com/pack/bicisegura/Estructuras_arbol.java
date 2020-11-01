/*package com.pack.bicisegura;

import java.lang.annotation.ElementType;

public class Estructuras_Cola <E> extends LinkedList {

    Node<E> head;
    Node<E> tail;
    int length;
    public Estructuras_Cola(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    E poll (){
        Node<E> T = new Node<E>();
        T = (Node<E>) this.getLast();
        this.deleteLast();
        return (E) T;

    }

    E peek (){
        return (E) this.getLast();
    }

    public void offer (E element){
        this.insertFirst(element);
    }


}
*/