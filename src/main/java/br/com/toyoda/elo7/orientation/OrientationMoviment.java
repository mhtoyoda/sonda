package br.com.toyoda.elo7.orientation;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

public interface OrientationMoviment {

	public Direction left();
	
	public Direction right();
	
	public Sonda moviment(Planalto planalto, Sonda sonda);
}
