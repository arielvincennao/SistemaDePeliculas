package TP;

import java.util.Comparator;

import Comparator.ComparatorConcatenado;
import Comparator.ComparatorPorPopularidad;
import Comparator.ComparadorReversa;
import Comparator.ComparatorPorPuntaje;
import Comparator.CriterioPorDirector;
import Criterios.Criterio;
import Criterios.CriterioAlgunGenero;
import Criterios.CriterioAnd;
import Criterios.CriterioAnioMenor;
import Criterios.CriterioMultipleGeneros;
import Criterios.CriterioNot;
import Criterios.CriterioOr;
import Criterios.CriterioPorActor;
import Criterios.CriterioAnioMayor;
import Criterios.CriterioPorAnio;
import Criterios.CriterioPorGenero;
import Criterios.CriterioPorTitulo;


public class Main {

	public static void main(String[] args) {
		
		//CATALOGO
		Catalogo catalogo = new Catalogo();
		
		//PELICULAS
		Pelicula p1 = new Pelicula("Up: una aventura de altura", "Description", 2009);
		p1.addDirector("Pete Docter"); p1.addDirector("Bob Peterson");
		p1.addActor("Pete Docter"); p1.addActor("Ed Asner"); p1.addActor("Bob Peterson"); p1.addActor("Jordan Nagai");
		p1.addGenero("Infantil"); p1.addGenero("Accion"); p1.addGenero("Drama");

		Pelicula p2 = new Pelicula("Los Simpson: la pelicula", "Description", 2007);
		p2.addDirector("David Silverman");
		p2.addActor("Dan Castellaneta"); p2.addActor("Harry Shearer"); p2.addActor("Julie Kavner");
		p2.addGenero("Romantico"); p2.addGenero("Musical"); p2.addGenero("Infantil"); p2.addGenero("Aventura"); p2.addGenero("Comedia");
		
		Pelicula p3 = new Pelicula("Los increibles", "Description", 2004);
		p3.addDirector("Brand Bird");
		p3.addActor("Brand Bird"); p3.addActor("Craig T Nelson"); p3.addActor("Holly Hunter");
		p3.addGenero("Musical"); p3.addGenero("Infantil"); p3.addGenero("Aventura"); p3.addGenero("Accion");
		
		Pelicula p4 = new Pelicula("Los increibles 2", "Description", 2018);
		p4.addDirector("Brand Bird");
		p4.addActor("Brand Bird"); p4.addActor("Craig T Nelson"); p4.addActor("Holly Hunter");
		p4.addGenero("Musical"); p4.addGenero("Infantil"); p4.addGenero("Aventura"); p4.addGenero("Accion");
		
		Pelicula p5 = new Pelicula("Toy Story", "Description", 1995);
		p5.addDirector("John Lasseter");
		p5.addActor("Tim Allen"); p5.addActor("Tom Hanks"); p5.addActor("Don Rickles"); p5.addActor("Wallace Shawn");
		p5.addGenero("Infantil"); p5.addGenero("Aventura"); p5.addGenero("Accion"); 
		
		Pelicula p6 = new Pelicula("Monster Inc", "Description", 2001);
		p6.addDirector("Pete Docter");
		p6.addActor("John Goodman"); p6.addActor("Billy Crystal"); p6.addActor("John Ratzenberger");
		p6.addGenero("Musical"); p6.addGenero("Infantil"); p6.addGenero("Aventura"); p6.addGenero("Accion");
		
		
		//AGREGO PELICULA AL CATALOGO
		catalogo.addPelicula(p1);
		catalogo.addPelicula(p2);
		catalogo.addPelicula(p3);
		catalogo.addPelicula(p4);
		catalogo.addPelicula(p5);
		catalogo.addPelicula(p6);
		
		//USUARIOS
		Usuario u1 = new Usuario("Lisa");
		u1.addGeneroPref("Romantico");
		u1.addGeneroPref("Musical");
		u1.addGeneroPref("Infantil");
		u1.addGeneroPref("Aventura");
		
		Usuario u2 = new Usuario("Bart");
		u2.addGeneroPref("Musical");
		u2.addGeneroPref("Infantil");
		u2.addGeneroPref("Aventura");
		u2.addGeneroPref("Accion");
		
		Usuario u3 = new Usuario("Maggie");
		u3.addGeneroPref("Musical");
		u3.addGeneroPref("Infantil");
		u3.addGeneroPref("Aventura");
		
		Usuario u4 = new Usuario("Marge");
		u4.addGeneroPref("Romantico");
		u4.addGeneroPref("Musical");
		u4.addGeneroPref("Infantil");
		u4.addGeneroPref("Aventura");
		
		Usuario u5 = new Usuario("Homero");
		u5.addGeneroPref("Musical");
		u5.addGeneroPref("Infantil");
		u5.addGeneroPref("Accion");
		
		//GRUPOS
		Grupo g1 = new Grupo("Hombres Simpson"); 
		g1.addElem(u5);	//Homero
		g1.addElem(u2);	//Bart
		
		Grupo g2 = new Grupo("Hermanos Simpson");
		g2.addElem(u1); //Lisa
		g2.addElem(u2); //Bart
		g2.addElem(u3);	//Maggie
		
		Grupo g3 = new Grupo("Familia Simpson");
		g3.addElem(g2);	//Hermanos
		g3.addElem(u5);	//Homero
		g3.addElem(u4);	//Marge
		
		System.out.println("----");
		
		//PELICULAS VISTAS 
		
		//Los Increibles
		u1.verPelicula(p3);
		u1.puntuarPelicula(p3, 5);	//Lisa: 5
		
		u2.verPelicula(p3);
		u2.puntuarPelicula(p3, 2);	//Bart: 2
		
		u5.verPelicula(p3);
		u5.puntuarPelicula(p3, 4);	//Homero: 4
		
		u4.verPelicula(p3);
		u4.puntuarPelicula(p3, 2);	//Marge: 2
		
		//Los Increibles 2
		u4.verPelicula(p4);
		u4.puntuarPelicula(p4, 5); //Marge: 5
		
		//Toy Story
		u3.verPelicula(p5);
		u3.puntuarPelicula(p5, 1); //Maggie: 1
		
		System.out.println("----");
		
		//EJERCICIOS
			//1. Listar las películas vistas por Marge
		u4.mostrarPeliculasVistas();
		
		System.out.println("----");
		
			//2. Listar las películas vistas por Bart
		u2.mostrarPeliculasVistas();
		
		System.out.println("----");
		System.out.println("Recomendaciones");
			
			//3. Generar 2 recomendaciones para cada uno de los usuarios individuales y grupos creados,
			//considerando que las películas incluyan TODOS los géneros preferidos por el usuario,
			//ordenados por popularidad
		Comparator<Pelicula> ComparatorPorPopularidad = new ComparatorPorPopularidad();
		
		Criterio c1 = new CriterioMultipleGeneros(u1);
 		System.out.println(u1.getNombre() + u1.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c1, 2));
 		
 		Criterio c2 = new CriterioMultipleGeneros(u2);
 		System.out.println(u2.getNombre() + u2.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c2, 2));
 		
 		Criterio c3 = new CriterioMultipleGeneros(u3);
 		System.out.println(u3.getNombre() + u3.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c3, 2));
 		
 		Criterio c4 = new CriterioMultipleGeneros(u4);
 		System.out.println(u4.getNombre() + u4.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c4, 2));
 		
 		Criterio c5 = new CriterioMultipleGeneros(u5);
 		System.out.println(u5.getNombre() + u5.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c5, 2));
 		
 		Criterio c6 = new CriterioMultipleGeneros(g1);
 		System.out.println(g1.getNombre() + g1.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c6, 2));
 		
 		Criterio c7 = new CriterioMultipleGeneros(g2);
 		System.out.println(g2.getNombre() + g2.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c7, 2));
 		
 		Criterio c8 = new CriterioMultipleGeneros(g3);
 		System.out.println(g3.getNombre() + g3.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c8, 2));
 		
 		System.out.println("----");
 		
	 		//4. Generar 5 recomendaciones para cada uno de los usuarios individuales y grupos creados,
	 		//considerando que las películas incluyan ALGUNO de los géneros preferidos por el usuario,
	 		//ordenados por puntaje promedio
 		Comparator<Pelicula> ComparatorPorPuntaje = new ComparatorPorPuntaje();
	 		
 		Criterio c9 = new CriterioAlgunGenero(u1);
 		System.out.println(u1.getNombre() + u1.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c9, 5));
 		
 		Criterio c10 = new CriterioAlgunGenero(u2);
 		System.out.println(u2.getNombre() + u2.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c10, 5));
 		
 		Criterio c11 = new CriterioAlgunGenero(u3);
 		System.out.println(u3.getNombre() + u3.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c11, 5));
 		
 		Criterio c12 = new CriterioAlgunGenero(u4);
 		System.out.println(u4.getNombre() + u4.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c12, 5));
 		
 		Criterio c13 = new CriterioAlgunGenero(u5);
 		System.out.println(u5.getNombre() + u5.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c13, 5));
 		
 		Criterio c14 = new CriterioAlgunGenero(g1);
 		System.out.println(g1.getNombre() + g1.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c14, 5));
 		
 		Criterio c15 = new CriterioAlgunGenero(g2);
 		System.out.println(g2.getNombre() + g2.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c15, 5));
 		
 		Criterio c16 = new CriterioAlgunGenero(g3);
 		System.out.println(g3.getNombre() + g3.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c16, 5));
 		
 		System.out.println("----");
 		
	 		//5. Incorporar al sistema la información relativa a que los hermanos Simpson vieron la película
	 		//Up y la valoraron grupalmente con 4 granos de café.
 		
 				g2.verPelicula(p1);
 				g2.puntuarPelicula(p1, 4);
 				
 		System.out.println("----");		
 				
 			//6. Realizar nuevamente los listados correspondientes a los puntos 2, 3 y 4 anteriores	
 				
 				u2.mostrarPeliculasVistas();
 				
 				System.out.println("----");
 				System.out.println("Recomendaciones");

 				

 		 		System.out.println(u1.getNombre() + u1.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c1, 2));
 		 		System.out.println(u2.getNombre() + u2.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c2, 2));
 		 		System.out.println(u3.getNombre() + u3.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c3, 2));
 		 		System.out.println(u4.getNombre() + u4.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c4, 2));
 		 		System.out.println(u5.getNombre() + u5.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c5, 2));
 		 		System.out.println(g1.getNombre() + g1.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c6, 2));
 		 		System.out.println(g2.getNombre() + g2.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c7, 2));
 		 		System.out.println(g3.getNombre() + g3.generarRecomendaciones(catalogo, ComparatorPorPopularidad, c8, 2));
 				
 
 		 		System.out.println(u1.getNombre() + u1.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c9, 5));
 		 		System.out.println(u2.getNombre() + u2.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c10, 5));
 		 		System.out.println(u3.getNombre() + u3.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c11, 5));
 		 		System.out.println(u4.getNombre() + u4.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c12, 5));
 		 		System.out.println(u5.getNombre() + u5.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c13, 5));
 		 		System.out.println(g1.getNombre() + g1.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c14, 5));
 		 		System.out.println(g2.getNombre() + g2.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c15, 5));
 		 		System.out.println(g3.getNombre() + g3.generarRecomendaciones(catalogo, ComparatorPorPuntaje, c16, 5));
 		
 		
	 		//7. Realizar las siguientes búsquedas:
	 		//a. Todas las películas en las que Pete Docter haya actuado y sido director al
	 		//mismo tiempo
		 		System.out.println("----");
		 		
		 		Criterio c20 = new CriterioPorActor("Pete Docter");
		 		Criterio c21 = new CriterioPorDirector("Pete Docter");
		 		Criterio c22 = new CriterioAnd(c20, c21);
		 		System.out.println(catalogo.buscarPelicula(c22));
		 		
		 		System.out.println("----");
 		
 			//b. Todas las películas en las que haya actuado Tom Hanks
 		
		 		Criterio c23 = new CriterioPorActor("Tom Hanks");
		 		System.out.println(catalogo.buscarPelicula(c23));
		 		
		 		System.out.println("----");
 		
 			//c. Todas las películas estrenadas a partir del año 2000
 		
		 		Criterio c24 = new CriterioAnioMayor(2000);
		 		System.out.println(catalogo.buscarPelicula(c24));
		 		
		 		System.out.println("----");
 		
 			//d. Todas las películas con género romántico, comedia, o drama
 		
		 		Criterio c25 = new CriterioPorGenero("Romantico");
		 		Criterio c26 = new CriterioPorGenero("Comedia");
		 		Criterio c27 = new CriterioPorGenero("Drama");
		 		Criterio c28 = new CriterioOr(c25, c26);
		 		Criterio c29 = new CriterioOr(c28, c27);
		 		System.out.println(catalogo.buscarPelicula(c29));
 		

	}

}
