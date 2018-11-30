package valenciaPerdomoCastanedaMarmolejo;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PImage;
import processing.core.PVector;

public class Logica extends Thread {

	private Main app;
	private int tiempo, tRastro, pantalla, progreso1, progreso2, elementosEntrega1p1, elementosEntrega2p1, elementosEntrega1p2,
			elementosEntrega2p2;
	private LinkedList<Recolectable> recolectables;
	private LinkedList<RecogibleMalo> recogiblesMalos;
	private Jugador jugador1;
	private Jugador jugador2;
	private Enemigo[] enemigos = new Enemigo[5];
	private PImage[] niveles;
	private boolean vivo, contador;

	public Logica(Main app) {
		this.app = app;
		this.tiempo = 0;
		this.tRastro = 0;
		this.pantalla = 4;
		this.vivo = true;
		this.contador = true;
		this.recolectables = new LinkedList<Recolectable>();
		this.recogiblesMalos = new LinkedList<RecogibleMalo>();
		this.jugador1 = new Jugador(app, this, 2);
		jugador1.setNivel(5);
		jugador1.setPos(new PVector(300, 100));
		jugador1.start();
		this.jugador2 = new Jugador(app, this, 1);
		jugador2.setNivel(3);
		jugador2.start();
		crearEnemigos();
	}

	public void run() {
		while (vivo) {
			switch (pantalla) {
			case 0:

				break;
			case 1:

				break;
			case 2:
				if (contador) {
					tiempo = app.millis() - 5000;
					contador = false;
				}
				crearRecolecables();
				jugador1.validarChoqueJugadores(jugador2);
				jugador2.validarChoqueJugadores(jugador1);
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].validarChoque(jugador1);
					enemigos[i].validarChoque(jugador2);
				}
				if (tRastro + 6000 < app.millis()) {
					for (int i = 0; i < enemigos.length; i++) {
						enemigos[i].crearRastro(0);
					}
					tRastro = app.millis();
				}
				
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].mover();
				}
				break;
			case 3:

				break;
			case 4:
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].mover();
				}
				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			}
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar() {
		switch (pantalla) {
		case 0:

			break;
		case 1:

			break;
		case 2:
			jugador1.pintar();
			jugador2.pintar();
			for (int i = 0; i < recolectables.size(); i++) {
				recolectables.get(i).pintar();
			}
			for (int i = 0; i < enemigos.length; i++) {
				enemigos[i].pintar();
			}
			for (int i = 0; i < recogiblesMalos.size(); i++) {
				recogiblesMalos.get(i).pintar();
			}
			break;
		case 3:

			break;
		case 4:
			jugador1.pintar();
			jugador2.pintar();
			for (int i = 0; i < enemigos.length; i++) {
				enemigos[i].pintar();
			}
			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		}
	}

	public void mousePressed() {

	}

	public void keyPressed() {
		switch (pantalla) {
		case 0:

			break;
		case 1:

			break;
		case 2:
			jugador1.mover();
			jugador2.mover();
			break;
		case 3:

			break;
		case 4:
			jugador1.mover();
			jugador2.mover();
			break;
		case 5:

			break;
		case 6:
			jugador1.mover();
			jugador2.mover();
			break;
		case 7:

			break;
		}
	}

	public void keyReleassed() {
		switch (pantalla) {
		case 0:

			break;
		case 1:

			break;
		case 2:
			jugador1.soltar();
			jugador2.soltar();
			break;
		case 3:

			break;
		case 4:
			jugador1.soltar();
			jugador2.soltar();
			break;
		case 5:

			break;
		case 6:
			jugador1.soltar();
			jugador2.soltar();
			break;
		case 7:

			break;
		}
	}

	public void crearRecolecables() {
		switch (pantalla) {
		case 2:
			if (tiempo + 5000 < app.millis()) {
				for (int i = 0; i < 10; i++) {
					Recolectable elRecolectable = new Recolectable(app, (int) app.random(0, 4));
					recolectables.add(elRecolectable);
				}
				tiempo = app.millis();
			}
			break;
		}
	}

	public void crearEnemigos() {
		for (int i = 0; i < enemigos.length; i++) {
			Enemigo e = new Enemigo(app, this, 1);
			System.out.println("hola");
			e.start();
			enemigos[i] = e;
		}
	}

	// Gets & sets-------------------------------------

	public int getPantalla() {
		return pantalla;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public LinkedList<Recolectable> getRecolectables() {
		return recolectables;
	}

	public void accionesNivel3() {

	}

	public int getTiempo() {
		return tiempo;
	}

	public void setRecogiblesMalos(RecogibleMalo r) {
		this.recogiblesMalos.add(r);
	}

	public LinkedList<RecogibleMalo> getRecogiblesMalos() {
		return recogiblesMalos;
	}
	
	
	
	

}
