package Criterios;

import TP.Pelicula;

public class CriterioAnioMayor extends Criterio{
	
	private int anio;

	
	
	public CriterioAnioMayor(int anio) {
		this.anio = anio;
	}



	@Override
	public boolean cumple(Pelicula p) {
		return p.getAnioEstreno() > anio;
	}

}
