package br.com.toyoda.elo7.orientation;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

public class EastMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.NORTH;
	}

	@Override
	public Direction right() {
		return Direction.SOUTH;
	}

	@Override
	public Sonda moviment(Planalto planalto, Sonda sonda) {
	    if(planalto.getCoordenadaLimitX() >= (sonda.getCoordinateX() + 1)){	        
	        sonda.updateCoordinateX(sonda.getCoordinateX() + 1);
	    }
		return sonda;
	}
}