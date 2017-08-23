package br.com.toyoda.elo7.orientation;

import br.com.toyoda.elo7.direction.Direction;
import br.com.toyoda.elo7.model.Planalto;
import br.com.toyoda.elo7.model.Sonda;

public class NorthMoviment implements OrientationMoviment {

	@Override
	public Direction left() {
		return Direction.WEST;
	}

	@Override
	public Direction right() {
		return Direction.EAST;
	}

	@Override
	public Sonda moviment(Planalto planalto, Sonda sonda) {
	    if(planalto.getCoordenadaLimitY() >= (sonda.getCoordinateY() + 1)){	        
	        sonda.updateCoordinateY(sonda.getCoordinateY() + 1);
	    }
		return sonda;
	}
}