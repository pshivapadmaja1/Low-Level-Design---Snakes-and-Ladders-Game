import java.lang.*;
import java.util.*;

class snakedAndLadders{
    int  length, breadth;
    HashMap<Integer,Integer> ladders = new HashMap<>();
    HashMap<Integer,Integer> snakes = new HashMap<>();
    snakedAndLadders(int length,int breadth){
        this.length = length;
        this.breadth = breadth;
    }
    HashMap<Integer,Integer> snakeInput(int nSnakes){
        // This method is used to generate positions of snakes on board randomly.
	    while (nSnakes--!=0){
	        while(true){
    	        int snakeHead = (int)(Math.random()*(length*breadth-breadth-1))+breadth+1;
    	        int snakeTail = (int)(Math.random()*(length*breadth-breadth))+1;
    	        if(snakeHead>snakeTail){
    	            this.snakes.put(snakeHead,snakeTail);
    	            break;
    	        }
	        }
	    }
	    System.out.println("The following are the randomly generated positions of snakes : ");
	    for(Map.Entry i:snakes.entrySet()){
	        System.out.println(i.getKey()+" "+i.getValue());
	    }
	    this.snakes = snakes;
	    return snakes;
	}
	HashMap<Integer,Integer> ladderInput(int nLadders){
	    // This method is used to generate ladder positions on board randomly.
	    while (nLadders--!=0){
	        while(true){
    	        int ladderHead = (int)(Math.random()*(length*breadth-breadth-1))+breadth+1;
    	        int ladderTail = (int)(Math.random()*(length*breadth-breadth))+1;
    	        if(ladderHead>ladderTail && (!snakes.containsKey(ladderHead) && !snakes.containsKey(ladderTail))){
    	            ladders.put(ladderTail,ladderHead);
    	            break;
    	        }
	        }
	    }
	    
	    System.out.println("The following are the randomly generated positions of ladders : ");
	    for(Map.Entry j:ladders.entrySet()){
	        System.out.println(j.getKey()+" "+j.getValue());
	    }
	    this.ladders = ladders;
	    return ladders;
	}
	HashMap<Integer,Integer> getLadders(){
	    return ladders;
	}
	HashMap<Integer,Integer> getSnakes(){
	    return snakes;
	}
}