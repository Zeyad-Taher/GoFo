package gofoo;
import java.util.ArrayList;

/**
 * A class structure is acting as a data base which stores the list of all added: playground owners, players, playgrounds with the specific owner
 * of each playground, all the requests made by a player and a list for playgrounds that haven't been approved by administrator yet.
 * @author zeyad Taher
 * @version 2.0 June 9, 2021
 */

public class Structure {
    protected ArrayList<Playground> playgrounds= new ArrayList<Playground>();
    protected ArrayList<PlaygroundOwner> owners= new ArrayList<PlaygroundOwner>();
    protected ArrayList<Player> players= new ArrayList<Player>();
    protected ArrayList<Playground> waitingPlaygrounds= new ArrayList<Playground>();
    protected ArrayList<Playground> resultPlaygrounds= new ArrayList<Playground>();
    
    /**
     * A function that displays all the playgrounds with their price that are available in the time the player chooses 
     * when he wants to request a playground.
     * @param hours, It takes a parameter hours of type integer.
     * @param startTime, It takes a parameter startTime of type integer.
     */
    public void searchAndDisplayPlaygrounds(int hours, int startTime){
        int n = 1;
        boolean available = false;
        for (int i = 0; i < playgrounds.size(); i++)
        {
            for (int j = startTime; j < startTime+hours; j++)
            {
                if (playgrounds.get(i).arrHours[j] == 0)
                {
                    available = true;
                }
                else if (playgrounds.get(i).arrHours[j] == 1)
                {
                    available = false;
                }
            }
            if (available == true)
            {
                resultPlaygrounds.add(playgrounds.get(i));
                System.out.println("Playground " + n + " total price: " + (playgrounds.get(i).pricePerHour*hours)+" L.E");
                n++;
            }
        }
    }
    
    /**
     * A function responsible for adding a new player after he registers with his personal information to the array list of players.
     * @param player, it takes an object from class Player as parameter.
     */
    public void addPlayer(Player player){
        players.add(player);
    }
    
    /**
     * A function that adds a new playground to the array list of playgrounds after it has been accepted by the admin.
     * @param playground, it takes an object from class Playground as parameter.
     */
    public void addPlayground(Playground playground){
        playgrounds.add(playground);
    }
    
    /**
     * A function that adds a new playground owner to the array list of owners after he chooses to register with his personal info.
     * @param owner, it takes an object from class PlaygroundOwner as parameter.
     */
    public void addPlaygroundOwner(PlaygroundOwner owner){
        owners.add(owner);
    }
    
    /**
     * This function is responsible for adding a playground to the array list of waitingPlaygrounds when a playground owner
     * chooses to add a playground but it has not been approved by the admin yet.
     * @param ground, it takes an object from class Playground as parameter.
     */
    public void addWaiting(Playground ground){
        waitingPlaygrounds.add(ground);
    }
}