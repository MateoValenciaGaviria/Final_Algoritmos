package valenciaPerdomoCastanedaMarmolejo;

import java.util.ArrayList;
import java.util.LinkedList;

import processing.core.PVector;

public abstract class Personaje extends Thread {

	protected Main app;
	protected Logica log;
	protected PVector pos, vel;
	protected int tam, nivel;
	protected boolean vivo;
	protected LinkedList<Recolectable> recolectables;
	protected LinkedList<RecogibleMalo> rastros;

	public Personaje(Main app, Logica log) {
		this.app = app;
		this.log = log;
		this.pos = new PVector(100, 100);
		this.vel = new PVector(5, 5);
		this.tam = 50; // Por definir
		this.nivel = 0;
		this.vivo = true;
		this.recolectables = new LinkedList<Recolectable>();
		this.rastros = new LinkedList<RecogibleMalo>();
	}

	public abstract void run();

	public abstract void pintar();

	public abstract void mover();

	public PVector getPos() {
		return pos;
	}

	public int getTam() {
		return tam;
	}

	public int getNivel() {
		return nivel;
	}

	public LinkedList<Recolectable> getRecolectables() {
		return recolectables;
	}

	public void setPos(PVector pos) {
		this.pos = pos;
	}
}
