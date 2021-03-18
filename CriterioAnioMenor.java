package Criterios;

import TP.Pelicula;

public class CriterioAnioMenor extends Criterio{
	
	private int anio;

	public CriterioAnioMenor(int anio) {
		this.anio = anio;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.getAnioEstreno() < anio;
	}
	
	

}
