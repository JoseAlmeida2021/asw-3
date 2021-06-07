package mpjp.game;


public enum Direction {

	EAST,
	SOUTH,
	WEST,
	NORTH;
	
	
	int delta;
	
	int getSignalX() {
		switch(this) {
		case EAST:
			delta = 1;
			break;
		case SOUTH:
			delta = 0;
			break;
		case WEST:
			delta = -1;
			break;
		case NORTH:
			delta = 0;
			break;
		}

		return delta;

	}

	int getSignalY(){

		switch(this) {
		case EAST:
			delta = 0;
			break;
		case SOUTH:
			delta = 1;
			break;
		case WEST:
			delta = 0;
			break;
		case NORTH:
			delta = -1;
			break;
		}

		return delta;

	}

}
