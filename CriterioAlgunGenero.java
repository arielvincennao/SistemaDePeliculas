package Criterios;

import java.util.ArrayList;

import TP.Pelicula;
import TP.SistemaPeliculas;

public class CriterioAlgunGenero extends Criterio{
	
	private ArrayList<String> generos;
	
	public CriterioAlgunGenero(SistemaPeliculas s) {
		this.generos = s.generosPref();
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.contieneGenero(generos);
	}

}
