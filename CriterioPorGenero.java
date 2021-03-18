package Criterios;

import TP.Pelicula;

public class CriterioPorGenero extends Criterio{

	private String genero;
	
	public CriterioPorGenero(String genero) {
		this.genero = genero;
	}
	

	@Override
	public boolean cumple(Pelicula p) {
		return p.getGeneros().contains(this.genero);
	}

}
