/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercado;

/**
 *
 * @author maria
 */
public class Item {
    Producto p;
    int cantidad ;

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Item(Producto p, int cantidad) {
        this.p = p;
        this.cantidad = cantidad;
    }
    @Override
    public String toString(){
       return String.format("%20s %6.2f %4d", p.getNombre(),p.getPrecio(),cantidad);
    }
}
