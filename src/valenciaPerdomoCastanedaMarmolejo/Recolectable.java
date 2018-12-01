package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class Recolectable {
	
	private Main app;
	private PImage[] recolectables;
	private PVector pos;
	private int tam,tipo;

	public Recolectable(Main app, int tipo){
		this.app = app;
	    this.recolectables = new PImage[9];
	    this.recolectables[0] = app.loadImage("after.png");
	    this.recolectables[1] = app.loadImage("eclipse.png");
	    this.recolectables[2] = app.loadImage("ps.png");
	    this.recolectables[3] = app.loadImage("reaper.png");
	    this.recolectables[4] = app.loadImage("ai.png");
	    this.recolectables[5] = app.loadImage("agua.png");
	    this.recolectables[6] = app.loadImage("cafe.png");
	    this.recolectables[7] = app.loadImage("pastel.png");
	    this.recolectables[8] = app.loadImage("energia.png");

		this.pos = new PVector(app.random(25,app.width-tam),app.random(25,app.height-220));
		this.tam = 30;
		this.tipo = tipo;
	}
	
	public void pintar(){
		switch (tipo) {
		case 0:
			app.image(recolectables[0], pos.x, pos.y);
			break;
		case 1:
			app.image(recolectables[1], pos.x, pos.y);
			break;
		case 2:
			app.image(recolectables[2], pos.x, pos.y);
			break;
		case 3:
			app.image(recolectables[3], pos.x, pos.y);
			break;
		case 4:
			app.image(recolectables[4], pos.x, pos.y);
			break;
		case 5:
			app.image(recolectables[5], pos.x, pos.y);
			break;
		case 6:
			app.image(recolectables[6], pos.x, pos.y);
			break;
		case 7:
			app.image(recolectables[7], pos.x, pos.y);
			break;
		case 8:
			app.image(recolectables[8], pos.x, pos.y);
			break;
		}
	}
	
	public PVector getPos(){
		return pos;
	}
	
	public void setPos(PVector pos){
		this.pos = pos;
	}
	
	public int getTipo(){
		return tipo;
	}
	
}
