package br.com.toyoda.elo7.orientation;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

public class WestMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.SOUTH;
	}

	@Override
	public Direction right() {
		return Direction.NORTH;
	}

	@Override
	public Sonda moviment(Planalto planalto, Sonda sonda) {
	    if(planalto.getCoordenadaMinimoX() <= (sonda.getCoordinateX() - 1)){	        
	        sonda.updateCoordinateX(sonda.getCoordinateX() - 1);
	    }
		return sonda;
	}
}