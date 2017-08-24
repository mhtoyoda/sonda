package br.com.toyoda.elo7.model;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.toyoda.elo7.command.Command;
import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.exception.IllegalCoordinateException;

@JsonInclude(Include.NON_NULL)
public class Sonda {
	
	private int coordinateX;
	private int coordinateY;
	private Direction direction;
	private String message;
	
	@JsonCreator
	public Sonda(@JsonProperty("coordinateX") int coordinateX, @JsonProperty("coordinateY") int coordinateY, @JsonProperty("direction") Direction direction) {
		if(coordinateX < 0){
			throw new IllegalCoordinateException("Coordinate X must be greater than positive number");
		}
		this.coordinateX = coordinateX;		

		if(coordinateY < 0){
			throw new IllegalCoordinateException("Coordinate Y must be greater than positive number");
		}
		this.coordinateY = coordinateY;
		
		this.direction = Optional.ofNullable(direction).orElseThrow(() -> new IllegalCoordinateException("Invalid Direction"));		
	}
	
	public void move(Command command) {
		command.executeCommand(this);
	}
	
	public void updateCoordinateX(int point){
		this.coordinateX = this.coordinateX + point;
	}
	
	public void updateCoordinateY(int point){
		this.coordinateY = this.coordinateY + point;
	}
	
	public void updateDirection(Direction direction){
		this.direction = direction;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}