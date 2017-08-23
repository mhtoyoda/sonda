package br.com.toyoda.elo7.direction;

import br.com.toyoda.elo7.orientation.EastMoviment;
import br.com.toyoda.elo7.orientation.NorthMoviment;
import br.com.toyoda.elo7.orientation.OrientationMoviment;
import br.com.toyoda.elo7.orientation.SouthMoviment;
import br.com.toyoda.elo7.orientation.WestMoviment;

public enum Direction {

	NORTH {
		@Override
		public OrientationMoviment getOrientation() {
			return new NorthMoviment();
		}
	},
	SOUTH {
		@Override
		public OrientationMoviment getOrientation() {
			return new SouthMoviment();
		}
	},
	WEST {
		@Override
		public OrientationMoviment getOrientation() {
			return new WestMoviment();
		}
	},
	EAST {
		@Override
		public OrientationMoviment getOrientation() {
			return new EastMoviment();
		}
	};

	public abstract OrientationMoviment getOrientation();
}