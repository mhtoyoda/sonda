package br.com.toyoda.elo7.instruction;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.exception.IllegalCoordinateException;
import br.com.toyoda.elo7.exception.InstructionsException;
import br.com.toyoda.elo7.exception.MovimentSondaException;
import br.com.toyoda.elo7.instruction.Instructions;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SondaTest {
	
	@Autowired
	private Instructions instructions;
	
	@Test
	public void moveSondaTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(1, 2, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "LMLMLMLMM");
		
		Sonda sondaB = new Sonda(3, 3, Direction.EAST);
		sondaB = instructions.executeInstructions(planalto, sondaB, "MMRMMRMRRM");
		
		assertThat(1, equalTo(sonda.getCoordinateX()));
		assertThat(3, equalTo(sonda.getCoordinateY()));
		assertThat(Direction.NORTH, equalTo(sonda.getDirection()));
		
		assertThat(5, equalTo(sondaB.getCoordinateX()));
		assertThat(1, equalTo(sondaB.getCoordinateY()));
		assertThat(Direction.EAST, equalTo(sondaB.getDirection()));
	}
	
	@Test(expected = MovimentSondaException.class)
	public void sondaExceedPlanaltoLimitXTest() {
		Planalto planalto = new Planalto(1, 1);
		Sonda sonda = new Sonda(4, 4, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "MMMMM");
	}
	
	@Test(expected = MovimentSondaException.class)
	public void sondaExceedPlanaltoLimitYTest() {
		Planalto planalto = new Planalto(2, 2);
		Sonda sonda = new Sonda(1, 4, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "MMMMM");
	}
	
	@Test(expected = MovimentSondaException.class)
	public void sondaExceedLimitYPlanaltoTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(4, 4, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "MMMMM");
	}
	
	@Test(expected = MovimentSondaException.class)
	public void sondaExceedLimitXPlanaltoTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(4, 4, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "RMMMMM");	
	}
	
	@Test(expected = InstructionsException.class)
	public void instructInvalidMovimentTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(4, 4, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "LRTMM");
	}
	
	@Test(expected = IllegalCoordinateException.class)
	public void sondaCoordinateXInvalidMovimentTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(-1, 2, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "LRLM");	
	}
	
	@Test(expected = IllegalCoordinateException.class)
	public void sondaCoordinateYInvalidMovimentTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(1, -2, Direction.NORTH);
		sonda = instructions.executeInstructions(planalto, sonda, "LRLM");
	}
	
	@Test(expected = IllegalCoordinateException.class)
	public void sondaDirectionInvalidMovimentTest() {
		Planalto planalto = new Planalto(5, 5);
		Sonda sonda = new Sonda(1, 2, null);
		sonda = instructions.executeInstructions(planalto, sonda, "LRLM");
	}
}
