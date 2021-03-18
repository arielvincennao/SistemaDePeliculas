package TP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Criterios.Criterio;

public class Grupo extends SistemaPeliculas{
	
	private String nombre; //Cada grupo posee un nombre que lo identifica y pude dar una valoración
							//grupal a una película, además de sus valoraciones individuales.
	private ArrayList<SistemaPeliculas> elems;
	
	private boolean puntuo;

	public Grupo(String nombre) {
		this.nombre = nombre;
		this.setPuntuo(false);
		elems = new ArrayList<SistemaPeliculas>();
	}
	
	
	public boolean isPuntuo() {
		return puntuo;
	}

	public void setPuntuo(boolean puntuo) {
		this.puntuo = puntuo;
	}



	public ArrayList<SistemaPeliculas> getElems(){
		ArrayList<SistemaPeliculas> copy = new ArrayList<SistemaPeliculas>(elems);
		return copy;
	}
	
	public void addElem(SistemaPeliculas e){
		elems.add(e);
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", elems=" + elems + "]";
	}


	@Override
	public void verPelicula(Pelicula p) {	//Todos los miembros del grupo ven la pelicula
		this.setPuntuo(false);
		for (SistemaPeliculas e : elems) {
        e.verPelicula(p);					
    	}
	}
	
	
	@Override
	public ArrayList<String> generosPref() {
		ArrayList<String> lista = new ArrayList<String>();		
		ArrayList<String> listaSinRepetidos = new ArrayList<String>();
		for (SistemaPeliculas e : elems) {
			lista.addAll(e.generosPref());
            for ( int i=0; i<lista.size(); i++ ){
            	if(!listaSinRepetidos.contains(lista.get(i))){
            		listaSinRepetidos.add(lista.get(i));
            	}
            }
        }
		return listaSinRepetidos;
	}

	@Override
	public ArrayList<Pelicula> generarRecomendaciones(Catalogo c, Comparator<Pelicula> comp, Criterio criterio, int nRecomendaciones) {
		ArrayList<Pelicula> copy = new ArrayList<Pelicula>();
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		ArrayList<Pelicula> listaRecomendaciones = new ArrayList<Pelicula>();
		
		for (SistemaPeliculas e : elems){			
			copy.addAll(e.generarRecomendaciones(c, comp, criterio, nRecomendaciones));
		}
		for(int i=0; i<copy.size(); i++){
			if(!lista.contains(copy.get(i))){		//Evito recomendaciones repetidas
				lista.add(copy.get(i));
			}
		}
		
		listaRecomendaciones.addAll((lista.subList(0, nRecomendaciones >= lista.size() ? lista.size() : nRecomendaciones)));
		
		Collections.sort(listaRecomendaciones, comp);
		
		return listaRecomendaciones;
	}

	@Override
	public boolean vioPelicula(Pelicula p) {	
		boolean check = true;
		for (SistemaPeliculas e : elems){			//Todos los usuarios vieron la pelicula?
			if(!e.vioPelicula(p)) check = false;
		}
		return check;
	}


	@Override
	public void mostrarPeliculasVistas() {
		System.out.println("Peliculas vistas por " + this.getNombre());
		for (SistemaPeliculas e : elems){			
			e.mostrarPeliculasVistas();
		}
	}

}
