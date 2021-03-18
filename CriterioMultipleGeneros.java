package Criterios;

import java.util.ArrayList;

import TP.Pelicula;
import TP.SistemaPeliculas;


public class CriterioMultipleGeneros extends Criterio{
	
	private ArrayList<String> generos;
	
	public CriterioMultipleGeneros(SistemaPeliculas s) {
		this.generos = s.generosPref();
	}

	@Override
	public boolean cumple(Pelicula p) {
		return p.contieneTodosLosGeneros(generos);
	}

}
