package TP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Criterios.Criterio;

public class Usuario extends SistemaPeliculas{
	
	private String nombre;
	private int edad;
	private ArrayList<String> generosPref;
	private ArrayList<Pelicula> peliculasVistas;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
		generosPref = new ArrayList<String>();
		peliculasVistas = new ArrayList<Pelicula>();
		this.setPuntuo(false);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public ArrayList<String> getGenerosPref() {
		ArrayList<String> copy = (ArrayList<String>) generosPref;
		return copy;
	}
	
	private ArrayList<Pelicula> getPeliculasVistas() {			
		ArrayList<Pelicula> copy = (ArrayList<Pelicula>) peliculasVistas;
		return copy;
	}
	
	public void addGeneroPref(String g){
		if(!this.getGenerosPref().contains(g)){ //Evitando generos repetidos
			generosPref.add(g);
		}
	}
	
	public void addPeliculaVista(Pelicula p){
		peliculasVistas.add(p);					
	}
	
	public int cantPeliculasVistas(){
		return this.peliculasVistas.size();		
	}
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", edad=" + edad
				+ ", generosPref=" + generosPref + ", peliculasVistas="
				+ peliculasVistas + "]";
	}

	@Override
	public void verPelicula(Pelicula p) {		//El usuario ve la pelicula
		this.setPuntuo(false);
		p.setVisualizaciones();
		this.addPeliculaVista(p);				
		System.out.println("El usuario " + this.getNombre() + " vio la pelicula " + p.getTitulo());
		}	

	@Override
	public ArrayList<String> generosPref() {		//Devuelve la lista de generos
		return this.getGenerosPref();
	}

	@Override
	public ArrayList<Pelicula> generarRecomendaciones(Catalogo c, Comparator<Pelicula> comp, Criterio criterio, int nRecomendaciones) {
		ArrayList<Pelicula> copy = c.peliculasDisponibles();	//Peliculas en todo el catalogo
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		ArrayList<Pelicula> listaRecomendaciones = new ArrayList<Pelicula>();
		
		for(int i=0; i<copy.size(); i++){
				if(!this.vioPelicula(copy.get(i)) && criterio.cumple(copy.get(i))){
					lista.add(copy.get(i));
				}
			}
		
		listaRecomendaciones.addAll((lista.subList(0, nRecomendaciones >= lista.size() ? lista.size() : nRecomendaciones)));
		
		Collections.sort(listaRecomendaciones, comp); //Me ordena la lista dependiendo del comparator
		return listaRecomendaciones;
	}

	@Override
	public boolean vioPelicula(Pelicula p) {
		if(this.getPeliculasVistas().contains(p)) return true;
		else return false;	
		}

	@Override
	public void mostrarPeliculasVistas() {
		System.out.println("Peliculas vistas por " + this.getNombre());
		for(int j=0; j<this.cantPeliculasVistas(); j++){
			System.out.println("- " + this.getPeliculasVistas().get(j).getTitulo());
		}
	}
}

	

