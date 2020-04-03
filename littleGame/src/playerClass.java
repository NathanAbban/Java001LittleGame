/*--------------------------------------------------------------------------
/**
 * Created:  		20/10/2018
 * Last amended: 	30/12/2019
 * Version:  		1.0
 * @author              NathanAbban
 * Filename: 		playerClass.java
--------------------------------------------------------------------------*/

import javax.swing.*;
import java.util.Random;


public class playerClass {
private static int playerCount;

// now define variable that can only be accessed fron within this object
// hence use of 'private.

    private int lives = 1;
    private final String name; // constant - won't change
    private final String catchPhrase; // ditto
    private int strength; // Dead if 0
    private int cunning;
    private String currentWeapon;
    private int weaponPtr; // ref to current weapon
    private String[] weapons = {"ESD Band of pain", "Cockney Killer Eels", "Screwdriver of Torquemada","Screenwipe of death","CPU of confusion"};
    /**
     *
     */
    public boolean alive = true;

    // Notice - no main method in this class!

    // this is the constructor for this class. It is called when a new object is created
    // and provides all the details needed to populate the new instance
    /**
     * creates a new player
     * @param name name of the player
     * @param cunning initial cunning level
     * @param strength initial strength level
     * @param catchPhrase the players catch phrase
     */
    public playerClass(String name, int cunning, int strength, String catchPhrase)
{
    this.name = name;
    this.cunning = cunning;
    this.strength = strength;
    this.catchPhrase = catchPhrase;
    this.currentWeapon = this.weapons[0]; // start with basic weapon
    this.weaponPtr = 0;
    // increment playerCount as we have created another instance of playerClass
    playerCount++;
}

// now the methods

private void sayCatchPhrase()
{
    JOptionPane.showMessageDialog(null, this.name + " says '" + this.catchPhrase + "'");
}

/**
 * shows the current status of the playerClass
 */
public void showPlayerDetails()
{
    JOptionPane.showMessageDialog(null,"Name: " + this.name + " "
            + "\nCatch Phrase: " + catchPhrase
            + "\nStrength: " + strength
            + "\nCunning: " + this.cunning
            + "\nLives remaining: " + this.lives
            + "\nCurrent Weapon: " + this.currentWeapon, this.name, 1);
}

public void incWeapon()
{    System.out.println("this.weaponPtr = " + this.weaponPtr);
     System.out.println("this.weapons[weaponPtr] = " + this.weapons[weaponPtr]);
    if (weaponPtr < weapons.length) weaponPtr++;
     this.currentWeapon = this.weapons[weaponPtr];;
}

public void decWeapon()
{    
    if (weaponPtr > 0) weaponPtr--;
     this.currentWeapon = this.weapons[weaponPtr];;
}


/**
 * increments the players strength
 */
public void incStrength()
{
     this.strength++;
}

/**
 * decrements the players strength
 */
public void decStrength()
{
    this.strength--;
    if (this.strength <= 0) this.strength = 0;
}

/**
 * increments the players cunning
 */
public void incCunning()
{
     this.cunning++;
}

/**
 * decrements the players cunning
 */
public void decCunning()
{
    this.cunning--;
    if (this.cunning <= 0) this.cunning = 0;
}

/**
 * increments the players life value
 */
public void incLifes()
{
    //if (this.lives == 5) return;
    this.lives++;
}

/**
 * decrements the players life value
 */
public void decLifes()
{
    this.lives--;
    if (this.lives <= 0)
     {
         this.alive = false;
         JOptionPane.showMessageDialog(null, this.name + " is dead!");
     }
}

private void fightingTalk()
    {
        Random generator = new Random();
        int number = generator.nextInt(8);
        switch (number)
        {
            case 1:
            {
               JOptionPane.showMessageDialog(null, "Ouch!");
                break;
            }
            case 2:
            {
                JOptionPane.showMessageDialog(null, "KerPow!");
                break;
            }
            case 3:
            {
                JOptionPane.showMessageDialog(null, "Zamm!");
                break;
            }
            case 4:
            {
               JOptionPane.showMessageDialog(null, "Biff!");
                break;
            }
            case 5:
            {
                JOptionPane.showMessageDialog(null, "Take that!!");
                break;
            }
            case 6:
            {
                JOptionPane.showMessageDialog(null, "'av some of that!!");
                break;
            }
            case 7:
            {
                JOptionPane.showMessageDialog(null, "Owwww!!");
                break;
            }
            case 8:
            {
                JOptionPane.showMessageDialog(null, "i'm a Cockney geezer!!");
                break;
            }
        } // end of switch
    } // end of speak

/**
 *
 * @param opponent who you wnat to fight!
 */
public void fights(playerClass opponent)
{
   
    JOptionPane.showMessageDialog(null, this.name + " and " + opponent.name + " are fighting!", "Fight!",1);

    this.sayCatchPhrase();
    opponent.sayCatchPhrase();
    
    // show 'fighting talk' messages!
    for (int x =0; x <= 5; x++)
    {
        this.fightingTalk();
    }

    // find the winner
    if (this.strength > opponent.strength)
    {
        opponent.decLifes();
        this.incStrength();
        this.incWeapon();
        JOptionPane.showMessageDialog(null, this.name + " wins the fight against " + opponent.name,"Winner",1);
    }
    else if (this.strength == opponent.strength)
    {
       JOptionPane.showMessageDialog(null, "It's a draw between " + this.name + " and " + opponent.name,"Draw",1);
    }
    else
    {
        opponent.incStrength();
        this.decLifes();
        JOptionPane.showMessageDialog(null, opponent.name + " wins the fight against " + this.name,"Winner",1);
    }
}

} // end of program!!
