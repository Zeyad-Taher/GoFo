package gofoo;
import java.util.Scanner;

/**
 * The main class function where we will test the classes implemented and it is responsible for showing
 * the main menu options to the user.
 * @author Zeyad Taher
 * @version 1.0 June 11, 2021
 */

public class GoFoo {
    
    public static void main(String[] args) {
        UserInterface ui=new UserInterface();
        Scanner read = new Scanner( System.in );
        while(true){
            System.out.println("Choose one of the following options:");
            System.out.println("1- Login as Admin");
            System.out.println("2- Login as playground owner");
            System.out.println("3- Register as player or playground owner");
            System.out.println("4- Exit");
            int ans=read.nextInt();
            if(ans!=4){
                if(ans==1){
                    ui.userLogin();
                }
                else if(ans==2){
                    ui.ownerLogin();
                }
                else if(ans==3){
                    ui.register();
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}