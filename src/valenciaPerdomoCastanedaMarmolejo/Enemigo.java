package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class Enemigo extends Personaje {

	private PImage[] enemigos;
	private PVector rand;
	private int tipo, rand1, rand2;
	private boolean vivo, mover1;

	public Enemigo(Main app, Logica log, int tipo) {
		super(app, log);
		this.tipo = tipo;
		this.mover1 = true;
		this.vivo = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (vivo) {
			if (log.getPantalla() == 2) {
				if (mover1) {
					rand1 = (int) app.random(tam, app.width - tam);
					rand2 = (int) app.random(tam, app.height - tam);
					rand = new PVector(rand1, rand2);
					mover1 = false;
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
		switch (tipo) {
		case 1:
			app.noStroke();
			app.fill(100, 100, 100);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;

		case 2:
			break;

		case 3:
			break;
		}

	}

	public void crearRastro(int tipo) {
		//System.out.println("in");
		RecogibleMalo r = new RecogibleMalo(app, tipo);
		PVector posi = new PVector(this.pos.x,this.pos.y);
		r.setPos(posi);
		log.setRecogiblesMalos(r);
	}

	@Override
	public void mover() {
		switch (tipo) {

		case 1:
			if (pos.x < rand1) {
				pos.x +=2;
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

		case 2:
			break;

		case 3:
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
