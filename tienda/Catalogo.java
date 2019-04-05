package PruebaTienda;

import java.util.ArrayList;
import java.util.Collections;

public class Catalogo {
    private ArrayList<Producto> prods;

    public Catalogo() {
        this.prods = new ArrayList<>();
    }

    public ArrayList<Producto> get() {
        return prods;
    }

    public void add (Producto p){
        prods.add(p);
    }

    public void borrar (Producto p){
        prods.remove(p);
    }

    public void ordenar(int op){
        if (op == 1)
            Collections.sort(prods);
        if (op == 2)
            Collections.sort(prods, new CompPorPrecio());
    }
}
