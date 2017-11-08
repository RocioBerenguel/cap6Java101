package tienda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Tienda {
    
	private static List<Producto> productos;
	
	public static void menuEntrada () {
        int opcion;
 
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("***************************\n*** Mi tienda ***\n***************************");
            System.out.println("");
            System.out.println("Pulse 1 para ver el stock actual");
            System.out.println("Pulse 2 para saber el valor de tu negocio");
            System.out.println("Pulse 3 para salir");
            opcion = teclado.nextInt();
 
            switch (opcion) {
                case 1: {
                    verStock();
                    break;
                }
                case 2: {
                    valorStock();
                    break;
                }
                case 3: {
                    System.out.println("Gracias!!! por usar el programa");
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }
 
        } while (opcion != 3);
 
 
    }
 
    private static void valorStock() {
    	Double precioTotal = 0.0;
    	Iterator<Producto> it = productos.iterator();
    	while (it.hasNext()) {
    		Producto producto = it.next();
    		precioTotal+=producto.getCantidad()*producto.getPrecio();
    	}
    	System.out.println("\n\n****   Precio total del stock: " + precioTotal+"     ****\n\n");
	}

	private static void verStock() {
		for(Producto producto:productos){
			System.out.println("\t*"+producto.getNombre()+": "+producto.getCantidad());
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		
		
		
        productos = new ArrayList<Producto>();
 
        inicializaProductos();        
        menuEntrada();
    }

	private static void inicializaProductos() {
		Producto leche = new Producto();
		leche.setCantidad(100);
		leche.setNombre("Leche");
		leche.setPrecio(0.9);
		productos.add(leche);
		
		Producto pan = new Producto();
		pan.setCantidad(150);
		pan.setNombre("Pan");
		pan.setPrecio(1.5);
		productos.add(pan);
		
		
		Producto pollo = new Producto();
		pollo.setCantidad(50);
		pollo.setNombre("Pollo");
		pollo.setPrecio(2.5);
		productos.add(pollo);
		
		
		Producto galleta = new Producto();
		galleta.setCantidad(300);
		galleta.setNombre("Galleta");
		galleta.setPrecio((double) 3);
		productos.add(galleta);
		
		
		Producto mantequilla = new Producto();
		mantequilla.setCantidad(100);
		mantequilla.setNombre("Mantequilla");
		mantequilla.setPrecio((double) 1);
		productos.add(mantequilla);
	}

}
