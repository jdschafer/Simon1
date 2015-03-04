/** Simon.java handles the game which implements the queue class
  *
  * @author			Justin Schafer
  * @id				jdschafer
  * @course			Programming 2 CSIS 252
  * @assignment		Lab 3 Simon
  * @related		Queue.java
  * @included		
  */

import java.util.*;

public class Simon {
    
    static Scanner console;
    private Queue queue;
    static Simon simon;
    static String input;
    private int count;
    
    public Simon() {
        console = new Scanner(System.in);
        input = "";
        count = 0;
    }
    
    public static void main(String[] args) {
        simon = new Simon();
    	
        System.out.println("Would you like to start Simon? (Y) or (N)");
        input = console.nextLine();
        
        if(input.equalsIgnoreCase("Y"))
            simon.makeQueue();
        else {
            while(!input.equalsIgnoreCase("Y")) {
                System.out.println("Would you like to start Simon? (Y) or (N)");
                input = console.nextLine();
            }
            simon.makeQueue();
        }
    }
    
    public void makeQueue() {
    	queue = new Queue();
    	compTurn();
    }
    
    public void compTurn() {
    	double random = Math.random();
    	
    	if(random >= 0 && random <= 0.25)
    		queue.enQueue("up");
    	else if(random > 0.25 && random <= 0.5)
    		queue.enQueue("right");
    	else if(random > 0.5 && random <= 0.75)
    		queue.enQueue("down");
    	else if(random > 0.75 && random <= 1)
    		queue.enQueue("left");
    	
    	for(int i = queue.head; i < queue.tail + 1; i++ ) {
    		System.out.println(queue.peek(i));
    		try {
    		    Thread.sleep(500);
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
    	}
    	
    	try {
		    Thread.sleep(500);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
    	
    	System.out.println("\n\n\n\n\n\n\n\n\n\n");
    	
    	playerTurn();
    }
    
    public void playerTurn() {
    	count = count + 1;
    	System.out.println("Turn " + count);
    	
    	for(int i = 0; i < queue.elements; i++) {
    		input = console.nextLine();
    		if(!input.equalsIgnoreCase((String) queue.peek(i))) {
    			loss();
    		}
    	}
    	
    	compTurn();
    	
    }
    
    public void loss() {
    	System.out.println("Sorry, you've lost!  Try again next time.");
    	System.exit(0);
    }
    
    
}