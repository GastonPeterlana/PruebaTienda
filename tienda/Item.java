package PruebaTienda;

import java.util.Objects;
public class Item {
    private Producto prod;
    private int cantidad;

    public Item(Producto prod, int cantidad) {
        this.prod = prod;
        this.cantidad = cantidad;
    }

    public void addCant(int n) {
        this.cantidad += n;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.prod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.prod, other.prod)) {
            return false;
        }
        return true;
    }

    public Producto getProd() {
        return prod;
    }

    public int getCantidad() {
        return cantidad;
    }
}
