package br.com.toyoda.elo7.model;

import br.com.toyoda.elo7.direction.Direction;

public class Sonda {
	
	private String identificacao;
	private int coordinateX;
	private int coordinateY;
	private Direction direction;
	
	public Sonda(String identificacao, int coordinateX, int coordinateY, Direction direction) {
		this.identificacao = identificacao;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.direction = direction;
	}

	public Sonda updateCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
		return this;
	}

	public Sonda updateCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
		return this;
	}

	public Sonda updateDirection(Direction direction) {
		this.direction = direction;
		return this;
	}
	
	public Sonda moveLeft(){
		Direction direction = this.getDirection().getOrientation().left();
		updateDirection(direction);
		return this;
	}
	
	public Sonda moveRight(){
		Direction direction = this.getDirection().getOrientation().right();
		updateDirection(direction);
		return this;
	}
	
	public Sonda moveOn(Planalto planalto) {
		this.direction.getOrientation().moviment(planalto, this);
		return this;
	}
	
	public String getIdentificacao() {
		return identificacao;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "A sonda " + identificacao + " estava inicialmente localizada em " + coordinateX + "," + coordinateY
				+ " na direcao " + direction.name();
	}
	
}