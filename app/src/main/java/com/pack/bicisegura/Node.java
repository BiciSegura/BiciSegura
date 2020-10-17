package com.pack.bicisegura;

public class Node<E>{
    E value;
    Node<E> next;
    Node<E> prev;

    public Node(E value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public E getValue(){
        return this.value;
    }
    public void setValue(E value){
        this.value = value;
    }

}

