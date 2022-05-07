package gofoo;

/**
 * A class responsible for creating a request to book a play ground which aggregates with class Structure when the user as a player
 * chooses to request a playground.
 * @author Muhammed Yassin
 * @version 1.0 June 9, 2021
 */
public class Request {
    protected Playground playground;
    protected int startHour;
    protected int Hours;
    protected Player player;
    protected String status;
    
    /**
     * A parameterized constructor that constructs  an object from class Request and initializes it with the values passed to it.
     * @param h, it take a parameter h of integer type.
     * @param ground, it take an object of class Playground as a parameter.
     * @param play, it take an object of class Player as a parameter.
     * @param sHour, it take a parameter sHour of integer type.
     * @param stat, it take a parameter stat of String type.
     */
    Request(int h,Playground ground,Player play, int sHour,String stat) {
        Hours=h;
        playground=ground;
        player=play;
        startHour= sHour;
        status=stat;
    }
}
