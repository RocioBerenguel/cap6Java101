package parking;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
	private List<Coche> listaCoches = new ArrayList<Coche>();

	public void anadeCoche(Coche coche) {
		for (Coche cocheAux : listaCoches) {
			if (coche.getMatricula().equals(cocheAux.getMatricula())) {
				listaCoches.remove(cocheAux);
			}
		}
		listaCoches.add(coche);
	}

	public Coche dameCoche(String matricula) {
		for (Coche coche : listaCoches) {
			if (matricula.equals(coche.getMatricula())) {
				return coche;
			}
		}
		return null;
	}
}
