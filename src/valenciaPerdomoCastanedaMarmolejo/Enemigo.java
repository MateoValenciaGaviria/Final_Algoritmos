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
		this.enemigos = new PImage[5];
		this.enemigos[0] = app.loadImage("enemigo1.png");
		this.enemigos[1] = app.loadImage("almohada.png");
		this.rand = new PVector(0,0);
		this.pos = new PVector(app.random(25,app.width-tam),app.random(25,app.height-220));
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
			app.imageMode(app.CENTER);
			app.image(enemigos[0], pos.x, pos.y);
			break;

		case 4:
			app.imageMode(app.CENTER);
			app.image(enemigos[1], pos.x, pos.y);
			break;

		}

	}

	public void crearRastro(int tipo) {
		// System.out.println("in");
		RecogibleMalo r = new RecogibleMalo(app);
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
			if (log.getJugador1().getPos().x > 0 && log.getJugador1().getPos().x < app.width
					&& log.getJugador1().getPos().y > 0 && log.getJugador1().getPos().y < app.height - 200) {

				vel = new PVector(3, 3);
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

			} else if (log.getJugador2().getPos().x > 0 && log.getJugador2().getPos().x < app.width
					&& log.getJugador2().getPos().y > 0 && log.getJugador2().getPos().y < app.height - 200) {

				vel = new PVector(3, 3);
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
			}else {
				j.restarNivel(j.getNivel());
			}
		}
	}

}
