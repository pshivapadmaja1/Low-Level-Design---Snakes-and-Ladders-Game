import java.lang.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the length and breadth of board : ");
	    int length = sc.nextInt(), breadth = sc.nextInt();
	    snakedAndLadders sl = new snakedAndLadders(length, breadth);
	    
	    System.out.println("Enter the total number of snakes : ");
	    int nSnakes = sc.nextInt();
	    HashMap<Integer,Integer> snakes = sl.snakeInput(nSnakes);
	    
	    System.out.println("Enter the total number of ladders : ");
	    int nLadders = sc.nextInt();
	    HashMap<Integer,Integer> ladders = sl.ladderInput(nLadders);
	    
	    System.out.println("Enter total number of players : ");
        int nPlayers = sc.nextInt();
        List<String> players = new ArrayList<>();
	    Players p = new Players(nPlayers); // To store names of players
	    players = p.playersInput(); // To take input from the users
	    
	    System.out.println("Enter number of dice : ");
	    int noOfDice = sc.nextInt();
	    HashMap<String,Integer> np = new HashMap<>(); // To store names of players and their respective positions
    	for(String z : players){
    	    np.put(z,0);
    	}
    	int f=0;
    	System.out.println("************************ Welcome to Snakes and Ladders Game **************************** ");
	    while(true){
    	    for(String z : players){
    	        int diceInput = (int)(Math.random()*(6*noOfDice-noOfDice+1))+noOfDice; // Generates a random value of dice
    	        int curPos = np.get(z)+diceInput;
    	        // If there is any snake in the current position, then the player should move to it's tail position
    	        if(snakes.containsKey(curPos))
    	            curPos = snakes.get(curPos);
    	        // If there is any ladder in the current position, then the player should move to it's head position
    	        else if(ladders.containsKey(curPos))
    	            curPos = ladders.get(curPos);
    	        // If a player reached the destination, then he will be the winner
    	        if(curPos==length*breadth){
    	            players.remove(z);
    	            System.out.println("Congratulations "+z+". You are the winner.");
    	            players = players;
    	            // If only one player left in the game, then he will be the looser
    	            if(players.size()==1){
    	                System.out.println("Looser is "+players.get(0));
    	                f=1;
    	                break;
    	            }
    	        }
    	        // If the position of a player exceeds the destination, then he will be left at the same position
    	        // Otherwise, his he will be moved to new position
    	        else if(curPos<length*breadth){
    	            np.put(z,curPos);
    	            System.out.println(z+" got chance and moved to "+curPos);
    	        }
    	    }
    	    if(f==1)
    	        break;
    	   //End of a round
    	    System.out.println("**********************************");
	    }
	}
}