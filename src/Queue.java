/** Queue.java stores all of the moves and gives them back as requested
  *
  * @author			Justin Schafer
  * @id				jdschafer
  * @course			Programming 2 CSIS 252
  * @assignment		Lab 3 Simon
  * @related		Simon.java
  * @included		
  */

public class Queue {
    protected int head;
    protected int tail;
    protected Object[] queue;
    protected final int MAX = 1000;
    protected int origCap;
    protected int elements;
    
    public Queue() {
        queue = new Object[MAX];
        origCap = MAX;
    	head = 0;
        tail = -1;
        elements = 0;
    }
    
    public void enQueue(Object item) {
    	if(queue.length == elements)
    		grow();
    	tail = tail + 1 % queue.length;
    	queue[tail] = item;
    	elements = elements + 1;
    }
    
    public Object deQueue() {
    	if(isEmpty()) 
    	    return null;
        Object copy = queue[head];
    	queue[head] = null;
    	head = head + 1 % queue.length;
    	elements = elements - 1;
    	return copy;
    }
    
    public Object peek() {
    	return queue[head];
    }
    
    public Object peek(int loc) {
    	return queue[loc];
    }
    
    public void grow() {
    	Object[] grown = new Object[queue.length + origCap];
    	int currSmaller = head;
    	for(int currLarger = 0; currLarger < elements; currLarger ++) {
    		grown[currLarger] = queue[currSmaller];
    		currSmaller = currSmaller++ % queue.length;
    	}
    	
    	queue = grown;
    	head = 0;
    	tail = elements - 1;
    }
    
    public boolean isEmpty() {
        if(elements == 0)
            return true;
        else return false;
    }
    
}