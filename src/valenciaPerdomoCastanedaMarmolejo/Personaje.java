package valenciaPerdomoCastanedaMarmolejo;

import java.util.ArrayList;

import processing.core.PVector;

public abstract class Personaje extends Thread {
	
	protected Main app;
	protected Logica log;
	protected PVector pos, vel;
	protected int tam, nivel;
	protected boolean vivo;
	protected ArrayList<Recolectable> recolectables;

	public Personaje(Main app, Logica log){
		this.app = app;
		this.log = log;
	}
	
	public void pintar(){
		
	}
	
	public abstract void run();
	public abstract void mover();
	public abstract void recogerElementos();
	public PVector getPos(){
		return pos;
	}
	public int getTam(){
		return tam;
	}
	public int getNivel(){
		return nivel;
	}
	public ArrayList<Recolectable> getRecolectables(){
		return recolectables;
	}
	
	
}
