package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Jugador extends Personaje {

	private PImage jugador1;
	private PImage jugador2;
	private int tipo;
	private int tiempo, tiempoNivel;
	private boolean arriba, abajo, izquierda, derecha, rastro1, ralentizado;

	public Jugador(Main app, Logica log, int tipo) {
		super(app, log);
		// TODO Auto-generated constructor stub
		this.jugador1 = app.loadImage("jugador1.png");
		this.jugador2 = app.loadImage("jugador2.png");
		this.tipo = tipo;
		this.arriba = false;
		this.abajo = false;
		this.izquierda = false;
		this.derecha = false;
		this.rastro1 = false;
		this.ralentizado = false;
		this.tiempo = 0;
		this.tiempoNivel = app.millis() + 2000;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (vivo) {
			recogerElementos();
			recogerRastros();
			if (arriba) {
				if (pos.y > 60) {
					pos.y = pos.y - vel.y;
				}
			}
			if (abajo) {
				if (pos.y < app.height - 25) {
					pos.y = pos.y + vel.y;
				}
			}
			if (derecha) {
				if (pos.x < app.width - 25) {
					pos.x = pos.x + vel.x;
				}
			}
			if (izquierda) {
				if (pos.x > 25) {
					pos.x = pos.x - vel.x;
				}
			}
			if (rastro1) {
				this.vel = new PVector(1, 1);
				if (tiempo + 5000 < app.millis()) {
					this.vel = new PVector(5, 5);
					rastro1 = false;
				}
			}

			if (log.getPantalla() == 4) {
				if (tiempo < app.millis()) {
					if (nivel > 0) {
						nivel--;
					}
					tiempo = app.millis() + 2000;
				}
			}

			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		switch (tipo) {
		case 1:
		
			app.fill(42, 17, 37);
			app.rect(pos.x+50, pos.y-50, nivel, 25);// carga dise�o 2
			app.imageMode(app.CENTER);
			app.image(jugador1, pos.x, pos.y);
			break;
		case 2:
			
			app.fill(94, 22, 25);
			app.rect(pos.x+50, pos.y-50, nivel, 25);// carga dise�o 1
			app.imageMode(app.CENTER);
			app.image(jugador2, pos.x, pos.y);
			break;
		}
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		switch (tipo) {
		case 1:
			if (app.keyCode == app.UP) {
				arriba = true;
			}
			if (app.keyCode == app.DOWN) {
				abajo = true;
			}
			if (app.keyCode == app.RIGHT) {
				derecha = true;
			}
			if (app.keyCode == app.LEFT) {
				izquierda = true;
			}
			break;
		case 2:
			if (app.key == 'w') {
				arriba = true;
			}
			if (app.key == 's') {
				abajo = true;
			}
			if (app.key == 'd') {
				derecha = true;
			}
			if (app.key == 'a') {
				izquierda = true;
			}
			break;
		}
	}

	public void soltar() {
		switch (tipo) {
		case 1:
			if (app.keyCode == app.UP) {
				arriba = false;
			}
			if (app.keyCode == app.DOWN) {
				abajo = false;
			}
			if (app.keyCode == app.RIGHT) {
				derecha = false;
			}
			if (app.keyCode == app.LEFT) {
				izquierda = false;
			}
			break;
		case 2:
			if (app.key == 'w') {
				arriba = false;
			}
			if (app.key == 's') {
				abajo = false;
			}
			if (app.key == 'd') {
				derecha = false;
			}
			if (app.key == 'a') {
				izquierda = false;
			}
			break;
		}
	}

	public void recogerElementos() {
		for (int i = 0; i < log.getRecolectables().size(); i++) {
			if ((pos.dist(log.getRecolectables().get(i).getPos()) < tam)) {
				recolectables.add(log.getRecolectables().get(i));
				log.getRecolectables().remove(i);
				nivel++;
			}
		}
	}

	public void recogerRastros() {
		for (int i = 0; i < log.getRecogiblesMalos().size(); i++) {
			if ((pos.dist(log.getRecogiblesMalos().get(i).getPos()) < tam)) {
				rastros.add(log.getRecogiblesMalos().get(i));
				log.getRecogiblesMalos().remove(i);
				tiempo = app.millis();
				rastro1 = true;
			}
		}
	}

	public void aplicarRecolectables() {
		for (int i = 0; i < recolectables.size(); i++) {
			switch (recolectables.get(i).getTipo()) {
			case 0:

				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			}
		}
	}

	public void validarChoqueJugadores(Jugador j) {
		if (PApplet.dist(pos.x, pos.y, j.getPos().x, j.getPos().y) < tam) {
			if (nivel > j.getNivel()) {
				if (j.getNivel() > 0) {
					nivel++;
				}
			} else if (nivel < j.getNivel()) {
				if (nivel > 0) {
					nivel--;
				}
			}
		}

	}

	public void restarNivel(int i) {
		nivel -= i;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
