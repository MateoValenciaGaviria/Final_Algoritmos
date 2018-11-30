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
	//  this.recolectables = new PImage[0];
		this.pos = new PVector(app.random(25,app.width-tam),app.random(25,app.height-220));
		this.tam = 30;
		this.tipo = tipo;
	}
	
	public void pintar(){
		switch (tipo) {
		case 0:
			app.fill(0,255,0);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 1:
			app.fill(0,0,255);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 2:
			app.fill(200,200,0);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 3:
			app.fill(200,0,200);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 4:
			app.fill(180,0,110);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 5:
			app.fill(100,200,90);
			app.ellipse(pos.x, pos.y, tam, tam);
			break;
		case 6:
			app.fill(30,120,250);
			app.ellipse(pos.x, pos.y, tam, tam);
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
