package Criterios;

import TP.Pelicula;

public class CriterioNot extends Criterio{
	
	 private Criterio c;
	
	public CriterioNot(Criterio c) {
		this.c = c;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return !c.cumple(p);
	}

}
