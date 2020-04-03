/**
 * Created:  		20/10/2018
 * Last amended: 	10/12/2019
 * Version:  		1.0
 * @author              NathanAbban
 * Filename: 		Utility.java
 * Description: 	Class containing general utility methods
 *                          for the littleGame
 */
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.text.*;
import java.text.NumberFormat.*;


public class Utility
{
    /**
     * used to show current version of class
     */
    public final static String version = "Utility Class V1.0";

    /**
     * Retrieves an integer within a given range of values
     * @param message String for input prompt
     * @param minVal min value allowed to input
     * @param maxVal max value allowed to input
     * @return int value inputted by user
     */
    public static int getInt(String message, int minVal, int maxVal)
    {
    // LOCAL variables - These only exist whilst method is running
    boolean notFinished; // used to repeat do..while loop until a valid input inputted
    int input = 0; // integer to evaluate.

     do // keep looping until valid confirmed input received
     {
        notFinished = false; // exit condition boolean

         // retrieve string input from user
         String txtInput = JOptionPane.showInputDialog(message);

        // now use try -  catch to see if input is an integer
        try {
                input = Integer.parseInt(txtInput); // can it be converted to an int?
            } // end of try block

        catch(NumberFormatException ex) { // input CANNOT be converted to int!!
                JOptionPane.showMessageDialog(null,txtInput + " is not a valid input");
                notFinished = true; // need to set true so loop goes round again
            } // end of catch block

         // now check if input is outside valid range
         // this reads.. if input is a valid number but is less than minVal OR greater than maxVal
         if ((notFinished == false) && (input < minVal ) || (input > maxVal))
            {
                //number is out of permitted range
                JOptionPane.showMessageDialog(null," Please enter a value between " + minVal + " and " + maxVal);
                notFinished = true; // need to set true so loop goes round again
            }

     } // end of do .. while loop. Read as 'While notFinished is true'
     while(notFinished);
     return input; // send the value back to the calling method
} // end of getInt block

    /**
     * Retrieves a float within a given range of values
     * @param message String for input prompt
     * @param minVal min value allowed to input
     * @param maxVal max value allowed to input
     * @return float value inputted by user
     */
    public static float getFloat(String message, float minVal, float maxVal)
    {
    // LOCAL variables - These only exist whilst method is running
    boolean notFinished; // used to repeat do..while loop until a valid input inputted
    float input = 0; // float to evaluate.

     do // keep looping until valid confirmed input received
     {
        notFinished = false; // exit condition boolean

         // retrieve string input from user
         String txtInput = JOptionPane.showInputDialog(message);

        // now use try -  catch to see if input is a float
        try {
                input = Float.parseFloat(txtInput); // can it be converted to a float?
            } // end of try block

        catch(NumberFormatException ex) { // input CANNOT be converted to float!!
                JOptionPane.showMessageDialog(null,txtInput + " is not a valid input");
                notFinished = true; // need to set true so loop goes round again
            } // end of catch block

         // now check if input is outside valid range
         // this reads.. if input is a valid number but is less than minVal OR greater than maxVal
         if ((notFinished == false) && (input < minVal ) || (input > maxVal))
            {
                //number is out of permitted range
                JOptionPane.showMessageDialog(null," Please enter a value between " + minVal + " and " + maxVal);
                notFinished = true; // need to set true so loop goes round again
            }

     } // end of do .. while loop. Read as 'While notFinished is true'
     while(notFinished);
     return input; // send the value back to the calling method
} // end of getFloat block


    /**
     * Retrieves a byte within a given range of values
     * @param message String for input prompt
     * @param minVal min value allowed to input
     * @param maxVal max value allowed to input
     * @return byte value inputted by user
     */
    public static byte getByte(String message, byte minVal, byte maxVal)
    {
    // create LOCAL variables - These only exist whilst method is running
    boolean notFinished; // used to repeat do..while loop until a valid input inputted
    byte input = 0; // byte to evaluate.

     do // keep looping until valid confirmed input received
     {
        notFinished = false; // exit condition boolean

         // retrieve string input from user
         String txtInput = JOptionPane.showInputDialog(message);

        // now use try -  catch to see if input is an integer
        try {
                input = Byte.parseByte(txtInput); // can it be converted to an byte?
            } // end of try block

        catch(NumberFormatException ex) { // input CANNOT be converted to byte!!
                JOptionPane.showMessageDialog(null,txtInput + " is not a valid input");
                notFinished = true; // need to set true so loop goes round again
            } // end of catch block

         // now check if input is outside valid range
         // this reads.. if input is a valid number but is less than minVal OR greater than maxVal
         if ((notFinished == false) && (input < minVal ) || (input > maxVal))
            {
                //number is out of permitted range
                JOptionPane.showMessageDialog(null," Please enter a value between " + minVal + " and " + maxVal);
                notFinished = true; // need to set true so loop goes round again
            }

     } // end of do .. while loop. Read as 'While notFinished is true'
     while(notFinished);
     return input; // send the value back to the calling method
} // end of getByte block

    /**
     * Retrieves a String
     * @param message String for input prompt
     * @return String value inputted by user
     */
    public static String getString(String message)
    {
    String input = JOptionPane.showInputDialog(message);
    return input;
    }

    /**
     * Retrieves a boolean
     * @param message String for input prompt
     * @return boolean value inputted by user
     */
    public static boolean getBoolean(String message)
    {
    // this dialog shows yes & NO buttons - if No is clicked 1 is returned
    // Clicking Yes returns 0
    boolean answer = false;
        int input = JOptionPane.showConfirmDialog(
        null,message,"title", 
        JOptionPane.YES_NO_OPTION);

    if (input == 1)
        answer  = false;
    else
        answer = true;

    return answer;
} // of getBoolean

    /**
     * Makes a single beep when invoked
     */
    public static void beep()
	{
                Toolkit.getDefaultToolkit().beep();
	} // end of beep

    /**
     * Obtains the current date from the system
     * @return String representation of current date
     */
public static String getDateString()
{
    Date todaysDate = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy");
    String formattedDate = formatter.format(todaysDate);
    return formattedDate;
}
/**
 * Obtains the current time from the system
 * @return String representation of current time (HRS:MIN) in 24 Hour format
 */
public static String getTimeString()
{
    Date time = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
    String formattedTime = (formatter.format(time));
    return formattedTime;
}
/**
 * Calculates current week of the Year
 * @return int representing current week of Year [1..52]
 */
public static int getWeek()
{
    Date week = new java.util.Date();
    SimpleDateFormat formatter = new SimpleDateFormat("w");
    String formattedWeek = (formatter.format(week));
    int weekNumber = Integer.parseInt(formattedWeek);
    return weekNumber;
}
/**
 * Converts a float currency value into a formatted String with UK pound sign
 * @param input float to have formatted as UK currency
 * @return String formatted as UK Currency of float value
 */
public static String getCurrencyString(float input)
{
    //float currency = new Float(6543.21);
    NumberFormat currencyFormatter;
    String currencyOut;

    currencyFormatter = NumberFormat.getCurrencyInstance();
    currencyOut = currencyFormatter.format(input);
    return currencyOut;
}

/**
 * will exit a program if yes button pressed
 * @param message exit warning message to show
 * @param title title of
 */
    public static void exit(String message, String title)
    {
        // show a Yes / No dialog. If user selects Yes Reply set to
        // YES_OPTION and program will terminate
        int reply = JOptionPane.showConfirmDialog(null,
                                                  message
                                                  ,title,
                                                  JOptionPane.
                                                  YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            System.exit(0); // exit program with error code 0 (0 means No Error)
        }
    } // end of exit method
} // end of class!!
