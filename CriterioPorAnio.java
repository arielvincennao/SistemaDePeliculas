package Criterios;

import TP.Pelicula;

public class CriterioPorAnio extends Criterio {
	
	private int anio;
	
	public CriterioPorAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.getAnioEstreno() == anio;
	}

}
