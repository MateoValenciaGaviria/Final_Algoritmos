package valenciaPerdomoCastanedaMarmolejo;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PImage;
import processing.core.PVector;

public class Logica extends Thread {

	private Main app;
	private int tiempo, tRastro, pantalla, progreso1, progreso2, elementosEntrega1p1, elementosEntrega2p1,
			elementosEntrega1p2, elementosEntrega2p2;
	private LinkedList<Recolectable> recolectables;
	private LinkedList<RecogibleMalo> recogiblesMalos;
	private Jugador jugador1;
	private Jugador jugador2;
	private Enemigo[] enemigos = new Enemigo[5];
	private PImage[] niveles;
	private boolean vivo, contador;
	private float tam1, tam2;

	public Logica(Main app) {
		this.app = app;
		this.tiempo = 0;
		this.tRastro = 0;
		this.pantalla = 0;
		this.tam1 = 0;
		this.tam2 = 0;
		this.vivo = true;
		this.contador = true;
		this.recolectables = new LinkedList<Recolectable>();
		this.recogiblesMalos = new LinkedList<RecogibleMalo>();
		this.niveles = new PImage[9];
		this.niveles[0] = app.loadImage("fondoNivel1.jpg");
		this.niveles[1] = app.loadImage("fondoNivel2.jpg");
		this.niveles[2] = app.loadImage("escritorio1.png");
		this.niveles[3] = app.loadImage("escritorio2.png");
		this.niveles[4] = app.loadImage("carga1.png");
		this.niveles[5] = app.loadImage("carga2.png");
		this.niveles[6] = app.loadImage("uno.jpg");
		this.niveles[7] = app.loadImage("dos.jpg");
		this.niveles[8] = app.loadImage("tres.jpg");
		crearEnemigos();
		this.jugador1 = new Jugador(app, this, 2);
		jugador1.setNivel(0);
		jugador1.setPos(new PVector(350, 550));
		jugador1.start();
		this.jugador2 = new Jugador(app, this, 1);
		jugador2.setNivel(0);
		jugador2.setPos(new PVector(850, 550));
		jugador2.start();
		
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
					tiempo = app.millis() - 8000;
					contador = false;
				}
				crearRecolecables();
				jugador1.validarChoqueJugadores(jugador2);
				jugador2.validarChoqueJugadores(jugador1);
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].validarChoque(jugador1);
					enemigos[i].validarChoque(jugador2);
				}
				if (tRastro + 9000 < app.millis()) {
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
				if (contador) {
					tiempo = app.millis() - 7000;
					contador = false;
				}
				crearRecolecables();
		
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].mover();
				}

				if (jugador1.getPos().x > 0 && jugador1.getPos().x < 200 && jugador1.getPos().y > 500
						&& jugador1.getPos().y < app.height) {
					if (tam1 < 200) {
						tam1 += 0.03 * getJugador1().getNivel();
					}
				}

				if (jugador2.getPos().x > 1000 && jugador2.getPos().x < app.width && jugador2.getPos().y > 500
						&& jugador2.getPos().y < app.height) {
					if (tam2 < 200) {
						tam2 += 0.03 * getJugador2().getNivel();
					}
				}
				for (int i = 0; i < enemigos.length; i++) {
					enemigos[i].validarChoque(jugador1);
					enemigos[i].validarChoque(jugador2);
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
			app.imageMode(app.CORNER);
			app.image(niveles[6], 0, 0,1200,700);
			break;
		case 1:
			app.imageMode(app.CORNER);
			app.image(niveles[7], 0, 0,1200,700);
			break;
		case 2:
			app.imageMode(app.CORNER);
			app.image(niveles[0], 0, 0);
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
			app.imageMode(app.CORNER);
			app.image(niveles[8], 0, 0,1200,700);
			break;
		case 4:
			app.imageMode(app.CORNER);
			app.image(niveles[1], 0, 0);
			app.fill(100);
			app.fill(94, 22, 25);
			app.rect(290, 620, tam1, 25);// carga diseño 1
			app.fill(42, 17, 37);
			app.rect(812, 620, tam2, 25);// carga diseño 2
			jugador1.pintar();
			jugador2.pintar();
			app.imageMode(app.CORNER);
			app.image(niveles[2], 0, 565);
			app.image(niveles[3], 990, 565);
			app.image(niveles[4], 220, 580);
			app.image(niveles[5], 740, 580);
			for (int i = 0; i < recolectables.size(); i++) {
				recolectables.get(i).pintar();
			}
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
	if(app.mousePressed) {
		pantalla ++;
		}
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
			if (tiempo + 8000 < app.millis()) {
				for (int i = 0; i < 3; i++) {
					Recolectable elRecolectable = new Recolectable(app, (int) app.random(0, 5));
					recolectables.add(elRecolectable);
				}
				tiempo = app.millis();
			}
			break;
		case 4:
			if (tiempo + 8000 < app.millis()) {
				for (int i = 0; i < 3; i++) {
					Recolectable elRecolectable = new Recolectable(app, (int) app.random(5, 9));
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
