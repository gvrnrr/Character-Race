import java.awt.*;
import java.util.Random;

public class Enderman extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Enderman( )
    {
        super( );
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Enderman( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
    }

    /** move:  calculates the new x position for the racer
     *   Hare move characteristics:  30% of the time, Hare jumps 5 pixels
     *                               70% of the time, Hare sleeps (no move)
     *   generates random number between 1 & 10
     *          for 1 - 7,  no change to x position
     *          for 8 - 10, x position is incremented by 5
     */
    public void move( )
    {
        Random rand = new Random( );
        int move =  rand.nextInt( 10 ) + 1 ;

        if ( getX( ) < 100 )
        {
            if ( move < 5 )
                setX( getX( ) + 4 );
        }
        else
        {
            if ( move > 7 )
                setX( getX( ) + 4 );
        }
    }

    /** draw: draws the Enderman at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        int startX = getX( );
        int startY = getY( );
        if(this.isWinner) {
            morph(g);
        }

        g.setColor( new Color( 0, 0, 0 ) ); // black

        //head
        g.fillRect( startX - 20, startY - 21, 15, 17 );


        //body
        g.fillRect( startX - 18, startY -20,  11, 32 );


        g.fillRect( startX - 17, startY - 20,  2, 45 );
        g.fillRect( startX - 17, startY - 20,  2, 45 );

        //LEGS
        g.fillRect( startX - 17, startY + 10, 4, 20 );
        g.fillRect( startX - 12, startY + 10, 4, 20 );

        //EYES
        g.setColor( new Color( 200, 0, 250 ) );  // purple
        g.fillRect( startX - 12, startY - 16,  3, 2 );
        g.fillRect( startX - 17, startY - 16, 3, 2 );
    }

    // Enderman morph
    @Override
    public void morph(Graphics g) {
        int startX = getX( );
        int startY = getY( );

        //ARMS
        g.setColor( new Color( 0, 0, 0 ) ); // black
        g.fillRect( startX - 7, startY - 1,  14, 2 );
        g.fillRect( startX - 7, startY + 2,  14, 2 );

        // Holding grass block

        //grass
        g.setColor( new Color( 0, 100, 0 ) );
        g.fillRect( startX + 7, startY - 5, 8, 3 );

        //dirt
        g.setColor( new Color( 78, 53, 36 ) );
        g.fillRect( startX + 7, startY - 2, 8, 7 );


    }

}
