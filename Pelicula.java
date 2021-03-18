package TP;

import java.util.ArrayList;

public class Pelicula implements Comparable<Pelicula>{

	public static final Integer MINPUNTUACION = 1;
	public static final Integer MAXPUNTUACION = 5;
	private String titulo;
	private String sinopsis;
	private int anioEstreno;
	private ArrayList<String> generos;
	private ArrayList<String> directores;
	private ArrayList<String> actores;
	private ArrayList<Integer> puntuaciones;
	private int visualizaciones;
	private double puntuacionPromedio;
	
	
	public Pelicula(String titulo, String sinopsis, int anioEstreno) {
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.anioEstreno = anioEstreno;
		this.generos = new ArrayList<String>();
		this.directores = new ArrayList<String>();
		this.actores = new ArrayList<String>();
		this.puntuaciones = new ArrayList<Integer>();
		this.visualizaciones = 0;
		this.puntuacionPromedio = this.getPuntuacionPromedio();
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	
	public void addDirector(String d){
		directores.add(d);
	}
	
	public void addActor(String a){
		actores.add(a);
	}
	
	public void addPuntuacion(int p){
		puntuaciones.add(p);
	}
	
	public void addGenero(String g){
		generos.add(g);
	}
	
	public ArrayList<Integer> getPuntuaciones() {
		ArrayList<Integer> copy = (ArrayList<Integer>) puntuaciones;
		return copy;
	}
	
	public ArrayList<String> getActores() {
		ArrayList<String> copy = (ArrayList<String>) actores;
		return copy;
	}
	
	public ArrayList<String> getGeneros() {
		ArrayList<String> copy = (ArrayList<String>) generos;
		return copy;
	}
	
	public ArrayList<String> getDirectores(){
		ArrayList<String> copy = (ArrayList<String>) directores;
		return copy;
	}
	
	public int getVisualizaciones() {
		return visualizaciones;
	}


	public void setVisualizaciones() {
		this.visualizaciones++;
	}


	public int cantidadGeneros(){
		return this.getGeneros().size();
	}

	public int cantidadDeVotos(){
		return puntuaciones.size();
	}
	
	public double promedioPuntuacion(){
		if(this.cantidadDeVotos() > 0){
			double resultado;
			double total = 0;
			for(int i=0; i<this.cantidadDeVotos(); i++){
				total += this.getPuntuaciones().get(i);
			}
			resultado = total / this.cantidadDeVotos();
			return resultado;
		}else{
			return 0;
		}
	}
	
	public boolean isPuntuacionValida(int puntaje){
		return puntaje>=Pelicula.MINPUNTUACION && puntaje<=Pelicula.MAXPUNTUACION;
	}

	public boolean contieneGenero(ArrayList<String> listaGenero){
		boolean contiene = false;
		for(int i=0; i<listaGenero.size(); i++){
			if(this.getGeneros().contains(listaGenero.get(i))){
				contiene = true;
				this.getGeneros().contains(listaGenero);
			}
		}
		return contiene;
	}
	
	public boolean contieneTodosLosGeneros(ArrayList<String> listaGenero){
		return this.getGeneros().containsAll(listaGenero);
	}
	
	

	@Override
	public String toString() {
		return "Pelicula Vistas: "+ this.getVisualizaciones() + "/ Puntuacion prom" + this.getPuntuacionPromedio() +"[titulo=" + titulo + ", sinopsis=" + sinopsis
				+ ", anioEstreno=" + anioEstreno + ", generos=" + generos
				+ ", directores=" + directores + ", actores=" + actores
				+ ", puntuaciones=" + puntuaciones + "]";
	}


	@Override
	public int compareTo(Pelicula p) {
		return this.getTitulo().compareTo(p.getTitulo());	//Defecto se ordenan por titulo
	}


	public double getPuntuacionPromedio() {
		return this.promedioPuntuacion();
	}
	
	

}
