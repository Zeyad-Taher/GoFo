package gofoo;
import java.util.ArrayList;

/**
 * A sub class PlagroundOwner takes the personal information of a player that registers as a player which inherits from class 
 * person, then this information will be saved in the database(Structure class) at the array list of players.
 * @author Adel Ashraf
 * @version 2.0 June 8, 2021
 */
public class Player extends Person {
    protected ArrayList<Request> requests= new ArrayList<Request>();
    protected ArrayList<Booking> bookings= new ArrayList<Booking>();
    
    /**
     * A parameterized constructor that constructs  an object from class Player and initializes it with the values passed to it.
     * @param n, it take a parameter n of String type.
     * @param a, it take a parameter a of String type.
     * @param ID, it take a parameter ID of String type.
     * @param phone, it take a parameter phone of String type.
     * @param add, it take a parameter add of String type.
     * @param s, it take a parameter s of String type.
     * @param username, it take a parameter username of String type.
     * @param mail, it take a parameter mail of String type.
     * @param pass, it take a parameter pass of String type.
     */
    Player(String n,String a,String ID,String phone,String add,String s,String username,String mail,String pass){
        name=n;
        age=a;
        nationalId=ID;
        phoneNo=phone;
        address=add;
        sex=s;
        userName=username;
        email=mail;
        password=pass;
    }
    /**
     * A function responsible for adding a request made by the player to book a playground to the array list of requests.
     * @param request, It takes an object from class Request as a parameter.
     */
    void addRequest(Request request){
        requests.add(request);
    }
    /**
     * A function responsible for adding a request to the array list of bookings after the playground owner accepts 
     * the request made by the player.
     * @param booking, It takes an object from class Booking as a parameter.
     */
    void addBooking(Booking booking){
        bookings.add(booking);
    }
}