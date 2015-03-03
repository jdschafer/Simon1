public class Simon {
    
    static scanner console;
    private Queue queue;
    static String input;
    
    public Simon() {
        console = new scanner(system.in);
        input = "";
    }
    
    public void main(String[] args) {
        queue = new Queue();
        
        System.out.println("Would you like to start Simon?");
        input = console.nextLine();
        
        if(input.equalsIgnoreCase("Y")
            startGame();
        else 
            while(!input.equalsIgnoreCase("Y")) {
                System.out.println("Would you like to start Simon?");
                input = console.nextLine();
            }
    }
    
    public void startGame() {
        
    }
    
    
}