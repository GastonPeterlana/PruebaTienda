package PruebaTienda;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Tienda {
    private static Catalogo cat = new Catalogo();
    private static Scanner tec = new Scanner(System.in);
    
    public static void main(String[] args) {
        double ventasDiarias = 0;
        int op;
        inicializar(cat);
        do {
            op = menu("1. Añadir a catálogo\n2. Borrar del catálogo\n3. Consultar Catálogo\n4. Vender\n5. SALIR DEL PROGRAMA", 5);
            switch (op) {
                case 1:
                    cat.add(leerProducto());
                    break;
                case 2:
                    System.out.println("Nombre:");
                    cat.borrar(new Producto(tec.nextLine()));
                    break;
                case 3:
                    int orden = menu("1. Nombre\n2. Precio", 2);
                    cat.ordenar(orden);
                    System.out.println(cat.get());
                    break;
                case 4:
                    ventasDiarias += venta();
                    break;
                case 5:
                    System.out.println("Se saldrá del programa");
            }
            if (op != 5)
                System.out.println();
        } while (op != 5);

    }

    static int menu(String mensaje, int numOpciones) {
        int opcion;
        do {
            System.out.println(mensaje);
            try {
                opcion = Integer.parseInt(tec.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
        } while (opcion < 1 || opcion > numOpciones);
        return opcion;
    }

    static void inicializar(Catalogo cat) {
        Producto elem;
        try {
            Scanner file = new Scanner(Paths.get("Catalogo.txt"));
            while (tec.hasNext()) {
                String nombre = tec.nextLine();
                if (tec.hasNext()) {
                    double precio = Double.parseDouble(tec.nextLine());
                    cat.add(new Producto(nombre, precio));
                }
            }
        } catch (IOException e) {
            System.out.println("No existe el fichero");
        }

    }

    private static Producto leerProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = tec.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(tec.nextLine());
        return new Producto(nombre, precio);
    }
    
    private static double venta(){
        Carrito car = new Carrito();
        double total = 0;
        int op;
        do {
            op = menu("1. Seleccionar producto\n2. Cancelar venta\n3. Finalizar venta", 3);
            switch(op){
                case 1:
                    System.out.print("¿Qué producto quieres comprar? ");
                    String nom = tec.nextLine().toLowerCase();
                    int index = cat.get().indexOf(new Producto(nom));
                    if (index == -1)
                        System.out.printf("No hay %s en el catálogo\n", nom);
                    else {
                        System.out.printf("%s: %.2f€\n¿Cúantos quieres comprar?\n", nom, cat.get().get(index).getPrecio());
                        int cant = Integer.parseInt(tec.nextLine());
                        double gastado = cant * cat.get().get(index).getPrecio();
                        total += gastado;
                        System.out.printf("%d comprados por %.2f€\n", cant, gastado);
                        car.add(new Item(cat.get().get(index), cant));
                    }
                    break;
                case 2:
                    System.out.println("Venta cancelada");
                    total = 0;
                    break;
                case 3:
                    System.out.println("Venta completada");
                    car.mostrar();
                    break;
            }
            if (op == 1)
                System.out.println();
        } while (op == 1);

        return total;
    }
}
