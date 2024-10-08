import java.io.IOException;
import java.util.Random;

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

        while (!player1Won && !player2Won){
            System.out.println("The scoreboard is currently:");
            System.out.println("Player1: " + player1Point);
            System.out.println("Player2: " + player2Point);
            System.out.println("Press Enter to continue with " + playerTurn + "'s turn");
            try{scanner.nextLine();}
            catch(Exception e){}  
            
                if(playerTurn.equals("Player1")){
                    player1Die1.rollDie();
                    player1Die2.rollDie();
                    player1Point += (player1Die1.dieValue + player1Die2.dieValue);
                    System.out.println("Player1 just rolled a " + player1Die1.dieValue + " and a " + player1Die2.dieValue);
                    
                    if((player1Die1.dieValue == player1Die2.dieValue)){
                        playerTurn = "Player1";
                        System.out.println("Player1 has rolled the same value on both dice and therefore gets another turn");
                    } else{
                        playerTurn = "Player2";
                    } 
                }
            }   
        }
    }
