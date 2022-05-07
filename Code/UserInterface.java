package gofoo;
import java.util.Scanner;

/**
 * This class is to be called in the main function and it is responsible for showing the sub menus depending on the user choice
 * for the main menu and the function that will be called for each choice.
 * @author Zeyad Taher
 * @version 1.0 June 10, 2021
 */
public class UserInterface {
    static Structure system=new Structure();
    
    /**
     * A function responsible for showing a sub menu for an already signed up Admin and allows him to accept or deny a 
     * waiting playground that requests to be added or to logout and return back to the amain menu.
     */
    public static void userLogin(){
        Scanner read = new Scanner( System.in );
        System.out.print("Enter username: ");
        String username=read.nextLine();
        System.out.print("Enter password: ");
        String password=read.nextLine();
        if(username.equals("admin") && password.equals("123")){
            System.out.println("Welcome admin");
            while(true){
                System.out.println("Choose one of the following options:");
                System.out.println("1- Accept new Playground");
                System.out.println("2- Logout");
                int ans=read.nextInt();
                if(ans==1){
                    System.out.println("Choose one of the following");
                    for(int i=0;i<system.waitingPlaygrounds.size();i++){
                        System.out.println("Playground "+(i+1));
                    }
                    int choice=read.nextInt();
                    System.out.println("Choose accept or deny");
                    String ans2=read.next();
                    if(ans2.equals("accept")){
                        system.addPlayground(system.waitingPlaygrounds.get(choice-1));
                        system.waitingPlaygrounds.remove(choice-1);
                        System.out.println("Playground accepted");
                    }
                    else if(ans2.equals("deny")){
                        system.waitingPlaygrounds.remove(choice-1);
                        System.out.println("Playground denied");
                    }
                }
                else if(ans==2){
                    break;
                }
            }
        }
    }
    
    /**
     * A function responsible for showing a sub menu for an existing playground owner and allows him to add a playground, 
     * view all the requests to his playground and have the ability to accept or deny this requests or return to the main menu.
     */
    public static void ownerLogin(){
        Scanner read = new Scanner( System.in );
        System.out.print("Enter username: ");
        String username=read.nextLine();
        System.out.print("Enter password: ");
        String password=read.nextLine();
        PlaygroundOwner owner=new PlaygroundOwner();
        boolean found=false;
        for (int i=0;i<system.owners.size();i++){
            if(system.owners.get(i).userName.equals(username) && system.owners.get(i).password.equals(password)){
                owner=system.owners.get(i);
                System.out.println("Welcome "+owner.name);
                found=true;
            }
        }
        while(found==true){
            System.out.println("1- Add Playground");
            System.out.println("2- My requests");
            System.out.println("3- Logout");
            int ans=read.nextInt();
            if(ans==1){
                System.out.print("Playground Price per hour with L.E: ");
                int price=read.nextInt();
                System.out.print("Playground opening hour: ");
                int ohour=read.nextInt();
                System.out.print("Playground closing hour: ");
                int chour=read.nextInt();
                Playground ground=new Playground(price,ohour,chour,owner);
                system.addWaiting(ground);
                System.out.println("Waiting for admin check.");
            }
            else if(ans==2){
            int n=1;
                System.out.println("Choose one of the following");
                for(int i=0;i<owner.requests.size();i++){
                    System.out.println("Request "+n);
                    n++;
                }
                int choice2=read.nextInt();
                Player playerRequested=owner.requests.get(choice2-1).player;
                System.out.println("Choose accept or deny");
                String ans2=read.next();
                if(ans2.equals("accept")){
                    Request req=owner.requests.get(choice2-1);
                    Booking book=new Booking(req);
                    owner.addBooking(book);
                    playerRequested.addBooking(book);
                    owner.requests.remove(choice2-1);
                    System.out.println("Request has been accepted and added to bookings");
                    for (int j = req.startHour; j < req.startHour+req.Hours; j++){
                        req.playground.arrHours[j]=1;
                    }
                }
                else if(ans2.equals("deny")){
                    playerRequested.requests.get(choice2-1).status="denied";
                    owner.requests.remove(choice2-1);
                    System.out.println("Request has been denied");
                }
            }
            else if(ans==3){
                break;
            }
        }
    }
    
    /**
     * A function responsible for allowing the user to register as new player or a new playground owner and take the user personal
     * information in both cases and if the user chooses to register as a player it will show him a sub menu whether to search for a
     * playground by the number of hours wanted and then request to book it if he want or return to the main menu, and another sub menu
     * if the user chooses to register as a playground owner which gives him the options to add a playground, view the requests for
     * his playground or return back to the main menu.
     */
    public static void register(){
        Scanner read = new Scanner(System.in);
        System.out.print("Choose Player or Playground Owner: ");
        String choice=read.nextLine();
        System.out.print("Enter your Name: ");
        String name=read.nextLine();
        System.out.print("Enter your Age: ");
        String age=read.nextLine();
        System.out.print("Enter your National ID: ");
        String nationalId=read.nextLine();
        System.out.print("Enter your Phone no: ");
        String phone=read.nextLine();
        System.out.print("Enter your Address: ");
        String address=read.nextLine();
        System.out.print("Enter your Sex: ");
        String sex=read.nextLine();
        System.out.print("Enter your Username: ");
        String username=read.nextLine();
        System.out.print("Enter your Email: ");
        String email=read.nextLine();
        System.out.print("Enter your Password: ");
        String password=read.nextLine();
        if("player".equals(choice.toLowerCase())){
            Player player=new Player(name,age,nationalId,phone,address,sex,username,email,password);
            system.addPlayer(player);
            while(true){
                System.out.println("1- Search for playground");
                System.out.println("2- Logout");
                int ans=read.nextInt();
                if(ans==1){
                    System.out.print("Enter the number of hours needed: ");
                    int hours=read.nextInt();
                    System.out.print("Enter the time you want to start by: ");
                    int startHour=read.nextInt();
                    System.out.println("Choose a playground to request to book");
                    system.searchAndDisplayPlaygrounds(hours, startHour);
                    int choice1=read.nextInt();
                    Playground requestedPlayground=system.resultPlaygrounds.get(choice1-1);
                    Request request=new Request(hours,requestedPlayground,player,startHour,"waiting");
                    player.addRequest(request);
                    requestedPlayground.owner.addRequest(request);
                    System.out.println("You have requested to book playground "+ choice1 +" successfully.");
                    System.out.println("Please wait for the playground's owner reply.");
                }
                else if(ans==2){
                    break;
                }
            }
        }
        else if("playground owner".equals(choice.toLowerCase())){
            PlaygroundOwner owner=new PlaygroundOwner(name,age,nationalId,phone,address,sex,username,email,password);
            system.addPlaygroundOwner(owner);
            while(true){
                System.out.println("1- Add Playground");
                System.out.println("2- My requests");
                System.out.println("3- Logout");
                int ans=read.nextInt();
                if(ans==1){
                    System.out.print("Playground Price per hour with L.E: ");
                    int price=read.nextInt();
                    System.out.print("Playground opening hour: ");
                    int ohour=read.nextInt();
                    System.out.print("Playground closing hour: ");
                    int chour=read.nextInt();
                    Playground ground=new Playground(price,ohour,chour,owner);
                    system.addWaiting(ground);
                    System.out.println("Waiting for admin check.");
                }
                else if(ans==2){
                    System.out.println("You don't have requests.");
                }
                else if(ans==3){
                    break;
                }
            }
        }
    }
}