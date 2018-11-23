package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class Recolectable {
	
	private Main app;
	private PImage[] recolectables;
	private PVector pos;
	private int tam,tipo;

	public Recolectable(Main app){
		this.app = app;
	}
	
	public void pintar(){
		
	}
	
	public PVector getPos(){
		return pos;
	}
	
	public void setPos(){
		
	}
	
}
