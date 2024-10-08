//This is the class we use to create our dice, which store the current value and the previous value of the die.
//We use the random funktion to get a random value between 1 and 6.

import java.util.Random;

public class Die {
    public int dieValue;
    public int prevDieValue;
    String dieName = "";
    Random random = new Random();

    public Die(String dName){
        dieName = dName;
    }

    public void rollDie(){
        prevDieValue = dieValue;
        dieValue = random.nextInt(6) + 1;
    }
}