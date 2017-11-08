package parking;

import java.util.Date;
import java.util.Scanner;

public class Parking {

	private static BaseDeDatos baseDeDatos = new BaseDeDatos();
	
	public static void main(String[] args) {
		int opcion;
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.println("***************************\n*** Mi aparcamiento ***\n***************************");
			System.out.println("");
			System.out.println("Pulse 1 si entra un coche");
			System.out.println("Pulse 2 si sale un coche");
			System.out.println("Pulse 3 para salir y apagar");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1: {
				entraCoche();
				break;
			}
			case 2: {
				saleCoche();
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

	private static void saleCoche() {
		Long minutos = 0L;
		System.out.println("Mete la matrícula:");
		Scanner teclado = new Scanner(System.in);
		String matricula = teclado.next();
		Coche coche=baseDeDatos.dameCoche(matricula);
		if(coche!=null){
			Date fechaActual = new Date();
			Date fechaQueEntro = coche.getFechaEntrada();
			
			Long diferenciaEn_ms = fechaActual.getTime() - fechaQueEntro.getTime();
			minutos = diferenciaEn_ms / (1000 * 60);
		}
		System.out.println("Tienes que cobrarle "+minutos+" minutos");
	}

	private static void entraCoche() {
		System.out.println("Mete la matrícula:");
		Scanner teclado = new Scanner(System.in);
		String matricula = teclado.next();
		Coche coche = new Coche();
		coche.setMatricula(matricula);
		coche.setFechaEntrada(new Date());
		baseDeDatos.anadeCoche(coche);
	}

}
