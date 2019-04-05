/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mercado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class TiendaaCompletar {
    static Catalogo cat = new Catalogo();
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double ventasDiarias = 0;
        int op, orden;
        Producto p;
        inicializar(cat);
        do {

            op = menu("1.Añadir a catálogo\n2.Borrar del catálogo\n3.Consultar Catálogo\n4.Vender\n5.SALIR DEL PROGRAMA", 5);

            switch (op) {
                case 1:
                    p = leerProducto();
                    cat.add(p);
                    break;
                case 2:
                    System.out.println("Nombre:");
                    p = new Producto(teclado.nextLine(), 0);
                    cat.borrar(p);
                    break;
                case 3:
                    orden = menu("1.Nombre\n2.Precio", 2);
                    cat.ordenar(orden);
                    System.out.println(cat);
                    break;
                case 4:
                    ventasDiarias += venta();
                    /*Consiste en ir añadiendo productos al carrito hasta que
            el usuaio decida finalizar la venta, entonces se muesra 
                    el conteido del carrito y el precio total*/
                    break;
                case 5:
            }
        } while (op != 5);

    }

    static int menu(String mensaje, int numOpciones) {
        int opcion;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println(mensaje);
            try {
                opcion = teclado.nextInt();
            } catch (Exception e) {
                //vacio el buffer
                teclado.next();
                opcion = 0;
            }
        } while (opcion < 1 || opcion > numOpciones);
        return opcion;
    }

    static void inicializar(Catalogo cat) {
        File entrada = new File("Catalogo.txt");
        Scanner tec;
        String nombre;
        int cantidad;
        float precio;
        Producto elem;
        try {
            tec = new Scanner(entrada);
            while (tec.hasNext()) {
                nombre = tec.nextLine();
                if (tec.hasNext()) {
                    precio = tec.nextFloat();
                    if (tec.hasNext()) {
                        cantidad = tec.nextInt();
                        tec.nextLine();
                        elem = new Producto(nombre, cantidad, precio);
                        cat.add(elem);

                    }
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero");
        }

    }

    private static Producto leerProducto() {
        Scanner tec = new Scanner(System.in);
        String nombre;
        int cantidad;
        float precio;
        Producto elem;

        nombre = tec.nextLine();

        precio = tec.nextFloat();

        cantidad = tec.nextInt();
        tec.nextLine();
        elem = new Producto(nombre, cantidad, precio);
        return elem;
    }

    static double venta() {
        int op;
        Scanner tec = new Scanner(System.in);
        Carrito carr = new Carrito();
        Producto p;

        int cant;
        String nom;
        double totalVenta = 0;
        cat.ordenar(1);
        do {
            op = menu("1.Seleccionar producto \n2.Cancelar venta\n3.Finalizar venta", 3);
            switch (op) {
                case 1:
                    System.out.println(cat);
                    System.out.println("Nombre: ");
                    nom = tec.nextLine();
                    System.out.println("Cantidad");
                    cant = tec.nextInt();
                    tec.nextLine();
                    p = new Producto(nom, 0);
                    if ((p = cat.existe(p)) != null) {

                        carr.anyadir(new Item(p, cant));
                    }
                    System.out.println(carr);
                    break;
                case 2:
                    carr.vaciar();
                    break;
                case 3:
                    System.out.println(carr);
                    totalVenta = carr.total();
                    carr.vaciar();
            }
        } while (op == 1);
        return totalVenta;
    }
}
