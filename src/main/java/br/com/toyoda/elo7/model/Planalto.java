package br.com.toyoda.elo7.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Planalto {
	
	private int coordenadaLimitX;
	private int coordenadaLimitY;
	 
	@JsonCreator
	public Planalto(@JsonProperty("coordenadaLimitX") int coordenadaLimitX,@JsonProperty("coordenadaLimitY") int coordenadaLimitY) {
		this.coordenadaLimitX = Optional.ofNullable(coordenadaLimitX).orElse(1);
		this.coordenadaLimitY = Optional.ofNullable(coordenadaLimitY).orElse(1);
	}
	
	public int getCoordenadaLimitX() {
		return coordenadaLimitX;
	}

	public int getCoordenadaLimitY() {
		return coordenadaLimitY;
	}
}