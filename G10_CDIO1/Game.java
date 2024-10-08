import java.io.IOException;
import java.util.Random;
//This is the main class of the game, which creates and handles the different objects
//This is also where every check of the roll output is handled

class Game {
    
    public static void main(String[] args){
        String playerTurn = "Player1";
        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);

        int player1Point = 0;
        int player2Point = 0;

        Boolean player1Won = false;
        Boolean player2Won = false;

        Die player1Die1 = new Die("player1Die1");
        Die player1Die2 = new Die("player1Die2");
        Die player2Die1 = new Die("player2Die1");
        Die player2Die2 = new Die("player2Die2");

        //Make the game continue until a player has met the winning criterias and therefore wins the game.
        while (!player1Won && !player2Won){
            System.out.println("The scoreboard is currently:");
            System.out.println("Player1: " + player1Point);
            System.out.println("Player2: " + player2Point);
            System.out.println("Press Enter to continue with " + playerTurn + "'s turn");

            //Here we make the program run the next time the Enter butten has been pressed, and then depending on
            //whether its player1's or player2's turn do 2 different things.
            try{scanner.nextLine();}
            catch(Exception e){}  
            
                if(playerTurn.equals("Player1")){
                    player1Die1.rollDie();
                    player1Die2.rollDie();
                    player1Point += (player1Die1.dieValue + player1Die2.dieValue);
                    System.out.println("Player1 just rolled a " + player1Die1.dieValue + " and a " + player1Die2.dieValue);
                    
                    if((player1Die1.dieValue == player1Die2.dieValue)){
                        if(player1Point>=40){
                            player1Won = true;
                            break;
                        }
                        playerTurn = "Player1";
                        System.out.println("Player1 has rolled the same value on both dice and therefore gets another turn");
                        if(player1Die1.dieValue == 1 && player1Die2.dieValue == 1){
                            player1Point = 0;
                            System.out.println("Player1 has rolled two 1's and therefore their points get reset");
                        }
                        if(player1Die1.dieValue == 6 && player1Die2.dieValue == 6 && player1Die1.prevDieValue == 6 && player1Die2.prevDieValue == 6){
                            System.out.println("Player1 has gotten double 6 two rounds in a row and therefore wins the game!");
                            break;
                    }
                    } else{
                        playerTurn = "Player2";
                    } 
                }
                else if(playerTurn.equals("Player2")){
                    player2Die1.rollDie();
                    player2Die2.rollDie();
                    player2Point += (player2Die1.dieValue + player2Die2.dieValue);
                    System.out.println("Player2 just rolled a " + player2Die1.dieValue + " and a " + player2Die2.dieValue);
                    if((player2Die1.dieValue == player2Die2.dieValue) && playerTurn.equals("Player2")){
                        if(player2Point>=40){
                            player2Won = true;
                            break;
                        }
                        playerTurn = "Player2";
                        System.out.println("Player2 has rolled the same value on both dice and therefore gets another turn");
                        if(player2Die1.dieValue == 1 && player2Die2.dieValue == 1){
                            player2Point = 0;
                            System.out.println("Player2 has rolled two 1's and therefore their points get reset");
                        }
                        if(player2Die1.dieValue == 6 && player2Die2.dieValue == 6 && player2Die1.prevDieValue == 6 && player2Die2.prevDieValue == 6){
                            System.out.println("Player2 has gotten double 6 two rounds in a row and therefore wins the game!");
                            break;
                        }
                    }
                    else{
                        playerTurn = "Player1";
                    }
                }
            }

            //When the winning criterias has been met we break out of the loop and run these next lines to display the winner
            //of the game. We also simulate a test of 1000 dice throws, to see if the dice are working correctly.
            if(player1Won){
            System.out.println("Player1 has reached " + player1Point + " points and rolled a double, and has therefore won the game!");
        } 
        else if(player2Won){
            System.out.println("Player2 has reached " + player2Point + " points and rolled a double, and has therefore won the game!");
        }
        //To run the test of a thousand throws, run this next line:
        System.out.println(ThousandThrows.simulateThrows(1000));   
        }
    }
