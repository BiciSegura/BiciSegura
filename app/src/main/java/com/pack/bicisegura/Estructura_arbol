package com.pack.bicisegura;
//import java.util.math;

 class NodoAvl<E extends Comparable<?super E>>{
    public E value;
    public NodoAvl<E> left;
    public NodoAvl<E> rigth;
    public int heigth;


    public NodoAvl(E value){
        this.value = value;
        this.left = null;
        this.rigth = null;
        this.heigth= -1;
    }
     public E getValue(){
         return this.value;
     }
     public void setValue(E value){
         this.value = value;
     }
     public int getHeigth(){
         return this.heigth;
     }
     public void setHeigth(int heigth){
         this.heigth = heigth;
     }
 }

 public class Estructura_arbol<E extends Comparable<?super E>>{


     public NodoAvl<E> root;
     public int heigthleft=0;
     public int heigthrigth=0;

     public Estructura_arbol(){
         this.root = null;
     }
//METODO PARA HALLAR LA ALTURA DE UN ARBOL
     public int altura(NodoAvl root){

        /* if(this.root != null){
                return 1 + Math.max(altura(root.left), altura(root.rigth));
         }else{
             return 0;
         }*/
         return root == null ? -1 : root.heigth;
     }
     public void insert(E value){
         this.root = this.insert(value, this.root);
     }

     private NodoAvl<E> insert(E value, NodoAvl<E> node){
         if(node == null){
             return new NodoAvl<>(value);
         }else{
             int resultCompare = node.value.compareTo(value);
             if(resultCompare == 1) {
                 node.left = this.insert(value, node.rigth);
             }  // > - 1
             else if(resultCompare == -1) {
                 node.rigth = this.insert(value, node.left);
             } // < -1
             else {}
             return balanceo(node); // == 0
         }
     }


    public void remove( E x )
    {
        root = remove( x, root );
    }

     private NodoAvl<E> remove( E x, NodoAvl<E> t )
     { if( t == null )

         return t; // Item not found; do nothing
         int compareResult = x.compareTo( t.value );
         if( compareResult < 0 )
             t.left = remove( x, t.left );
         else if( compareResult > 0 )
             t.rigth = remove( x, t.rigth );
         else if( t.left != null && t.rigth != null ) // Two children
         { t.value = findMin( t.rigth ).value;
             t.rigth = remove( t.value, t.rigth );
         }
         else
             t = ( t.left != null ) ? t.left : t.rigth;
         return balanceo(t);
     }


     public E findMin(){
         return this.findMin(this.root).value;
     }

     private NodoAvl<E> findMin(NodoAvl<E> node){
         if(node.left == null)
             return node;
         else
             return this.findMin(node.left);
     }

     public E findMax(){
         return this.findMin(this.root).value;
     }

     private NodoAvl<E> findMax(NodoAvl<E> node){
         if(node.rigth == null)
             return node;
         else
             return this.findMin(node.rigth);
     }



     public void makeEmpty(){
         this.root = null;
     }

     public boolean isEmpty(){
         return this.root == null;
     }



     private boolean findValue(E value, NodoAvl<E> node){

         int resultCompare = node.value.compareTo(value);

         if(resultCompare == 0){
             return true;
         }
         else if(resultCompare == 1) {
            // node.left = this.findValue(value, node.rigth);
             return findValue(value, node.left);
         }  // > - 1
         else if(resultCompare == -1) {
             return findValue(value, node.rigth);
         } // < -1
         else {
             return false;
         }

     }
     private static final int ALLOWED_IMBALANCE = 1;

     private NodoAvl<E> balanceo(NodoAvl<E> node){
         if( node == null )
             return node;

          if( altura( node.left ) - altura( node.rigth ) > ALLOWED_IMBALANCE )
              if( altura( node.left.left ) >= altura( node.left.rigth) )
                  node = SingleRotateLeft( node );
              else
                  node = DobleRotateLeft( node );
           else
              if( altura( node.rigth ) - altura( node.left ) > ALLOWED_IMBALANCE )
                  if( altura( node.rigth.rigth ) >= altura( node.rigth.left ) )
                  node = SingleRotateRight( node );
          else
          node = DobleRotateRigth( node );

          node.heigth = Math.max( altura( node.left ), altura( node.rigth ) ) + 1;
           return node;

     }

     private NodoAvl<E> SingleRotateRight (NodoAvl<E> node){
         NodoAvl<E> aux = node.rigth;
         node.rigth = aux.left;
         aux.left = node;
         node.heigth = Math.max( altura( node.left ), altura( node.rigth ) ) + 1;
         aux.heigth = Math.max( altura( aux.left ), node.heigth ) + 1;
         return aux;

     }
     private NodoAvl<E> SingleRotateLeft (NodoAvl<E> node){

          NodoAvl<E> aux = node.left;
          node.left = aux.rigth;
          aux.rigth = node;
          node.heigth = Math.max( altura( node.left ), altura( node.rigth ) ) + 1;
          aux.heigth = Math.max( altura( aux.left ), node.heigth ) + 1;
          return aux;

     }
     private NodoAvl<E> DobleRotateRigth(NodoAvl<E> node){
         node.rigth = SingleRotateLeft( node.rigth );
         return SingleRotateRight( node );

     }
     private NodoAvl<E> DobleRotateLeft(NodoAvl<E> node){
         node.left = SingleRotateRight( node.left );
          return SingleRotateLeft( node );

     }

 }
