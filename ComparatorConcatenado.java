package Comparator;

import java.util.Comparator;

import TP.Pelicula;

public class ComparatorConcatenado implements Comparator<Pelicula>{
	
	private Comparator<Pelicula> p1;
	private Comparator<Pelicula> p2;

	public ComparatorConcatenado(Comparator<Pelicula> p1,
			Comparator<Pelicula> p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		int resultado = this.p1.compare(p1, p2);
		if(resultado == 0){
			resultado = this.p2.compare(p1, p2);
		}
		
		return resultado;
	}

}
