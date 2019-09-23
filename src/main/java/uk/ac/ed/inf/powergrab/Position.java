package uk.ac.ed.inf.powergrab;


public class Position {


    public double latitude;
    public double longitude;
    
    //Trig height and width results are constants so all the distances don't need to be recalculated each time nextPosition is called in order to make the program more efficient.
    //O.0003 is the hypotenuse length as it is the distance the drone moves in one move.
    //The results are all made positive as they are triangle lengths.
	double h2 = Math.abs(0.0003*Math.sin(67.5));//rsin67.5 height (67.5 degrees for going NNE,SSE,NNW,SSW)
	double w2 = Math.abs(0.0003*Math.cos(67.5));//rcos67.5 width
	double h3 = Math.abs(0.0003*Math.sin(45)); //rsin45 height (45 degrees for going NE,NW,SE,SW)
	double w3 = Math.abs(0.0003*Math.cos(45)); //rcos45 width
	double h4 = Math.abs(0.0003*Math.sin(22.5)); //rsin22.5 height (22.5 degrees for going ENE,ESE,WNW,WSW)
	double w4 = Math.abs(0.0003*Math.cos(22.5)); //rcos22.5 width
    
	
    public Position (double latitude, double longitude) {//Defining position type for longitude,latitude coordinates.
    		this.latitude = latitude;
    		this.longitude = longitude;
    		
    }

    //Going North increases latitude.
    //Going South decreases latitude.
    //Going East increases longitude.
    //Going West decreases.
    public Position nextPosition (Direction direction) {//This function returns the next position of the drone when it makes a move in the specified compass direction.
    		if (direction == Direction.N) {
    			return new Position(latitude+0.0003,longitude);//0.0003 is how far the drone moves in one move.
    		}
    		if (direction == Direction.NNE) {
    			return new Position(latitude+h2,longitude+w2);
    		}
    		if (direction == Direction.NE) {
    			return new Position(latitude+h3,longitude+w3);
    		}
    		if (direction == Direction.ENE) {
    			return new Position(latitude+h4,longitude+w4);
    		}
    		if (direction == Direction.E) {
    			return new Position(latitude,longitude+0.0003);
    		}
    		if (direction == Direction.ESE) {//Still adding to longitude, subtracting from latitude as we go south.
    			return new Position(latitude-h4,longitude+w4);
    		}
    		if (direction == Direction.SE) {
    			return new Position(latitude-h3,longitude+w3);
    		}
    		if (direction == Direction.SSE) {
    			return new Position(latitude-h2,longitude+w2);
    		}
    		if (direction == Direction.S) {
    			return new Position(latitude-0.0003,longitude);
    		}
    		if (direction == Direction.SSW) {//Now decreasing the longitude and latitude.
    			return new Position(latitude-h2,longitude-w2);
    		}
    		if (direction == Direction.SW) {
    			return new Position(latitude-h3,longitude-w3);
    		}
    		if (direction == Direction.WSW) {
    			return new Position(latitude-h4,longitude-w4);
    		}
    		if (direction == Direction.W) {
    			return new Position(latitude,longitude-0.0003);
    		}
    		if (direction == Direction.WNW) {//Starting to increase latitude again and keep decreasing longitude.
    			return new Position(latitude+h4,longitude-w4);
    		}
    		if (direction == Direction.NW) {
    			return new Position(latitude+h3,longitude-w3);
    		}
    		if (direction == Direction.NNW) {
    			return new Position(latitude+h2,longitude-w2);
    		}
    		else {//This else should never be reached as all valid direction types are covered.
    			return new Position(latitude,longitude);
    		}
    }
    
    //The inPlayArea function returns true if the position is in the play area defined by 2 latitudes and 2 longitudes.
    //The position latitude must be between 55.942617 and 55.946233.
    //The position longitude must be between -3.192473 and -3.184319.
    //The function returns false if the drone's position is not within the play area or on the edge of the play area.
    public boolean inPlayArea() {
    		if (latitude<55.946233 && latitude>55.942617 && longitude<-3.184319 && longitude>-3.192473){
    			return true;
    		}
    		else {
    			return false;
    		}
    }
	
	
}
