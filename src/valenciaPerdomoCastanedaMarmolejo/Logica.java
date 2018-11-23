package valenciaPerdomoCastanedaMarmolejo;

import java.util.ArrayList;

import processing.core.PImage;

public class Logica extends Thread {

	private Main app;
	private int tiempo, pantalla, progreso1, progreso2, elementosEntrega1p1,
	elementosEntrega2p1,elementosEntrega1p2,elementosEntrega2p2;
	protected ArrayList<Recolectable> recolectables;
	private Jugador jugador1;
	private Jugador jugador2;
	private Enemigo[]  enemigos;
	private PImage[] niveles; 
	

	public Logica(Main app) {
		this.app = app;
		this.pantalla = 0;
	}

	public void run() {
		try {
			sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pintar() {

	}

	public void mousePressed() {

	}

	public void keyPressed() {

	}

	public void crearRecolecables() {

	}

	public int getPantalla(){
		return pantalla;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public ArrayList<Recolectable> getRecolectables() {
		return recolectables;
	}
	
	public void accionesNivel3(){
		
	}

}
