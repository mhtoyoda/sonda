package br.com.toyoda.elo7.model;

public class Planalto {
	
	private String nome;
	private int coordenadaMinimoX;
	private int coordenadaMinimoY;
	private int coordenadaLimitX;
	private int coordenadaLimitY;

	public Planalto(String nome, int coordenadaLimitX, int coordenadaLimitY) {
		this.nome = nome;
		this.coordenadaMinimoX = 0;
		this.coordenadaLimitX = coordenadaLimitX;
		this.coordenadaMinimoY = 0;
		this.coordenadaLimitY = coordenadaLimitY;
	}

	public String getNome() {
		return nome;
	}
	
	public int getCoordenadaMinimoX() {
		return coordenadaMinimoX;
	}

	public int getCoordenadaMinimoY() {
		return coordenadaMinimoY;
	}

	public int getCoordenadaLimitX() {
		return coordenadaLimitX;
	}

	public int getCoordenadaLimitY() {
		return coordenadaLimitY;
	}
}