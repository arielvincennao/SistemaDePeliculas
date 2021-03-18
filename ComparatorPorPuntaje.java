package Comparator;

import java.util.Comparator;

import TP.Pelicula;

public class ComparatorPorPuntaje implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula p1, Pelicula p2) {

		    if(p1.getPuntuacionPromedio() > p2.getPuntuacionPromedio())
		          return -1;
		    else if(p1.getPuntuacionPromedio() < p2.getPuntuacionPromedio())
		          return 1;
		    return 0;

	}
}