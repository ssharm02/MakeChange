/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarth
 */
public class Coin {
    private int quarterCount;
    private int nickelCount;
    private int dimeCount;
    private int roundOff;
    private int amount;
    
    //Empty Constructor
    public Coin() {}
    
    //Argument Constructor
    
    public Coin (int quarterCount, int nickelCount, int dimeCount, int roundOff, int amount) {
        this.dimeCount = dimeCount;
        this.quarterCount = quarterCount;
        this.nickelCount = nickelCount;
        this.roundOff = roundOff;
        this.amount = amount;
    }

    //Accessors and mutators 
    public void setAmount(int amount) throws BadChangeException{
        if (amount <= 3 || amount > 100) 
        {
            throw new BadChangeException();
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getQuarterCount() {
        return quarterCount;
    }

    public int getNickelCount() {
        return nickelCount;
    }

    public int getDimeCount() {
        return dimeCount;
    }

    public int getRoundOff() {
        return roundOff;
    }

    public void setQuarterCount(int quarterCount) {
        this.quarterCount = quarterCount;
    }

    public void setNickelCount(int nickelCount) {
        this.nickelCount = nickelCount;
    }

    public void setDimeCount(int dimeCount) {
        this.dimeCount = dimeCount;
    }

    public void setRoundOff(int roundOff) {
        this.roundOff = roundOff;
    }
    
    //This method makes the change 
    public String makeChange (int amount) throws BadChangeException  {
        
        int temp = amount;
        int [] makeChange = {0, 0, 0};
        roundOff = amount % 10;
       
        if (roundOff <= 2) 
        {
            amount = amount - roundOff;
        }
        if(roundOff >=3 && roundOff <= 7) 
        {
            amount = amount - roundOff;
            amount = amount + 5;
        }
        if(roundOff >= 8 && roundOff <=10) 
        {
            amount = amount - roundOff;
            amount = amount + 10;
        }
        if (amount >= 25) 
        {
           quarterCount = amount / 25;
           amount = amount % 25;
           makeChange[0] = quarterCount;
        }
        if (amount >=  10) 
        {
           dimeCount = amount / 10;
           amount = amount % 10;
           makeChange[1] = dimeCount;
        }
        if (amount <= 5)
        {
             nickelCount = amount / 5; 
             makeChange[2] = nickelCount;
       }
        String output = "" + temp + " cents requires";
        
if (quarterCount > 0) {
  output = output + ", " + quarterCount + ((quarterCount > 1) ? " quarters" : " quarter");
  
if (dimeCount > 0) {
  output = output + ", " + dimeCount + ((dimeCount > 1)? " dimes" :" dime");
}  
if (nickelCount > 0) {
  output = output + ", " + nickelCount + ((nickelCount > 1) ? " nickels":" nickel");
} 
else {
  output = output + "";
}
} 
else if (dimeCount > 0) {
    output = output + ", " + dimeCount + ((dimeCount > 1)? " dimes":" dime");
} 
else if (nickelCount > 0) {
   output = output + ", " + nickelCount + ((nickelCount > 1)? " nickels":" nickel");
} 
else {
    output = output + "";
}
    return output;
    }
}

