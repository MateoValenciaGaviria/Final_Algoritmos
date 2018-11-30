package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Personaje {

	private PImage[] enemigos;
	private PVector rand;
	private int rand1, rand2;
	private boolean vivo, mover1;

	public Enemigo(Main app, Logica log, int tipo) {
		super(app, log);
		this.mover1 = true;
		this.vivo = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (vivo) {
			switch (log.getPantalla()) {
			case 2:
				if (mover1) {
					rand1 = (int) app.random(tam, app.width - tam);
					rand2 = (int) app.random(tam, app.height - 200);
					rand = new PVector(rand1, rand2);
					mover1 = false;
				}
				break;
			case 4:
				if (mover1) {
					rand1 = (int) app.random(tam, app.width - tam);
					rand2 = (int) app.random(tam, app.height - 200);
					rand = new PVector(rand1, rand2);
					mover1 = false;
				}
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

	@Override
	public void pintar() {
		switch (log.getPantalla()) {
		case 2:
			app.noStroke();
			app.fill(100, 100, 100);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;

		case 4:
			app.noStroke();
			app.fill(100, 100, 100);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;

		}

	}

	public void crearRastro(int tipo) {
		// System.out.println("in");
		RecogibleMalo r = new RecogibleMalo(app, tipo);
		PVector posi = new PVector(this.pos.x, this.pos.y);
		r.setPos(posi);
		log.setRecogiblesMalos(r);
	}

	@Override
	public void mover() {
		switch (log.getPantalla()) {

		case 2:
			if (pos.x < rand1) {
				pos.x += 2;
			}
			if (pos.x > rand1) {
				pos.x -= 2;
			}
			if (pos.y < rand2) {
				pos.y += 2;
			}
			if (pos.y > rand2) {
				pos.y -= 2;
			}

			if (pos.dist(rand) < 10) {
				mover1 = true;
			}
			break;

		case 4:
			if (log.getJugador1().getPos().x > tam && log.getJugador1().getPos().x < app.width - tam
					&& log.getJugador1().getPos().y > tam && log.getJugador1().getPos().y < app.height - 200) {

				vel = new PVector(4, 4);
				if (pos.x < log.getJugador1().getPos().x) {
					pos.x += vel.x;
				}
				if (pos.x > log.getJugador1().getPos().x) {
					pos.x -= vel.x;
				}
				if (pos.y < log.getJugador1().getPos().y) {
					pos.y += vel.y;
				}
				if (pos.y > log.getJugador1().getPos().y) {
					pos.y -= vel.y;
				}

			}
			if (log.getJugador2().getPos().x > tam && log.getJugador2().getPos().x < app.width - tam
					&& log.getJugador2().getPos().y > tam && log.getJugador2().getPos().y < app.height - 200) {

				vel = new PVector(4, 4);
				if (pos.x < log.getJugador2().getPos().x) {
					pos.x += vel.x;
				}
				if (pos.x > log.getJugador2().getPos().x) {
					pos.x -= vel.x;
				}
				if (pos.y < log.getJugador2().getPos().y) {
					pos.y += vel.y;
				}
				if (pos.y > log.getJugador2().getPos().y) {
					pos.y -= vel.y;
				}
			} else {
				if (pos.x < rand1) {
					pos.x += 2;
				}
				if (pos.x > rand1) {
					pos.x -= 2;
				}
				if (pos.y < rand2) {
					pos.y += 2;
				}
				if (pos.y > rand2) {
					pos.y -= 2;
				}

				if (pos.dist(rand) < 10) {
					mover1 = true;
				}
			}

			break;
		}
	}

	public void validarChoque(Jugador j) {
		if (pos.dist(j.pos) < tam) {
			if (j.getNivel() > 10) {
				j.restarNivel(10);
			} else {
				j.restarNivel(j.getNivel());
			}
		}
	}

}
