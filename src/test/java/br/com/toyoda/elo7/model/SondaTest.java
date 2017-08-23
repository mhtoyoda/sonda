package br.com.toyoda.elo7.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.toyoda.elo7.direction.Direction;

@RunWith(SpringRunner.class)
public class SondaTest {

	@Test
	public void updateSondaTest() {
		Sonda sonda = new Sonda("sonda01", 1, 2, Direction.NORTH);
		sonda.updateCoordinateX(2).updateCoordinateY(3).updateDirection(Direction.SOUTH);
		Assert.assertEquals(2, sonda.getCoordinateX());
		Assert.assertEquals(3, sonda.getCoordinateY());
		Assert.assertEquals(Direction.SOUTH, sonda.getDirection());
	}
	
	@Test
	public void moveSondaLeftTest() {
		Sonda sonda = new Sonda("sonda01", 1, 2, Direction.NORTH);
		sonda.moveLeft();
		Assert.assertEquals(Direction.WEST, sonda.getDirection());
	}
	
	@Test
	public void moveSondaRightTest() {
		Sonda sonda = new Sonda("sonda01", 1, 2, Direction.NORTH);
		sonda.moveRight();
		Assert.assertEquals(Direction.EAST, sonda.getDirection());
	}
	
	@Test
	public void moveSondaTest() {
		Sonda sonda = new Sonda("sonda01", 1, 2, Direction.NORTH);
		Planalto planalto = new Planalto("Marte", 5, 5);
		sonda.moveOn(planalto);
		Assert.assertEquals(1, sonda.getCoordinateX());
		Assert.assertEquals(3, sonda.getCoordinateY());
		Assert.assertEquals(Direction.NORTH, sonda.getDirection());
	}
}
