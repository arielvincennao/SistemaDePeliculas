package Comparator;

import TP.Pelicula;
import Criterios.Criterio;

public class CriterioPorDirector extends Criterio {
	
	private String director;

	public CriterioPorDirector(String director) {
		this.director = director;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.getDirectores().contains(director);
	}

}
