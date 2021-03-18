package Criterios;

import TP.Pelicula;

public class CriterioPorTitulo extends Criterio{
	
	 private String titulo;

	public CriterioPorTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.getTitulo().contains(titulo);
	}

}
