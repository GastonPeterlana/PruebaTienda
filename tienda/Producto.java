/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mercado;

import java.util.Objects;

/**
 * Producto.java
 * @author:  Pilar
 * @version 26-abr-2017 1:01:22
 */
public class Producto implements Comparable { 

public String nombre; 
public int cantidad; 
public float precio;

public Producto(String s, int i) {
nombre = s;
cantidad = i;
} 
public Producto(String s, int i,float p) {
nombre = s;
cantidad = i;
precio=p;
} 
public String toString(){
return ("Nombre: "+nombre+" Precio: "+precio+" Cantidad: "+cantidad);
}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

public int compareTo( Object objeto ) {
// Indica en base a que atributos se compara el objeto
// Devuelve +1 si this es > que objeto
// Devuelve -1 si this es < que objeto
// Devuelve 0 si son iguales

Producto producto = (Producto)objeto;
String nombreObjeto = producto.nombre.toLowerCase();
String nombreThis = this.nombre.toLowerCase();

return( nombreThis.compareTo( nombreObjeto ) );
}

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
