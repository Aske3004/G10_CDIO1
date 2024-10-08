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
        
    }
}