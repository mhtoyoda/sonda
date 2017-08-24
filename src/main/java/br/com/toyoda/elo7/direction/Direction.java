package br.com.toyoda.elo7.direction;

import br.com.toyoda.elo7.model.Sonda;

public enum Direction {

	NORTH {
		@Override
		public Direction left() {
			return Direction.WEST;
		}

		@Override
		public Direction right() {
			return Direction.EAST;
		}

		@Override
		public Sonda moviment(Sonda sonda) {
			sonda.updateCoordinateY(1);
			return sonda;
		}
	},
	SOUTH {
		@Override
		public Direction left() {
			return Direction.EAST;
		}

		@Override
		public Direction right() {
			return Direction.WEST;
		}

		@Override
		public Sonda moviment(Sonda sonda) {
			sonda.updateCoordinateY(-1);
			return sonda;
		}
	},
	WEST {
		@Override
		public Direction left() {
			return Direction.SOUTH;
		}

		@Override
		public Direction right() {
			return Direction.NORTH;
		}

		@Override
		public Sonda moviment(Sonda sonda) {
			sonda.updateCoordinateX(-1);
			return sonda;
		}
	},
	EAST {
		@Override
		public Direction left() {
			return Direction.NORTH;
		}

		@Override
		public Direction right() {
			return Direction.SOUTH;
		}

		@Override
		public Sonda moviment(Sonda sonda) {
			sonda.updateCoordinateX(1);
			return sonda;
		}		
	};

	public abstract Direction left();
	
	public abstract Direction right();
	
	public abstract Sonda moviment(Sonda sonda);
}