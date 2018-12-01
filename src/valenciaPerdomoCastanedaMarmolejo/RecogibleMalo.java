package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class RecogibleMalo {
	private Main app;
	private PImage[] recolectables;
	private PVector pos;
	private int tam,tipo;

	public RecogibleMalo(Main app){
		this.app = app;
	    this.recolectables = new PImage[5];
	    this.recolectables[0] = app.loadImage("insta.png");
	    this.recolectables[1] = app.loadImage("juego.png");
	    this.recolectables[2] = app.loadImage("netflix.png");
	    this.recolectables[3] = app.loadImage("wha.png");
	    this.recolectables[4] = app.loadImage("youtube.png");
		this.pos = new PVector(app.random(25,app.width-tam),app.random(25,app.height-tam));
		this.tam = 30;
		this.tipo = (int) app.random(0,5);
	}
	
	public void pintar(){
		switch (tipo) {//tipo hace referencia l nivel si hacen lo mismo en dicho nivel
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
