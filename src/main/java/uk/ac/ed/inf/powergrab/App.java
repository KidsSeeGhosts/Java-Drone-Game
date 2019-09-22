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
        Position start = new Position(5,5);
        System.out.println(start.nextPosition(Direction.SSW).latitude);
        System.out.println(start.nextPosition(Direction.SSW).longitude);
    }
    
}
