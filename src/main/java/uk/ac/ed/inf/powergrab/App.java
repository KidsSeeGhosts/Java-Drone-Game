package uk.ac.ed.inf.powergrab;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Testing nextPosition
        Position start = new Position(55.944425,-3.188396);
        System.out.println(start.nextPosition(Direction.SSE).latitude);
        System.out.println(start.nextPosition(Direction.SSE).longitude);
        //System.out.println((0.0003*Math.sin(67.5)));
        //System.out.println(Math.sin(67.5));
    }
    
}
