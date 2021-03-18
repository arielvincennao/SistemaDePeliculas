package TP;

import java.util.ArrayList;
import java.util.Collections;

import Comparator.ComparatorPorPuntaje;
import Criterios.Criterio;

public class Catalogo {
	
	private ArrayList<Pelicula> peliculas;
	
	public Catalogo(){
		peliculas = new ArrayList<Pelicula>();
	}
	
	public ArrayList<Pelicula> peliculasDisponibles(){
		ArrayList<Pelicula> copy = new ArrayList<Pelicula>(peliculas);
		Collections.sort(copy, new ComparatorPorPuntaje());
		return copy;
	}
	
	public int cantPeliculasDisponibles(){
		return this.peliculasDisponibles().size();
	}
	
	public void addPelicula(Pelicula p){
		peliculas.add(p);
	}
	
	
	public ArrayList<Pelicula> buscarPelicula(Criterio criterio){
		ArrayList<Pelicula> resultado = new ArrayList<Pelicula>();
		for(int i=0; i<this.peliculasDisponibles().size(); i++){
			if(criterio.cumple(this.peliculasDisponibles().get(i))){
				resultado.add(this.peliculasDisponibles().get(i));
			}
		}
		return resultado;
	}
	
}
