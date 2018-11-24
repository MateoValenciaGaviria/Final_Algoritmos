package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;

public class Enemigo extends Personaje {

	private PImage[] enemigos;

	public Enemigo(Main app, Logica log) {
		super(app, log);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (vivo) {
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

	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

	public void validarChoque() {

	}

}
