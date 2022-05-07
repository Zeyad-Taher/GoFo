package gofoo;

/**
 * A class responsible for making a playground and takes its information with a function to add rating to the playground.
 * @author Muhammed Yassin
 * @version 1.0 June 8, 2021
 */
public class Playground {
    private int openHour;
    private int closeHour;
    protected PlaygroundOwner owner;
    protected int pricePerHour;
    public int arrHours[] = new int[24];

    /**
     * A parameterized constructor that constructs  an object from class Playground and initializes it with the values passed to it 
     * which will be called when the user as a PlaygroundOwner chooses to add a playground.
     * @param price, it take a parameter price of integer type.
     * @param ohour, it take a parameter ohour of integer type.
     * @param chour, it take a parameter chour of integer type.
     * @param own, it take an object from class PlaygroundOwner as a parameter.
     */
    public Playground(int price,int ohour,int chour,PlaygroundOwner own) {
        pricePerHour=price;
        openHour=ohour;
        closeHour=chour;
        for(int i = 0; i < 24; i++)
        {
            if(i>=openHour && i<closeHour){
                arrHours[i] = 0;
            }
            else {
                arrHours[i] = 1;
            }
        }
        owner=own;
    }
}