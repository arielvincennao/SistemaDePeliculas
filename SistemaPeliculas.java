package TP;

import java.util.ArrayList;
import java.util.Comparator;

import Criterios.Criterio;

public abstract class SistemaPeliculas{
	
	private boolean puntuo;
	
	public boolean isPuntuo(){
		return puntuo;
	}
	public void setPuntuo(boolean b){
		this.puntuo = b;
	}
	
	public abstract void verPelicula(Pelicula p); 
	
	public void puntuarPelicula(Pelicula p, int puntaje){
		if(this.vioPelicula(p) && p.isPuntuacionValida(puntaje) && this.isPuntuo()==false){
			p.addPuntuacion(puntaje);
			this.setPuntuo(true);
			System.out.println("Se puntuo la pelicula con " + puntaje + " granos de cafe");
		}
		else System.out.println("No puede puntuar");
	}
	
	public abstract ArrayList<String> generosPref();
	
	public abstract boolean vioPelicula(Pelicula p);
	
	public abstract ArrayList<Pelicula> generarRecomendaciones(Catalogo c, Comparator<Pelicula> comp, Criterio criterio, int nRecomendaciones);
	
	public abstract void mostrarPeliculasVistas();

	
	//Los g�neros preferidos de un grupo se
	//calculan c�mo la uni�n de todos los g�neros de sus integrantes (sin repetidos).
	
	

}
