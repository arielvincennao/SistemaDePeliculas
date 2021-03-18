package Comparator;

import java.util.Comparator;

import TP.Pelicula;

public class ComparadorReversa implements Comparator<Pelicula>{
	
	private Comparator<Pelicula> comparador;
	
	public ComparadorReversa(Comparator<Pelicula> comparador){
		this.comparador = comparador;
	}

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		return -this.comparador.compare(p1, p2);
	}

}
