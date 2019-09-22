package uk.ac.ed.inf.powergrab;


public class Position {


    public double latitude;
    public double longitude;
    
    public Position (double latitude, double longitude) {
    		this.latitude = latitude;
    		this.longitude = longitude;
    	//input current position
    		
    }
    //going North increases latitude
    //going South decreases latitude
    //going East increases longitude
    //going West decreases
    public Position nextPosition (Direction direction) {
    		double h2 = 0.0003*Math.sin(67.5);//rsin67.5
		double w2 = 0.0003*Math.cos(67.5);//rcos67.5
		double h3 = 0.0003*Math.sin(45); //rsin45
		double w3 = 0.0003*Math.cos(45); //rcos45
		double h4 = 0.0003*Math.sin(22.5); //rsin22.5
		double w4 = 0.0003*Math.cos(22.5); //rcos22.5
    		if (direction == Direction.N) {
    			return new Position(latitude+0.0003,longitude);
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
    		if (direction == Direction.ESE) {//still adding to longitude, subtracting from latitude as we go south
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
    		if (direction == Direction.SSW) {// now decreasing the longitude and latitude
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
    		if (direction == Direction.WNW) {//starting to increase latitude again and keep decreasing longitude
    			return new Position(latitude+h4,longitude-w4);
    		}
    		if (direction == Direction.NW) {
    			return new Position(latitude+h3,longitude-w3);
    		}
    		if (direction == Direction.NNW) {
    			return new Position(latitude+h2,longitude-w2);
    		}
    		else {
    			return new Position(latitude,longitude);
    		}
//    	//returns the next position of the drone when it makes a move in the specified compass direction.
//    	//0.0003 degrees in a move. I.e. r = 0.0003.
    }
    
    public boolean inPlayArea() {
    		if (latitude<55.946233 && latitude>55.942617 && longitude<-3.184319 && longitude>-3.192473){
    			return true;
    		}
    		else {
    			return false;
    		}
    	//return yes or no if in play area basically
    	//might need to make the inequalities allow equal to
    }
	
	
}
