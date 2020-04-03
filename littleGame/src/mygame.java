/*--------------------------------------------------------------------------
/**
 * Created:  		20/10/2018
 * Last amended: 	23/12/2019
 * Version:  		1.0
 * @author              NathanAbban
 * Filename: 		mygame.java
 * Description: 	Class containing general utility methods for the littleGame
 * Purpose:             To show how Event driven and Object Orientated Paradigms 
                        can be used in a single program, and to have a bit of fun!
--------------------------------------------------------------------------*/

// import the following Java library. This will allow us to
// create GUI dialogs

import javax.swing.JOptionPane;

public class mygame
{ // start of game program  
    public static void main(String[] args)
    { // start of main method
        
       // create a boolean to use in do..while loop
       // to see if user wants to play again
        
        boolean playAgain = false; 
       
       // Create (instanciate) playerClass objects - Parameters: name, cunning, strength, catch phrase
       // This the Object Orientated Paradigm in action!
       // sequence construct here!
       
       playerClass CHashMan = new playerClass("C# Man", 4, 1,"I'm gonna take you out to dinner with Mr & Mrs Pain");
       playerClass basicBoy = new playerClass("BASIC Boy", 3,5,"Coming at you like a northern bullet");
       playerClass perlGirl = new playerClass("Perl Girl", 4,7, "Don't mess with my ESD Band");

       // Now ask the user for info to create their playerClass
       // The input dialogs will not accept the values until the users clicks
       // on the OK button. This is the Event driven Paradigm in action!
       // sequence construct here!
       
       String playerName = Utility.getString("Please enter the name of your player");
       int playerCunning = Utility.getInt("Please enter a Cunning level for your playe [1..5]", 1, 5);
       int playerStrength = Utility.getInt("Please enter a Strength level for your playe [1..5]", 1, 5); 
       String playerCatchPhrase = Utility.getString("Please enter the Catch Phrase of your player");
       
       // now we can create the new playerClass based on the details given
       // this is done on the fly during execution time!
       playerClass userPlayer = new playerClass(playerName,playerCunning,playerStrength,playerCatchPhrase);
       
       // give the user playerClass another 'life' - being generous here!
       userPlayer.incLifes();
       
       
       // show the details of all the players
       // sequence construct here!
       
       userPlayer.showPlayerDetails();
       CHashMan.showPlayerDetails();
       basicBoy.showPlayerDetails();
       perlGirl.showPlayerDetails();
    
       // now we have a do .. while loop to go round
       // until user wants to stop playing
       // all the actual gameplay code is inside the loop
       
       do
       { // start of do .. while loop
       
            // ask the user who they want to fight!
      
            int choice = Utility.getInt("Enter\n"
                                 + "1 to fight C# Man\n"
                                 + "2 to fight BASIC Boy\n"
                                 + "3 to fight Perl Girl", 1, 3);
       
            // now fight the selected playerClass
            // selection construct here!
       
            switch (choice) 
            { // start of switch
               case 1: // gonna fight C# Man!
               {
                   userPlayer.fights(CHashMan);
                   userPlayer.showPlayerDetails();
                   CHashMan.showPlayerDetails();
                   break;
               }
                   
                case 2: // Gonna mix it with BASIC Boy
               {
                   userPlayer.fights(basicBoy);
                   userPlayer.showPlayerDetails();
                   basicBoy.showPlayerDetails();
                   break;
               }   
                    
                case 3: // Gonna duff up Perl Girl
               {
                   userPlayer.fights(perlGirl);
                   userPlayer.showPlayerDetails();
                   perlGirl.showPlayerDetails();
                   break; 
               }    
            } // end of switch            
           
            // Ask if user wants to play again
            
           int input = Utility.getInt("Enter\n"
                        + "1 to Play Again\n"
                        + "2 to Quit Game", 1, 2);
           
           // use if ..else Selection construct to see if user wants to play again
           // note use of == this reads as 'is equal to'
           
           if (input == 1)
           {
               playAgain = true; 
           }   
           
           else
           {
               playAgain = false; // input must be 2
           }
           
       } while(playAgain == true); // this is the bottom of the loop
       
       // game over, say goodbye! = The object JOptionPane and its showMessage
       // method is being used here
       
        JOptionPane.showMessageDialog(null, "Thanks for playing!","Bye Bye",1, null);   
            
    } // end of main block
} // end of class block
