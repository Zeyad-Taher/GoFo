package gofoo;

/**
 ** A class which aggregates from class Structure that is responsible for creating a booking for a playground after the
 * playground owner accepts the player's request to book his playground.
 * @author Muhammed Yassin
 * @version 1.0 June 8, 2021
 */
public class Booking {
    private Request request;

    /**
     * A parameterized constructor that constructs  an object from class Booking and initializes it with the values passed to it.
     * @param req, it take an object of class Request as a parameter.
     */
    Booking(Request req)
    {
        request = req;
    }
}