package Criterios;

import TP.Pelicula;

public class CriterioPorActor extends Criterio {

	 private String actor;
	
	
	public CriterioPorActor(String actor) {
		this.actor = actor;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.getActores().contains(actor);
	}

}
