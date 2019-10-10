package uk.ac.ed.inf.powergrab;


public class Position {


    public double latitude;
    public double longitude;
    
    //These are the 3 lengths needed to move the drone the correct distance in 22.5 degree increments, calculated only once.
	private static final double length1 = 0.0003*Math.sin(Math.toRadians(67.5));
	private static final double length2 = 0.0003*Math.sin(Math.toRadians(45));
	private static final double length3 = 0.0003*Math.sin(Math.toRadians(22.5));
    
	//Defining position type for longitude,latitude coordinates.
    public Position (double latitude, double longitude) {
    		this.latitude = latitude;
    		this.longitude = longitude;
    }

    //Going North increases latitude.
    //Going South decreases latitude.
    //Going East increases longitude.
    //Going West decreases.
    
    //This function returns the next position of the drone after it makes a move in the specified compass direction.
    public Position nextPosition (Direction direction) {
    		if (direction == Direction.N) {
    			return new Position(latitude+0.0003,longitude);//0.0003 is how far the drone moves in one move.
    		}
    		if (direction == Direction.NNE) { //Adding to longitude and latitude as we go East.
    			return new Position(latitude+length1,longitude+length3);
    		}
    		if (direction == Direction.NE) {
    			return new Position(latitude+length2,longitude+length2);
    		}
    		if (direction == Direction.ENE) {
    			return new Position(latitude+length3,longitude+length1);
    		}
    		if (direction == Direction.E) {
    			return new Position(latitude,longitude+0.0003);
    		}
    		if (direction == Direction.ESE) {//Still adding to longitude, subtracting from latitude as we go South.
    			return new Position(latitude-length3,longitude+length1);
    		}
    		if (direction == Direction.SE) {
    			return new Position(latitude-length2,longitude+length2);
    		}
    		if (direction == Direction.SSE) {
    			return new Position(latitude-length1,longitude+length3);
    		}
    		if (direction == Direction.S) {
    			return new Position(latitude-0.0003,longitude);
    		}
    		if (direction == Direction.SSW) {//Now decreasing the longitude and latitude as we go West.
    			return new Position(latitude-length1,longitude-length3);
    		}
    		if (direction == Direction.SW) {
    			return new Position(latitude-length2,longitude-length2);
    		}
    		if (direction == Direction.WSW) {
    			return new Position(latitude-length3,longitude-length1);
    		}
    		if (direction == Direction.W) {
    			return new Position(latitude,longitude-0.0003);
    		}
    		if (direction == Direction.WNW) {//Starting to increase latitude again and continue decreasing longitude as we return to North.
    			return new Position(latitude+length3,longitude-length1);
    		}
    		if (direction == Direction.NW) {
    			return new Position(latitude+length2,longitude-length2);
    		}
    		if (direction == Direction.NNW) {
    			return new Position(latitude+length1,longitude-length3);
    		}
    		else {//This else should never be reached as all valid direction types are covered.
    			return new Position(latitude,longitude);
    		}
    }
    
    //The inPlayArea function returns true if the position is inside the play area defined by 2 latitudes and 2 longitudes.
    public boolean inPlayArea() {
    		if (latitude<55.946233 && latitude>55.942617 && longitude<-3.184319 && longitude>-3.192473){
    			return true;
    		}
    		else {
    			return false;
    		}
    }
}
