import java.util.Scanner;
/**
 * 
 * Sarthak Sharma
 * PROG24178 JAVA 2 Professor Johnathan Penava 
 * Summary: Student Class for Assignment 1
 * OOP Java 2
 * Make change program consisting of a makeChange method.  Gets integer input from user
 * calculates the amount of quarters, dimes and nickles in the change.
 */
/**
 *
 * @author SarthaksComp
 */

public class makeChange {
    
    public static void main (String [] args) throws BadChangeException {
        try 
        {
            Scanner input = new Scanner (System.in);
            System.out.println("Enter an amount between 3 and 100, whole amount only no decimal");
            //Create new instance of the coin class
            Coin coin = new Coin();
            //get the amount from the user
            int amount = coin.getAmount();
            amount = input.nextInt();
        
            if (amount <= 0 || amount > 100) 
            {
                throw new BadChangeException ();
            }
            System.out.println(coin.makeChange(amount));
        }
        catch (BadChangeException bce)
        {
            System.out.println("Cannot calculate change");
        }
        catch (NullPointerException npe) 
        {
           System.out.println("You have entered an invalid input");
        }
        catch (Exception e)
       {
           System.out.println("You have entered bad input");
       }
}
}