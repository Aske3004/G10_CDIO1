import java.util.HashMap;
// In this part of the code, we have created a loop that keeps count of the values for a set number of dice throws.
// We utilize a class called Die for the dice functionality. This program returns a HashMap with the value of each throw
// and the number of times it occurred in the set number of throws.
// made by Peter wulff (s234879)
public class ThousandThrows{
    public static HashMap <Integer, Integer> simulateThrows(int numberOfThrows) {
        HashMap<Integer,Integer> throwsMap = new HashMap<>();
        throwsMap.put(2, 0);
        throwsMap.put(3, 0);
        throwsMap.put(4, 0);
        throwsMap.put(5, 0);
        throwsMap.put(6, 0);
        throwsMap.put(7, 0);
        throwsMap.put(8, 0);
        throwsMap.put(9, 0);
        throwsMap.put(10, 0);
        throwsMap.put(11, 0);
        throwsMap.put(12, 0);

        int doublesHit = 0;
        System.out.println("Running a test of a thousand throws:");

// This for loop runs the number of times specified by the set number of throws. It rolls two dice and checks if they have the same value.
// If they do, the doublesHit counter is incremented by one. Then, we look up the sum of the dice in the HashMap and increment the value associated with that sum by one.

    for(int i =0 ; i<=numberOfThrows; i++){
        Die testDie1 = new Die("testDie1");
        Die testDie2 = new Die("testDie2");
        testDie1.rollDie();
        testDie2.rollDie();
        if(testDie1.dieValue == testDie2.dieValue){
            doublesHit++;
        }

        int the_throw = testDie1.dieValue + testDie2.dieValue;
        throwsMap.put(the_throw, throwsMap.get(the_throw) + 1);
    }

    System.out.println("Doubles hit in test: " + doublesHit);
    System.out.println("Different values with 2 dice:");
    return throwsMap;
}
}