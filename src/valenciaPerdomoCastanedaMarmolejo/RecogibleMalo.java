package valenciaPerdomoCastanedaMarmolejo;

import processing.core.PImage;
import processing.core.PVector;

public class RecogibleMalo {
	private Main app;
	private PImage[] recolectables;
	private PVector pos;
	private int tam,tipo;

	public RecogibleMalo(Main app, int tipo){
		this.app = app;
	//  this.recolectables = new PImage[0];
		this.pos = new PVector(app.random(25,app.width-tam),app.random(25,app.height-tam));
		this.tam = 30;
		this.tipo = tipo;
	}
	
	public void pintar(){
		switch (tipo) {//tipo hace referencia l nivel si hacen lo mismo en dicho nivel
		case 0:
			app.fill(0,255,0);
			app.rect(pos.x, pos.y, tam, tam);
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
