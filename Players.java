import java.lang.*;
import java.util.*;
class Players{
    // This class is used to get input of players' names
    int nPlayers;
    List<String> players = new ArrayList<>();;
    Scanner sc = new Scanner(System.in);
    Players(int nPlayers){
        this.nPlayers = nPlayers;
    }
    List<String> playersInput(){
        System.out.println("Enter names of players : ");
        for(int i=0; i<nPlayers;i++){
    	   players.add(sc.next());
    	}
        return players;
    }
}