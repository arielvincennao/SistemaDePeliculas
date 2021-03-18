package Comparator;

import java.util.Comparator;

import TP.Pelicula;

public class ComparatorPorPopularidad implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula p1, Pelicula p2) {
		return p2.getVisualizaciones() - p1.getVisualizaciones();
	}

}
