package com.pack.bicisegura;

class NodoAVL<T extends Comparable<?super T>> {
    public T value;
    public NodoAVL<T> left;
    public NodoAVL<T> rigth;
    public int heigth;

    public NodoAVL(T value) {
        this.value = value;
        this.left = null;
        this.rigth = null;
        this.heigth = -1;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}

public class Estructuras_arbol<T extends Comparable<?super T>>{

    public NodoAVL root;
    int heigthleft=0;
    int heigthrigth=0;

    public int altura(NodoAVL root){

        if(this.root != null){
            if(this.root.left != null ){
                heigthleft += 1;
                altura(root.left);}
            else if(this.root.rigth != null ){
                heigthrigth += 1;
                altura(root.left);}

        }else{
            if(heigthleft > heigthrigth){
                root.heigth=heigthleft;
            }else if (heigthleft == heigthrigth){
                root.heigth=heigthleft;

            }else {
                root.heigth=heigthrigth;
            }

        }
        return root.heigth;

    }

    /*public E datomenor(Estructura_arbol root){
        E result=null;
        while(root.value != null){
            if(this.root.left.value > this.root.value && this.root.value < this.root.rigth.value ){
                result = this.root.value;
                return result;
                break;
            }
            else if(this.root.left.value)




        }
        return result;

    }
    public E datomayor(Estructura_arbol root){
        E result=null;
        while(root.value != null){
            if(this.root.left.value > this.root.value && this.root.value < this.root.rigth.value ){
                result = this.root.value;
                return result;
                break;
            }




        }
        return result;

    }
   public void insert(){}
   public E findValue(){}


}*/
}