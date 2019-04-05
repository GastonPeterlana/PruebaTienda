package PruebaTienda;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Item> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public ArrayList<Item> get() {
        return items;
    }

    public void add(Item i){
        int index = items.indexOf(i);
        if (index == -1)
            items.add(i);
        else
            items.get(index).addCant(i.getCantidad());
    }

    public void mostrar(){
        System.out.println("---------------------------------");
        for (Item i : items) 
            System.out.printf("%s: %.2f€ --> %d (%.2f€)\n", i.getProd().getNombre(), i.getProd().getPrecio(), i.getCantidad(), i.getCantidad() * i.getProd().getPrecio());
        System.out.println("---------------------------------");
    }
}
